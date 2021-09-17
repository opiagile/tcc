package br.com.bitwiselab.jano.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bitwiselab.jano.dao.PessoaDao;
import br.com.bitwiselab.jano.model.Pessoa;

public class PessoaDaoTest extends AbstractTransactionalTest {
	@Autowired
	protected PessoaDao fixture;

	@Test
	public void mapeamento() {
		Pessoa pessoa = fixture.buscar(11L);
		Assert.assertEquals(new Long(11L), pessoa.getId());
	}

	@Test
	public void buscarPorIdentificacao() {
		Pessoa pessoa = fixture.buscarPorIdentificacao("234");
		Assert.assertEquals(new Long(11L), pessoa.getId());
	}

}