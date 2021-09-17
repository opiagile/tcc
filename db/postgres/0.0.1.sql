--BEGIN[Tabela UF]
create table uf (
    iduf    numeric(10,0) not null,
    sigla   varchar(2)    not null,
    nome    varchar(25)   not null
)
/
alter table uf add constraint
    pk_uf primary key(iduf)
/
CREATE SEQUENCE s_uf
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela UF]

--BEGIN[Tabela Cidade]
create table cidade(
    idcidade    numeric(10,0) not null,
    iduf        numeric(10,0) not null,
    nome        varchar(255) not null
)
/
alter table cidade add constraint
    pk_cidade primary key(idcidade)
/
alter table cidade add constraint
    fk_cidade_uf foreign key(iduf)
    references uf(iduf)
/
CREATE SEQUENCE s_cidade
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Cidade]

--BEGIN[Tabela Bairro]
create table bairro(
    idbairro    numeric(10,0) not null,
    idcidade        numeric(10,0) not null,
    nome        varchar(255) not null
)
/
alter table bairro add constraint
    pk_bairro primary key(idbairro)
/
alter table bairro add constraint
    fk_bairro_cidade foreign key(idcidade)
    references cidade(idcidade)
/
CREATE SEQUENCE s_bairro
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Bairro]

--BEGIN[Tabela Logradouro]
create table logradouro (
    idlogradouro    numeric(10,0) not null,
    idbairro        numeric(10,0) not null,
    nome            varchar(500) not null,
    cep             varchar(8) not null
)
/
alter table logradouro add constraint
    pk_logradouro primary key(idlogradouro)
/
alter table logradouro add constraint
    fk_logradouro_bairro foreign key(idbairro)
    references bairro(idbairro)
/
CREATE SEQUENCE s_logradouro
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
CREATE INDEX idx_logradouro_cep ON logradouro ((lower(cep)))
/
--END[Tabela Logradouro]

--BEGIN[Tabela Endereco]
create table endereco(
    idendereco      numeric(10,0) not null,
    idlogradouro    numeric(10,0) not null,
    numero          numeric(5,0) not null,
    complemento     varchar(50)
)
/
alter table endereco add constraint
    pk_endereco primary key(idendereco)
/
alter table endereco add constraint
    fk_endereco_logradouro foreign key(idlogradouro)
    references logradouro(idlogradouro)
/
CREATE SEQUENCE s_endereco
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Endereco]


--BEGIN[Tablela Contato]
create table contato (
    idcontato numeric(10,0) not null,
    telefone  varchar(12) not null,
    celular   varchar(12),
    email     varchar(255)
)
/
alter table contato add constraint
    pk_contato primary key(idcontato)
/
CREATE SEQUENCE s_contato
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Contato]

--BEGIN[Tabela Empresa]
create table empresa(
    idempresa   numeric(10,0) not null,
    cnpj        varchar(50) not null,
    nome        varchar(255) not null,
    idcontato   numeric(10,0),
    idendereco  numeric(10,0)
)
/
CREATE SEQUENCE s_empresa
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
alter table empresa add constraint
    pk_empresa primary key(idempresa)
/
alter table empresa add constraint
    fk_empresa_endereco foreign key(idendereco)
    references endereco(idendereco)
/
alter table empresa add constraint
    fk_empresa_contato foreign key(idcontato)
    references contato(idcontato)
/
--END[Tabela Empresa]

--BEGIN[Tabela Pessoa]
create table pessoa(
    idpessoa numeric(10,0) not null,
    nome varchar(500) not null,
	nascimento date,
	idendereco numeric(10,0),
	idcontato numeric(10,0),
	numerodocumento varchar(50) not null,
	dataemissao date not null,
	orgaoexpedidor varchar(25) not null,
	idempresa numeric(10,0),
	observacao varchar(2000),
	periodoInicial date not null,
    periodoFinal date
)
/
CREATE SEQUENCE s_pessoa
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
alter table pessoa add constraint
    pk_pessoa primary key(idpessoa)
/
alter table pessoa add constraint
    fk_pessoa_endereco foreign key(idendereco)
    references endereco(idendereco)
/
alter table pessoa add constraint
    fk_pessoa_contato foreign key(idcontato)
    references contato(idcontato)
