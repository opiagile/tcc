package br.com.bitwiselab.jano.controller;

import java.util.Arrays;
import java.util.List;

import br.com.bitwiselab.jano.annotation.Seguranca;
import br.com.bitwiselab.jano.dao.EquipamentoDao;
import br.com.bitwiselab.jano.model.Acesso;
import br.com.bitwiselab.jano.model.Equipamento;
import br.com.bitwiselab.jano.model.Permissao;
import br.com.bitwiselab.jano.model.Pessoa;
import br.com.bitwiselab.jano.model.TipoLiberacaoAcesso;
import br.com.bitwiselab.jano.service.EquipamentoService;
import br.com.bitwiselab.jano.session.Session;
import br.com.bitwiselab.jano.util.I18nUtil;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.henry.primmeAcesso.model.Automatico;
import br.com.henry.primmeAcesso.model.Direcao;
import br.com.henry.primmeAcesso.model.EntradaDigital;
import br.com.henry.primmeAcesso.model.EstadoEquipamento;
import br.com.henry.primmeAcesso.model.Idioma;
import br.com.henry.primmeAcesso.model.LayoutTeclado;
import br.com.henry.primmeAcesso.model.Leitoras;
import br.com.henry.primmeAcesso.model.Luminosidade;
import br.com.henry.primmeAcesso.model.PadraoTemplate;
import br.com.henry.primmeAcesso.model.Rele.ConfiguracaoRele;
import br.com.henry.primmeAcesso.model.TamperExterno;
import br.com.henry.primmeAcesso.model.TipoAcesso;
import br.com.henry.primmeAcesso.model.TipoArmazenamento;
import br.com.henry.primmeAcesso.model.TipoComunicacao;
import br.com.henry.primmeAcesso.model.TipoLeitora;
import br.com.henry.primmeAcesso.model.VelocidadeSerial;

@Resource
@Path("/equipamento")
public class EquipamentoController extends AbstractController {

	private final EquipamentoDao equipamentoDao;
	private final EquipamentoService equipamentoService;

	public EquipamentoController(Validator validator, Result result,
			Session session, EquipamentoDao equipamentoDao,
			EquipamentoService equipamentoService) {
		super(validator, result, session, true, true);
		this.equipamentoDao = equipamentoDao;
		this.equipamentoService = equipamentoService;
	}

	private void validarEquipamento(final Equipamento equipamento) {
		validator.validate(equipamento);
		validator.onErrorSendBadRequest();
	}

	private Equipamento preencherEquipamentoDB(final Equipamento equipamento) {
		Equipamento equipamentoDB = equipamentoDao.buscarOuCriar(equipamento
				.getId());
		equipamentoDB.setConfiguracao(equipamento.getConfiguracao());
		if (equipamento.getId() == null) {
			equipamentoDB.setEstado(EstadoEquipamento.OFFLINE);
		}
		return equipamentoDB;
	}

	@Get
	@Path("/listar")
	@Seguranca(Permissao.EQUIPAMENTO_CADASTRAR)
	public void listar() {
		result.include("title", I18nUtil.getText("equipamento.listar.titulo"));
		result.include("urlHelp", "/equipamento/help");
		result.include("equipamentos", equipamentoDao.listarTodos());
	}

	@Get
	@Path("/cadastrar")
	@Seguranca(Permissao.EQUIPAMENTO_CADASTRAR)
	public void cadastrar() {
		Equipamento equipamento = new Equipamento();
		result.redirectTo(EquipamentoController.class).editar(equipamento);
	}

	@Get
	@Path("/editar/{id}")
	@Seguranca(Permissao.EQUIPAMENTO_CADASTRAR)
	public void editar(Long id) {
		result.redirectTo(EquipamentoController.class).editar(
				equipamentoDao.buscar(id));

	}

	@Get
	@Seguranca(Permissao.EQUIPAMENTO_CADASTRAR)
	public void editar(Equipamento equipamento) {
		result.include("equipamento", equipamento);
		result.include("idiomas", Arrays.asList(Idioma.values()));
		result.include("layoutsTeclado", Arrays.asList(LayoutTeclado.values()));
		result.include("tiposAcesso", Arrays.asList(TipoAcesso.values()));
		result.include("tiposComunicacao",
				Arrays.asList(TipoComunicacao.values()));
		result.include("tiposArmazenamento",
				Arrays.asList(TipoArmazenamento.values()));
		result.include("velocidadesComunicacao",
				Arrays.asList(VelocidadeSerial.values()));
		result.include("tiposLuminosidade",
				Arrays.asList(Luminosidade.values()));
		result.include("modosAutomatico", Arrays.asList(Automatico.values()));
		result.include("tiposTemplate", Arrays.asList(PadraoTemplate.values()));
		result.include("tiposLeitor1",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA1));
		result.include("tiposLeitor2",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA2));
		result.include("tiposLeitor3",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA3));
		result.include("tiposLeitor4",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA4));
		result.include("tiposLeitor5",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA5));
		result.include("tiposLeitorTeclado",
				TipoLeitora.getTiposLeitoras(Leitoras.TECLADO));
		result.include("tiposLeitorUSB",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITORA_USB2));
		result.include("tiposLeitor2D",
				TipoLeitora.getTiposLeitoras(Leitoras.LEITOR2D));
		result.include("direcoes", Arrays.asList(Direcao.values()));
		result.include("tampers", Arrays.asList(TamperExterno.values()));
		result.include("entradasDigitais",
				Arrays.asList(EntradaDigital.values()));
		result.include("tiposRele", Arrays.asList(ConfiguracaoRele.values()));
	}

	@Post
	@Path("/salvar")
	@Seguranca(Permissao.EQUIPAMENTO_CADASTRAR)
	public void salvar(Equipamento equipamento) {
		validarEquipamento(equipamento);
		equipamentoDao.salvar(preencherEquipamentoDB(equipamento));
		equipamentoService.atualizarConfiguracoes(equipamento);
		result.use(Results.json()).withoutRoot()
				.from(I18nUtil.getText("equipamentoController.salvar.sucesso"))
				.serialize();
	}

	@Get
	@Path("/liberarAcesso/{id}")
	@Seguranca(Permissao.EQUIPAMENTO_LIBERARACESSO)
	public void liberarAcesso(Long id) {
		equipamentoService.liberarAcesso(id, 10);
		Equipamento equipamento = equipamentoDao.buscar(id);
		Pessoa pessoa = session.getUsuario().getPessoa();
		equipamentoService.gravarAcesso(new Acesso(pessoa, equipamento,
				TipoLiberacaoAcesso.COMANDO));
	}

	@Get
	@Path("/panico")
	@Seguranca(Permissao.EQUIPAMENTO_LIBERARACESSO)
	public void panico() {
		List<Equipamento> equipamentos = equipamentoDao.listarTodos();
		for (Equipamento equipamento : equipamentos) {
			equipamentoService.liberarAcesso(equipamento.getId(), 60);
			Pessoa pessoa = session.getUsuario().getPessoa();
			equipamentoService.gravarAcesso(new Acesso(pessoa, equipamento,
					TipoLiberacaoAcesso.PANICO));
		}
		manager.ativarPanico(equipamentoService);
	}

	@Get
	@Path("/panico/cancelar")
	@Seguranca(Permissao.EQUIPAMENTO_LIBERARACESSO)
	public void cancelarPanico() {
		List<Equipamento> equipamentos = equipamentoDao.listarTodos();
		for (Equipamento equipamento : equipamentos) {
			equipamentoService.liberarAcesso(equipamento.getId(), 1);
		}
		manager.desativarPanico();
	}
}
