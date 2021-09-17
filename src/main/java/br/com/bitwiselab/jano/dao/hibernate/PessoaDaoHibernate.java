package br.com.bitwiselab.jano.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.model.Pessoa;

@Repository
public class PessoaDaoHibernate extends AbstractDaoHibernate<Pessoa> implements
		PessoaDao {

	@Override
	public Pessoa buscarPorIdentificacao(String identificador) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT p ");
		hql.append("  FROM Pessoa p ");
		hql.append("WHERE");
		hql.append(" p.identificador = :identificador ");
		hql.append(" and ( p.periodoPermanencia.fim is null ");
		hql.append(" or p.periodoPermanencia.fim < :data ) ");
		params.add(new HibernateQueryParam("identificador", identificador,
				Hibernate.STRING));
		params.add(new HibernateQueryParam("data", new Date(), Hibernate.DATE));
		return (Pessoa) executeQueryUnique(hql.toString(), params);
	}

}