/
alter table pessoa add constraint
    fk_pessoa_empresa foreign key(idempresa)
    references empresa(idempresa)
/
--END[Tabela Pessoa]

--BEGIN[Tabela Usuario]
CREATE TABLE USUARIO(
	IDUSUARIO numeric(10,0) NOT NULL,
	NOME VARCHAR(100) not null,
	LOGIN VARCHAR(25),
	SENHA VARCHAR(250),
	idpessoa    numeric(10,0)
)
/
alter table usuario add constraint
	pk_usuario primary key(idusuario)
/
alter table usuario add constraint
    fk_usuario_pessoa foreign key(idpessoa)
    references pessoa(idpessoa)
/
CREATE SEQUENCE s_usuario
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
INSERT INTO USUARIO VALUES(1,'Administrador','2013-08-25 00:00:00.000000000','admin','8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92')
/
COMMIT
/
--END[Tabela Usuario]

--BEGIN[Tabela TipoDisplay]
create table tipodisplay (
	idtipodisplay	numeric(10,0) not null,
	valor	    	char(1)	not null,
	descricao       varchar(100) not null
)
/
alter table tipodisplay add constraint
	pk_tipodisplay primary key(idtipodisplay)
/
insert into tipodisplay values(1, 'G','Gráfico')
/
insert into tipodisplay values(2, 'D','16x2')
/
commit
/
--END[Tabela TipoDisplay]

--BEGIN[Tabela LayoutTeclado]
create table layoutteclado (
	idlayoutteclado	numeric(10,0) not null,
	valor	    	char(1)	not null,
	descricao	varchar(100) not null
)
/
alter table layoutteclado add constraint
	pk_layoutteclado primary key(idlayoutteclado)
/
insert into layoutteclado values(1, 'A', 'ABNT2')
/
insert into layoutteclado values(2, 'U', 'USA')
/
commit
/
--END[Tabela LayoutTeclado]

--BEGIN[Tabela Idioma]
create table idioma (
	ididioma	numeric(10,0) not null,
	valor	    	char(2)	not null,
	descricao	varchar(100) not null
)
/
alter table idioma add constraint
	pk_Idioma primary key(ididioma)
/
insert into idioma values(1, 'PT', 'Português')
/
insert into idioma values(2, 'ES', 'Espanhol')
/
insert into idioma values(3, 'EN', 'Inglês')
/
commit
/
--END[Tabela Idioma]

--BEGIN[Tabela Automatico]
create table automatico (
	idautomatico	numeric(10,0) not null,
	valor	    	char(1)	not null,
	descricao	varchar(100) not null
)
/
alter table automatico add constraint
	pk_automatico primary key(idautomatico)
/
insert into automatico values(1, 'A', 'Automático')
/
insert into automatico values(2, 'N', 'Normal')
/
commit
/
--END[Tabela Automatico]

--BEGIN[Tabela TipoEquipamento]
create table tipoequipamento (
	idtipoequipamento	numeric(10,0) not null,
	descricao			varchar(100) not null
)
/
alter table tipoequipamento add constraint
	pk_tipoequipamento primary key(idtipoequipamento)
/
insert into tipoequipamento values(1, 'Primme Acesso')
/
insert into tipoequipamento values(2, 'Primme')
/
insert into tipoequipamento values(3, 'Primme 2')
/
insert into tipoequipamento values(4, 'Argus')
/
insert into tipoequipamento values(5, 'Prisma 2')
/
commit
/
--END[Tabela TipoEquipamento]

--BEGIN[Tabela TipoValidacao]
create table tipovalidacao (
	idtipovalidacao	numeric(10,0) not null,
	valor	    	char(1)	not null,
	descricao	varchar(100) not null
)
/
alter table tipovalidacao add constraint
	pk_tipovalidacao primary key(idtipovalidacao)
/
insert into tipovalidacao values(1, 'F', 'Offline')
/
insert into tipovalidacao values(2, 'O', 'Online')
/
insert into tipovalidacao values(3, 'A', 'Online/Offlne')
/
insert into tipovalidacao values(4, 'S', 'Modo acesso Prox')
/
commit
/
--END[Tabela TipoValidacao]

