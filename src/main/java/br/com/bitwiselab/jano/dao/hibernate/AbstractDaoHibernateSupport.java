package br.com.bitwiselab.jano.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.bitwiselab.jano.model.AbstractModel;

public abstract class AbstractDaoHibernateSupport extends HibernateDaoSupport {
	@Autowired
	public void setSessionFactoryAutowire(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	protected LockMode getLockMode(boolean lock) {
		return (lock ? LockMode.UPGRADE : LockMode.NONE);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List executeQuery(final String queryString,
			final List<HibernateQueryParam> params, final Integer offset,
			final Integer limit) {
		return (List) getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(queryString);

						for (HibernateQueryParam param : params) {
							query.setParameter(param.getName(),
									param.getValue(), param.getType());
						}
						if (offset != null) {
							query.setFirstResult(offset);
						}
						if (limit != null) {
							query.setMaxResults(limit);
						}
						return query.list();
					}
				});
	}

	@SuppressWarnings("rawtypes")
	protected List executeQuery(final String queryString,
			final List<HibernateQueryParam> params) {
		return executeQuery(queryString, params, null, null);
	}

	@SuppressWarnings("rawtypes")
	protected List executeQuery(final String queryString) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		return executeQuery(queryString, params);
	}

	@SuppressWarnings("unchecked")
	protected AbstractModel executeQueryUnique(final String queryString,
			final List<HibernateQueryParam> params) {
		return (AbstractModel) getUnique(executeQuery(queryString, params,
				null, 1));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected int executeUpdate(final String queryString,
			final List<HibernateQueryParam> params) {
		Integer resultado = (Integer) getHibernateTemplate()
				.executeWithNativeSession(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(queryString);

						for (HibernateQueryParam param : params) {
							query.setParameter(param.getName(),
									param.getValue(), param.getType());
						}

						return new Integer(query.executeUpdate());
					}
				});
		return resultado.intValue();
	}

	protected int executeUpdate(final String queryString) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		return executeUpdate(queryString, params);
	}

	protected <M> M getUnique(List<M> list) {
		return (!list.isEmpty() ? list.get(0) : null);
	}

}
