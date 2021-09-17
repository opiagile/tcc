package br.com.bitwiselab.jano.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.EmpresaDao;
import br.com.bitwiselab.jano.model.Empresa;

@Repository
public class EmpresaDaoHibernate extends AbstractDaoHibernate<Empresa>
		implements EmpresaDao {

}
