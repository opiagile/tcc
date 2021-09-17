package br.com.bitwiselab.jano.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bitwiselab.jano.dao.LogLoginDao;
import br.com.bitwiselab.jano.model.LogLogin;

public class LogLoginDaoTest extends AbstractTransactionalTest {
	@Autowired
	protected LogLoginDao fixture;

	@Test
	public void mapeamento() {
		LogLogin login = fixture.buscar(1L);
		Assert.assertEquals(new Long(1), login.getId());
	}

}