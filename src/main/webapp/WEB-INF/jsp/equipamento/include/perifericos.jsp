<%@ page pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jsp" %>
<fieldset>
	<fieldset>
		<legend><fmt:message key="equipamento.label.perifericos.leitoras"/></legend>
		<table>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitora1"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitor1" name="equipamento.configuracao.perifericos.leitor1.tipo" width="280px;" options="${tiposLeitor1}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor1.tipo}"/></td>
							<td><tg:combo id="direcaoLeitor1" name="equipamento.configuracao.perifericos.leitor1.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor1.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
					<legend><fmt:message key="equipamento.label.perifericos.leitora2"/></legend>
					<tr>
						<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
						<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
					</tr>
					<tr>
						<td><tg:combo id="tipoLeitor2" name="equipamento.configuracao.perifericos.leitor2.tipo" width="280px;" options="${tiposLeitor2}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor2.tipo}"/></td>
						<td><tg:combo id="direcaoLeitor2" name="equipamento.configuracao.perifericos.leitor2.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor2.direcao}"/></td>
					</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitora3"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitor3" name="equipamento.configuracao.perifericos.leitor3.tipo" width="280px;" options="${tiposLeitor3}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor3.tipo}"/></td>
							<td><tg:combo id="direcaoLeitor3" name="equipamento.configuracao.perifericos.leitor3.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor3.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitora4"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitor4" name="equipamento.configuracao.perifericos.leitor4.tipo" width="280px;" options="${tiposLeitor4}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor4.tipo}"/></td>
							<td><tg:combo id="direcaoLeitor4" name="equipamento.configuracao.perifericos.leitor4.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor4.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitora5"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitor5" name="equipamento.configuracao.perifericos.leitor5.tipo" width="280px;" options="${tiposLeitor5}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor5.tipo}"/></td>
							<td><tg:combo id="direcaoLeitor5" name="equipamento.configuracao.perifericos.leitor5.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor5.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.teclado"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoTeclado" name="equipamento.configuracao.perifericos.teclado.tipo" width="280px;" options="${tiposLeitorTeclado}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.teclado.tipo}"/></td>
							<td><tg:combo id="direcaoTeclado" name="equipamento.configuracao.perifericos.teclado.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.teclado.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitoraUSB"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitoraUSB" name="equipamento.configuracao.perifericos.leitoraUsb.tipo" width="280px;" options="${tiposLeitorUSB}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitoraUsb.tipo}"/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.leitora2D"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.direcao"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoLeitora2D" name="equipamento.configuracao.perifericos.leitor2D.tipo" width="280px;" options="${tiposLeitor2D}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor2D.tipo}"/></td>
							<td><tg:combo id="direcaoLeitora2D" name="equipamento.configuracao.perifericos.leitor2D.direcao" width="280px;" options="${direcoes}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.leitor2D.direcao}"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
	<table>
		<fieldset>
			<legend><fmt:message key="equipamento.label.perifericos.gerenciamentoEntradaSaida"/></legend>
			<tr>
				<td><fmt:message key="equipamento.label.perifericos.tamper"/></td>
			</tr>
			<tr>
				<td><tg:combo id="tamper" name="equipamento.configuracao.perifericos.tamper" width="280px;" options="${tampers}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.tamper}"/></td>
			</tr>
				<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.entrada1"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoEntrada1" name="equipamento.configuracao.perifericos.entradaDigital1" width="280px;" options="${entradasDigitais}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.entradaDigital1}"/></td>
						</tr>
					</table>
				</td>
			</tr>
				<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.entrada2"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoEntrada2" name="equipamento.configuracao.perifericos.entradaDigital2" width="280px;" options="${entradasDigitais}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.entradaDigital2}"/></td>
						</tr>
					</table>
				</td>
			</tr>
				<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.rele1"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.tempo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoRele1" name="equipamento.configuracao.perifericos.rele1.configuracao" width="280px;" options="${tiposRele}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.rele1.configuracao}"/></td>
							<td><tl:spinner id="tempoRele1" name="equipamento.configuracao.perifericos.rele1.tempo" width="250px" value="${equipamento.configuracao.perifericos.rele1.tempo}" min="1" max="255"/></td>
						</tr>
					</table>
				</td>
			</tr>
				<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.rele2"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.tempo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoRele2" name="equipamento.configuracao.perifericos.rele2.configuracao" width="280px;" options="${tiposRele}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.rele2.configuracao}"/></td>
							<td><tl:spinner id="tempoRele2" name="equipamento.configuracao.perifericos.rele2.tempo" width="250px" value="${equipamento.configuracao.perifericos.rele2.tempo}" min="1" max="255"/></td>
						</tr>
					</table>
				</td>
			</tr>
				<tr>
				<td>
					<table>
						<legend><fmt:message key="equipamento.label.perifericos.rele3"/></legend>
						<tr>
							<td><fmt:message key="equipamento.label.perifericos.tipo"/>:</td>
							<td><fmt:message key="equipamento.label.perifericos.tempo"/>:</td>
						</tr>
						<tr>
							<td><tg:combo id="tipoRele3" name="equipamento.configuracao.perifericos.rele3.configuracao" width="280px;" options="${tiposRele}" optionValue="id" optionLabel="descricao" selected="${equipamento.configuracao.perifericos.rele3.configuracao}"/></td>
							<td><tl:spinner id="tempoRele3" name="equipamento.configuracao.perifericos.rele3.tempo" width="250px" value="${equipamento.configuracao.perifericos.rele3.tempo}" min="1" max="255"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
</fieldset>