package br.com.bitwiselab.jano.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.bitwiselab.jano.dao.UsuarioDao;
import br.com.bitwiselab.jano.model.Usuario;

public class UsuarioDaoTest extends AbstractTransactionalTest {
	@Autowired
	protected UsuarioDao fixture;

	@Test
	public void mapeamento() {
		Usuario usuario = fixture.buscar(1L);
		Assert.assertEquals(new Long(1L), usuario.getId());
	}

	@Test
	public void listar() {
		Assert.assertNotNull(fixture.listar(1, 10));
	}

	@Test
	public void buscarAcesso_encontrado() {
		Usuario usuario = fixture.buscarAcesso("rodrigo", "123456");
		Assert.assertEquals(new Long(1L), usuario.getId());
	}

	@Test
	public void buscarAcesso_naoEncontado() {
		Usuario usuario = fixture.buscarAcesso("rodrigo", "AAAAA");
		Assert.assertNull(usuario);
	}

	@Test
	public void buscarOuCriar_buscar() {
		Usuario usuario = fixture.buscarOuCriar(1L);
		Assert.assertEquals(new Long(1L), usuario.getId());
	}

	@Test
	public void buscarOuCriar_criar() {
		Usuario usuario = fixture.buscarOuCriar(null);
		Assert.assertNull(usuario.getId());
		Assert.assertNull(usuario.getLogin());
		Assert.assertNull(usuario.getSenha());
	}

}