--BEGIN[Tabela TipoArmazenamento]
create table tipoarmazenamento (
	idtipoarmazenamento	numeric(10,0) not null,
	valor	    		char(1)	not null,
	descricao		varchar(100) not null
)
/
alter table tipoarmazenamento add constraint
	pk_tipoarmazenamento primary key(idtipoarmazenamento)
/
insert into tipoarmazenamento values(1, 'T', 'Todos')
/
insert into tipoarmazenamento values(2, 'N', 'Nenhum')
/
insert into tipoarmazenamento values(3, 'G', 'Negados')
/
insert into tipoarmazenamento values(4, 'L', 'Liberados')
/
commit
/
--END[Tabela TipoArmazenamento]

--BEGIN[Tabela TipoAcesso]
create table tipoacesso (
	idtipoacesso		numeric(10,0) not null,
	valor	    		char(1)	not null,
	descricao		varchar(100) not null
)
/
alter table tipoacesso add constraint
	pk_tipoacesso primary key(idtipoacesso)
/
insert into tipoacesso values(1, 'B', 'Bloquear não cadastrados')
/
insert into tipoacesso values(2, 'V', 'Livre para não cadastrados')
/
insert into tipoacesso values(3, 'L', 'Livre para todos')
/
commit
/
--END[Tabela TipoAcesso]

--BEGIN[Tabela Luminosidade]
create table luminosidade (
	idluminosidade		numeric(10,0) not null,
	valor	    		char(1) not null,
	descricao		varchar(100) not null
)
/
alter table luminosidade add constraint
	pk_luminosidade primary key(idluminosidade)
/
insert into luminosidade values(1, 'I', 'Interno')
/
insert into luminosidade values(2, 'E', 'Externo')
/
commit
/
--END[Tabela Luminosidade]

--BEGIN[Tabela PadraoTemplate]
create table padraotemplate (
	idpadraotemplate	numeric(10,0) not null,
	valor	    		char(1) not null,
	descricao		varchar(100) not null
)
/
alter table padraotemplate add constraint
	pk_padraotemplate primary key(idpadraotemplate)
/
insert into padraotemplate values(1, 'S', 'Suprema')
/
insert into padraotemplate values(2, 'I', 'ISO')
/
commit
/
--END[Tabela PadraoTemplate]

--BEGIN[Tabela TipoLeitora]
create table tipoleitora (
	idtipoleitora		numeric(10,0) not null,
	valor	    		char(1) not null,
	descricao		varchar(100) not null
)
/
alter table tipoleitora add constraint
	pk_tipoleitora primary key(idtipoleitora)
/
insert into tipoleitora values(1, 'N', 'Nenhum')
/
insert into tipoleitora values(2, 'B', 'Código de Barras')
/
insert into tipoleitora values(3, 'W', 'Wiegand')
/
insert into tipoleitora values(4, 'A', 'Abatrack II')
/
insert into tipoleitora values(5, 'M', 'Biometria')
/
insert into tipoleitora values(6, 'F', 'Mifare')
/
insert into tipoleitora values(7, 'K', 'Teclado')
/
commit
/
--END[Tabela TipoLeitora]

--BEGIN[Tabela Direcao]
create table direcao (
	iddirecao		numeric(10,0) not null,
	valor	    	char(1) not null,
	descricao		varchar(100) not null
)
/
alter table direcao add constraint
	pk_direcao primary key(iddirecao)
/
insert into direcao values(1, 'B', 'Bloqueado')
/
insert into direcao values(2, 'A', 'Ambos')
/
insert into direcao values(3, 'E', 'Entrada')
/
insert into direcao values(4, 'S', 'Saída')
/
insert into direcao values(5, 'U', 'Automatico')
/
commit
/
--END[Tabela Direcao]

--BEGIN[Tabela Padrao2D]
create table padrao2D (
	idpadrao2D		numeric(10,0) not null,
	descricao		varchar(100) not null
)
/
alter table padrao2D add constraint
	pk_padrao2D primary key(idpadrao2D)
/
insert into padrao2D values(0, 'QR Code')
/
insert into padrao2D values(1, 'EAN 13')
/
insert into padrao2D values(2, 'EAN 8')
/
insert into padrao2D values(3, 'Interleaved 2 of 5')
/
insert into padrao2D values(4, 'Code 128')
/
insert into padrao2D values(5, 'Code 39')
/
insert into padrao2D values(6, 'ISBN 10')
/
insert into padrao2D values(7, 'ISBN 13')
/
commit
/
--END[Tabela Padrao2D]

