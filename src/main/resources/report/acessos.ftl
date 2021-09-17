select 
    p.nome as "Pessoa", 
    e.nome as "Equipamento",
    t.descricao as "tipo",
    a.dataacesso
from 
    acesso a
    join pessoa p on p.idpessoa = a.idpessoa
    join equipamento e on e.idequipamento = a.idequipamento
    join tipoLiberacaoacesso t on t.idtipoliberacaoacesso = a.idtipoliberacaoacesso
WHERE
	(1=1)
	<#if idPessoa??>
		AND a.idpessoa = ${idPessoa}
	</#if>
	<#if idEquipamento??>
		AND a.idEquipamento = ${idEquipamento}
	</#if>
	<#if idTipoLiberacaoAcesso??>
		AND a.idTipoLiberacaoAcesso = ${idTipoLiberacaoAcesso}
	</#if>
	<#if dataInicio??>
		AND a.dataacesso between '${dataInicio}' and '${dataFim}'
	</#if>
ORDER BY
	a.dataacesso