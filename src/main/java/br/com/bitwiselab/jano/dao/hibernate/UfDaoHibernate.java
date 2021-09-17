package br.com.bitwiselab.jano.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.UfDao;
import br.com.bitwiselab.jano.model.Uf;

@Repository
public class UfDaoHibernate extends AbstractDaoHibernate<Uf> implements UfDao {

}