--BEGIN[Tabela EntradaDigital]
create table entradadigital (
	identradadigital	numeric(10,0) not null,
	valor			char(1) not null,
	descricao		varchar(100) not null
)
/
alter table entradadigital add constraint
	pk_entradadigital primary key(identradadigital)
/
insert into entradadigital values(1, 'D', 'Desabilitado')
/
insert into entradadigital values(2, 'B', 'Botão')
/
insert into entradadigital values(3, 'P', 'Porta')
/
insert into entradadigital values(4, 'A', 'Alarme')
/
commit
/
--END[Tabela EntradaDigital]

--BEGIN[Tabela ConfiguracaoRele]
create table configuracaorele (
	idconfiguracaorele	numeric(10,0) not null,
	valor			char(1) not null,
	descricao		varchar(100) not null
)
/
alter table configuracaorele add constraint
	pk_configuracaorele primary key(idconfiguracaorele)
/
insert into configuracaorele values(1, 'D', 'Desativado')
/
insert into configuracaorele values(2, 'E', 'Somente Entrada')
/
insert into configuracaorele values(3, 'S', 'Somente Saída')
/
insert into configuracaorele values(4, 'A', 'Ambos os Sentidos')
/
insert into configuracaorele values(5, 'L', 'Conforme Lista')
/
insert into configuracaorele values(6, 'T', 'Acionamento')
/
commit
/
--END[Tabela ConfiguracaoRele]

--BEGIN[Tabela TamperExterno]
create table tamperexterno (
	idtamperexterno		numeric(10,0) not null,
	valor			char(1) not null,
	descricao		varchar(100) not null
)
/
alter table tamperexterno add constraint
	pk_tamperexterno primary key(idtamperexterno)
/
insert into tamperexterno values(1, 'D', 'Desabilitado')
/
insert into tamperexterno values(2, 'A', 'Alerta')
/
insert into tamperexterno values(3, 'B', 'Bloqueio')
/
insert into tamperexterno values(4, 'S', 'Alerta + Bloqueio')
/
commit
/
--END[Tabela TamperExterno]

--BEGIN[Tabela VelocidadeSerial]
create table velocidadeserial (
	idvelocidadeserial	numeric(10,0) not null,
	valor	    		numeric(6,0) not null,
	descricao           varchar(100) not null
)
/
alter table velocidadeserial add constraint
	pk_velocidadeserial primary key(idvelocidadeserial)
/
insert into velocidadeserial values(1, 9600, '9600')
/
insert into velocidadeserial values(2, 19200, '19200')
/
insert into velocidadeserial values(3, 57600, '57600')
/
insert into velocidadeserial values(4, 115200, '115600')
/
commit
/
--END[Tabela VelocidadeSerial]

--BEGIN[Tabela TipoComunicacao]
create table tipocomunicacao (
	idtipocomunicacao	numeric(10,0) not null,
	valor	    		char(1) not null,
	descricao			varchar(100) not null
)
/
alter table tipocomunicacao add constraint
	pk_tipocomunicacao primary key(idtipocomunicacao)
/
insert into tipocomunicacao values(1, 'S', 'Serial')
/
insert into tipocomunicacao values(2, 'Q', 'Serial 485')
/
insert into tipocomunicacao values(3, 'T', 'TCP/IP')
/
insert into tipocomunicacao values(4, 'W', 'WI-FI')
/
insert into tipocomunicacao values(5, 'G', 'GPRS')
/
commit
/
--END[Tabela TipoComunicacao]


