SELECT
    p.nome, 
    tp.descricao, 
    log.datahora
FROM
    loglogin log
    join usuario us on us.idusuario = log.idusuario
    join pessoa p on p.idpessoa = us.idpessoa
    join tipologlogin tp on tp.idtipologlogin = log.idtipologlogin
WHERE
	(1=1)
	<#if idUsuario??>
		AND log.idusuario = ${idUsuario}
	</#if>
	<#if idTipo??>
		AND log.idtipologlogin = ${idTipo}
	</#if>
	<#if dataInicio??>
		AND log.datahora between '${dataInicio}' and '${dataFim}'
	</#if>
ORDER BY
	log.datahora