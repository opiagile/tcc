package br.com.bitwiselab.jano.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.LogradouroDao;
import br.com.bitwiselab.jano.model.Logradouro;

@Repository
public class LogradouroDaoHibernate extends AbstractDaoHibernate<Logradouro>
		implements LogradouroDao {

	@Override
	public Logradouro buscarPorCep(String cep) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT lg ");
		hql.append("  FROM Logradouro lg ");
		hql.append("WHERE");
		hql.append(" lg.cep = :cep ");
		params.add(new HibernateQueryParam("cep", cep, Hibernate.STRING));
		return (Logradouro) executeQueryUnique(hql.toString(), params);
	}

}