--BEGIN[Tabela Equipamento]
create table equipamento (
    idequipamento   numeric(10,0) not null,
    numeroEquipamento	numeric(10,0)  not null,
    numeroFabrica 	  	numeric(10,0) null,
    idtipoDisplay	  	numeric(10,0),
    volume		  	numeric(1,0) not null,
    mensagemDisplay   	varchar(40),
    beepTeclado	  	boolean not null,
    gerenciadorInteligente	boolean not null,
    senhaMenu		varchar(9),
    login			varchar(20),
    idlayoutTeclado		numeric(10,0)  not null,
    ididioma		numeric(10,0)  not null,
    leitorVericaDigital	boolean not null,
    idmodocadastro		numeric(10,0)  not null,
    idtipoequipamento	numeric(10,0),
    versaoProduto		varchar(50),
    versaoProtocolo		varchar(50),
    formatoRegistro		varchar(100),
    idtipoValidacao		numeric(10,0)  not null,
    idtipoarmazenamento	numeric(10,0) not null,
    validacaoOffline	boolean not null,
    timeout			numeric(5,0) not null,
    tempoEsperaOffline	numeric(3,0) not null,
    tempoPassback		numeric(6,0) not null,
    direcaoPassback		boolean not null,
    verificarValidade	boolean not null,
    idtipoacesso		numeric(10,0) not null,
    ativarMaster		boolean not null,
    verificarHorario	boolean not null,
    gravacaoCiclica		boolean not null,
    taxaRevista		numeric(3,0) not null,
    biometriaOnline		boolean not null,
    enviarMatricula		boolean not null,
    ip			varchar(15) not null,
    mascara			varchar(15),
    dns			varchar(15),
    gateway			varchar(15),
    macAddres		varchar(18),
    porta			numeric(5,0) not null,
    versaoIP		numeric(1,0) not null,
    dhcp			boolean not null,
    nome			varchar(15) not null,
    idvelocidadeserial	numeric(10,0),
    idtipocomunicacao	numeric(10,0) not null,
    conexaoSegura		boolean not null,
    ipComunicacaoSegura	varchar(15),
    criptografar		boolean not null,
    chaveCriptografiaString varchar(16),
    sensibilidadeDSP	numeric(2,0) not null,
    segurancaDSP		numeric(2,0) not null,
    qualidadeImagemDSP	numeric(2,0) not null,
    modoRapidoDSP		numeric(2,0) not null,
    qualidadeMinima		numeric(3,0) not null,
    autoOn			boolean not null,
    verificacao1n		boolean not null,
    idluminosidade		numeric(10,0) not null,
    idpadraotemplate	numeric(10,0) not null,
    idtipoleitora1		numeric(10,0),
    iddirecaoleitora1	numeric(10,0),
    idtipoleitora2		numeric(10,0),
    iddirecaoleitora2	numeric(10,0),
    idtipoleitora3		numeric(10,0),
    iddirecaoleitora3	numeric(10,0),
    idtipoleitora4		numeric(10,0),
    iddirecaoleitora4	numeric(10,0),
    idtipoleitora5		numeric(10,0),
    iddirecaoleitora5	numeric(10,0),
    idleitorateclado	numeric(10,0),
    iddirecaoteclado	numeric(10,0),
    idtipoleitorausb	numeric(10,0),
    iddirecaoleitorausb	numeric(10,0),
    idtipoexpansao1		numeric(10,0),
    iddirecaoexpansao1	numeric(10,0),
    idtipoexpansao2		numeric(10,0),
    iddirecaoexpansao2	numeric(10,0),
    idtipoexpansaobiometrico	numeric(10,0),
    iddirecaoexpansaobiometrico	numeric(10,0),
    idtipoleitor2D		numeric(10,0),
    iddirecaoleitor2D	numeric(10,0),
    identradadigital1	numeric(10,0),
    identradadigital2	numeric(10,0),
    idconfiguracaorele1	numeric(10,0),
    temporele1		numeric(3,0),
    idconfiguracaorele2	numeric(10,0),
    temporele2		numeric(3,0),
    idconfiguracaorele3	numeric(10,0),
    temporele3		numeric(3,0),
    idtamper		numeric(10,0)
)
/
alter table EQUIPAMENTO add constraint
	pk_equipamento primary key(IDEQUIPAMENTO)
/
alter table equipamento add constraint
	fk_equipamento_tipodisplay foreign key(idtipodisplay)
	references tipodisplay(idtipodisplay)
/
alter table equipamento add constraint
	fk_equipamento_layoutteclado foreign key(idlayoutteclado)
	references layoutteclado(idlayoutteclado)
/
alter table equipamento add constraint
	fk_equipamento_idioma foreign key(ididioma)
	references idioma(ididioma)
/
alter table equipamento add constraint
	fk_equipamento_automatico foreign key(idmodocadastro)
	references automatico(idautomatico)
