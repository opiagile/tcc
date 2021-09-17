package br.com.bitwiselab.jano.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.model.Equipamento;

@Repository
public class EquipamentoDaoHibernate extends AbstractDaoHibernate<Equipamento>
		implements EquipamentoDao {

}