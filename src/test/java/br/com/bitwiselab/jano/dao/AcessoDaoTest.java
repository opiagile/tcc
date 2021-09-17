package br.com.bitwiselab.jano.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bitwiselab.jano.dao.AcessoDao;
import br.com.bitwiselab.jano.model.Acesso;

public class AcessoDaoTest extends AbstractTransactionalTest {
	@Autowired
	protected AcessoDao fixture;

	@Test
	public void mapeamento() {
		Acesso acesso = fixture.buscar(1L);
		Assert.assertEquals(new Long(1L), acesso.getId());
	}

}