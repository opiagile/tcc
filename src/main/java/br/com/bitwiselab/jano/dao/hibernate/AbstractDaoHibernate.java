package br.com.bitwiselab.jano.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import br.com.bitwiselab.jano.dao.Dao;
import br.com.bitwiselab.jano.model.AbstractModel;

public abstract class AbstractDaoHibernate<M extends AbstractModel> extends
		AbstractDaoHibernateSupport implements Dao<M> {
	private static final String LISTAR_FMT = "SELECT %s FROM %s AS %s";
	protected final Class<M> modelClass = getDomainClass();

	@SuppressWarnings("unchecked")
	protected Class<M> getDomainClass() {
		Class<M> modelClass = null;
		if (modelClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass()
					.getGenericSuperclass();
			modelClass = (Class<M>) thisType.getActualTypeArguments()[0];
		}
		return modelClass;
	}

	public void salvar(M model) {
		getHibernateTemplate().saveOrUpdate(model);
	}

	public void remover(M model) {
		getHibernateTemplate().delete(model);
	}

	public M buscar(Long id) {
		M model = null;
		if (id != null) {
			model = (M) getHibernateTemplate().get(getDomainClass(), id);
		}
		return model;
	}

	protected M buscar(final String queryString,
			final List<HibernateQueryParam> params) {
		@SuppressWarnings("unchecked")
		List<M> models = executeQuery(queryString, params, null, 1);
		return models.isEmpty() ? null : models.get(0);
	}

	public M buscarOuCriar(Long id) {
		M entity = null;
		if (id != null) {
			entity = (M) getHibernateTemplate().get(getDomainClass(), id);
		} else {
			try {
				entity = (M) getDomainClass().newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return entity;

	}

	public List<M> listarTodos() {
		return listar(null, null);
	}

	@SuppressWarnings("unchecked")
	public List<M> listar(Integer offset, Integer limit) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(String.format(LISTAR_FMT, getDomainClass()
				.getSimpleName().toString().toLowerCase(),//
				getDomainClass().getSimpleName().toString(),//
				getDomainClass().getSimpleName().toString().toLowerCase()));
		List<M> models = (List<M>) executeQuery(queryString.toString(),
				new ArrayList<HibernateQueryParam>(), offset, limit);
		return models;
	}
}
