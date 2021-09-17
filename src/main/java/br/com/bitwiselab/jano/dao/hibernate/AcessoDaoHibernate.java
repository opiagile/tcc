package br.com.bitwiselab.jano.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.AcessoDao;
import br.com.bitwiselab.jano.model.Acesso;

@Repository
public class AcessoDaoHibernate extends AbstractDaoHibernate<Acesso> implements
		AcessoDao {

}