/
alter table equipamento add constraint
	fk_equipamento_tipo foreign key(idtipoequipamento)
	references tipoequipamento(idtipoequipamento)
/
alter table equipamento add constraint
	fk_equipamento_validacao foreign key(idtipovalidacao)
	references tipovalidacao(idtipovalidacao)
/
alter table equipamento add constraint
	fk_equipamento_armazenamento foreign key(idtipoarmazenamento)
	references tipoarmazenamento(idtipoarmazenamento)
/
alter table equipamento add constraint
	fk_equipamento_tipoacesso foreign key(idtipoacesso)
	references tipoacesso(idtipoacesso)
/
alter table equipamento add constraint
	fk_equipamento_veloserial foreign key(idvelocidadeserial)
	references velocidadeserial(idvelocidadeserial)
/
alter table equipamento add constraint
	fk_equipamento_comunicacao foreign key(idtipocomunicacao)
	references tipocomunicacao(idtipocomunicacao)
/
alter table equipamento add constraint
	fk_equipamento_luminosidade foreign key(idluminosidade)
	references luminosidade(idluminosidade)
/
alter table equipamento add constraint
	fk_equipamento_padraotemplate foreign key(idpadraotemplate)
	references padraotemplate(idpadraotemplate)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitora1 foreign key(idtipoleitora1)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitora1 foreign key(iddirecaoleitora1)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitora2 foreign key(idtipoleitora2)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitora2 foreign key(iddirecaoleitora2)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitora3 foreign key(idtipoleitora3)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitora3 foreign key(iddirecaoleitora3)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitora4 foreign key(idtipoleitora4)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitora4 foreign key(iddirecaoleitora4)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitora5 foreign key(idtipoleitora5)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitora5 foreign key(iddirecaoleitora5)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_leitorateclado foreign key(idleitorateclado)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoteclado foreign key(iddirecaoteclado)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitorausb foreign key(idtipoleitorausb)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitorausb foreign key(iddirecaoleitorausb)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoexpansao1 foreign key(idtipoexpansao1)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoexpansao1 foreign key(iddirecaoexpansao1)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoexpansao2 foreign key(idtipoexpansao2)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoexpansao2 foreign key(iddirecaoexpansao2)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoexpbiom foreign key(idtipoexpansaobiometrico)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoexpbiom foreign key(iddirecaoexpansaobiometrico)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_tipoleitor2D foreign key(idtipoleitor2D)
	references tipoleitora(idtipoleitora)
/
alter table equipamento add constraint
	fk_equipamento_direcaoleitor2D foreign key(iddirecaoleitor2D)
	references direcao(iddirecao)
/
alter table equipamento add constraint
	fk_equipamento_entradadigital1 foreign key(identradadigital1)
	references entradadigital(identradadigital)
/
alter table equipamento add constraint
	fk_equipamento_entradadigital2 foreign key(identradadigital2)
	references entradadigital(identradadigital)
/
alter table equipamento add constraint
	fk_equipamento_configuracaorele1 foreign key(idconfiguracaorele1)
	references configuracaorele(idconfiguracaorele)
/
alter table equipamento add constraint
	fk_equipamento_configuracaorele2 foreign key(idconfiguracaorele2)
	references configuracaorele(idconfiguracaorele)
/
alter table equipamento add constraint
	fk_equipamento_configuracaorele3 foreign key(idconfiguracaorele3)
	references configuracaorele(idconfiguracaorele)
/
alter table equipamento add constraint
	fk_equipamento_tamper foreign key(idtamper)
	references tamperexterno(idtamperexterno)
/
CREATE SEQUENCE s_equipamento
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Equipamento]

--BEGIN[Tabela Permissao]
CREATE TABLE PERMISSAO(
	IDPERMISSAO numeric(10,0) NOT NULL,
	DESCRICAO VARCHAR(100)
)
/
alter table PERMISSAO add constraint
	pk_permissao primary key(IDPERMISSAO)
/
INSERT INTO PERMISSAO VALUES(1,'Cadastrar Usuário')
/
INSERT INTO PERMISSAO VALUES(2,'Relatório Login')
/
INSERT INTO PERMISSAO VALUES(3,'Cadastrar Equipamento')
/
INSERT INTO PERMISSAO VALUES(1000,'Index')
/
insert into permissao values(4, 'Cadastrar Pessoa')
/
insert into permissao values(5, 'Cadastrar Empresa')
/
COMMIT
/
--END[Tabela Permissao]

