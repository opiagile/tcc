package br.com.bitwiselab.jano.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.LogLoginDao;
import br.com.bitwiselab.jano.model.LogLogin;
import br.com.bitwiselab.jano.model.TipoLogLogin;
import br.com.bitwiselab.jano.model.Usuario;

@Repository
public class LogLoginDaoHibernate extends AbstractDaoHibernate<LogLogin>
		implements LogLoginDao {

	@Override
	public LogLogin buscarUltimoAcesso(Usuario usuario) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT log ");
		hql.append("  FROM LogLogin log ");
		hql.append("WHERE");
		hql.append(" log.usuario = :usuario ");
		hql.append(" AND log.tipo = :tipo");
		hql.append(" AND log.dataHora < (SELECT max(login.dataHora) FROM LogLogin login where login.usuario = :usuario and login.tipo = :tipo) ");
		hql.append("ORDER BY");
		hql.append("	log.dataHora DESC ");
		params.add(new HibernateQueryParam("usuario", usuario, Hibernate
				.entity(Usuario.class)));
		params.add(new HibernateQueryParam("tipo", TipoLogLogin.LOGIN.getId(),
				Hibernate.INTEGER));
		return (LogLogin) executeQueryUnique(hql.toString(), params);
	}
}