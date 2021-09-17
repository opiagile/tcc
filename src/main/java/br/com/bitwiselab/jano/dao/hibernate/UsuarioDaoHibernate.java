package br.com.bitwiselab.jano.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.Usuario;
import br.com.bitwiselab.jano.util.Digests;

@Repository
public class UsuarioDaoHibernate extends AbstractDaoHibernate<Usuario>
		implements UsuarioDao {

	@Override
	public Usuario buscarAcesso(String login, String senha) {
		List<HibernateQueryParam> params = new ArrayList<HibernateQueryParam>();
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT us ");
		hql.append("  FROM Usuario us ");
		hql.append("WHERE");
		hql.append(" us.login = :login ");
		hql.append(" AND us.senha = :senha ");
		params.add(new HibernateQueryParam("login", login, Hibernate.STRING));
		String pass = Digests.digest(senha);
		params.add(new HibernateQueryParam("senha", pass, Hibernate.STRING));
		return (Usuario) executeQueryUnique(hql.toString(), params);
	}
}