--BEGIN[Tabela PermissaoUsuario]
CREATE TABLE USUARIOPERMISSAO(
	IDUSUARIO numeric(10,0) NOT NULL,
	IDPERMISSAO numeric(10,0) NOT NULL
)
/
alter table USUARIOPERMISSAO add constraint
	fk_permissao_usuario foreign key(IDUSUARIO) 
	references USUARIO(IDUSUARIO)
/
alter table USUARIOPERMISSAO add constraint
	fk_permissao_permissao foreign key(IDPERMISSAO) 
	references PERMISSAO(IDPERMISSAO)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,1)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,2)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,3)
/
insert into usuariopermissao values(1, 4)
/
insert into usuariopermissao values(1, 5)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,1000)
/
COMMIT
/
--END[Tabela PermissaoUsuario]

--BEGIN[Tabela TipoLogLogin]
CREATE TABLE TIPOLOGLOGIN(
	IDTIPOLOGLOGIN numeric(10,0) NOT NULL,
	DESCRICAO VARCHAR(25) NOT NULL
)
/
alter table TIPOLOGLOGIN add constraint
	pk_tipologlogin primary key(IDTIPOLOGLOGIN)
/
INSERT INTO TIPOLOGLOGIN VALUES(1,'Login')
/
INSERT INTO TIPOLOGLOGIN VALUES(2,'Logout')
/
COMMIT
/
--END[Tabela TipoLogLogin]

--BEGIN[Tabela LogLogin]
CREATE TABLE LOGLOGIN(
	IDLOGLOGIN numeric(10,0) NOT NULL,
	IDTIPOLOGLOGIN numeric(10,0) NOT NULL,
	IDUSUARIO numeric(10,0) NOT NULL,
	DATAHORA TIMESTAMP NOT NULL,
	CONSTRAINT FK_LOGIN_TIPO FOREIGN KEY(IDTIPOLOGLOGIN) REFERENCES TIPOLOGLOGIN(IDTIPOLOGLOGIN),
	CONSTRAINT FK_LOGIN_USUARIO FOREIGN KEY(IDUSUARIO) REFERENCES USUARIO(IDUSUARIO)
)
/
alter table LOGLOGIN add constraint
	pk_loglogin primary key(IDLOGLOGIN)
/
alter table LOGLOGIN add constraint
	fk_loglogin_tipo foreign key(IDTIPOLOGLOGIN) 
	references TIPOLOGLOGIN(IDTIPOLOGLOGIN)
/
alter table LOGLOGIN add constraint
	fk_loglogin_usuario foreign key(IDUSUARIO) 
	references USUARIO(IDUSUARIO)
/
CREATE SEQUENCE s_loglogin
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela LogLogin]

--BEGIN[Tabela PessoaEquipamento]
create table PESSOAEQUIPAMENTO (
    idpessoa    numeric(10,0) not null,
    idequipamento numeric(10,0) not null
)
/
alter table pessoaequipamento add constraint
    fk_pessoa_equipamento foreign key(idpessoa)
    references pessoa(idpessoa)
/
alter table pessoaequipamento add constraint
    fk_equipamento_pessoa foreign key(idequipamento)
    references equipamento(idequipamento)
/
--END[Tabela PessoaEquipamento]

--BEGIN[Tabela Acesso]
create table acesso (
    idacesso    numeric(10,0) not null,
    idpessoa    numeric(10,0) not null,
    idequipamento   numeric(10,0) not null,
    dataacesso  TIMESTAMP not null
)
/
alter table acesso add constraint
    pk_acesso primary key(idacesso)
/
alter table acesso add constraint
    fk_acesso_pessoa foreign key(idpessoa)
    references pessoa(idpessoa)
/
alter table acesso add constraint
    fk_acesso_equipamento foreign key(idequipamento)
    references equipamento(idequipamento)
/
CREATE SEQUENCE s_acesso
       NO MINVALUE
       NO MAXVALUE 
       INCREMENT BY 1
       NO CYCLE
/
--END[Tabela Acesso]