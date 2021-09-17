<%@ page pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
	<title><fmt:message key="label.nomeProjeto"/></title>
	<script type="text/javascript" src="<c:url value="/static/js/jquery/jquery-1.10.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery/jquery-ui-1.10.3.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery/jquery-ui-timepicker.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery/validator/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery/validator/additional-methods.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/bootstrap/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/app.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/validator.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/jquery-atmosphere/jquery.atmosphere.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/static/js/processadorJson.js"/>"></script>
	<link rel="shortcut icon" href="<c:url value="/static/images/janus.ico"/>"/>
	<link type="text/css" href="<c:url value="/static/css/bootstrap/bootstrap.css"/>" rel="stylesheet" />
	<link type="text/css" href="<c:url value="/static/css/app.css"/>" rel="stylesheet" />
	<link type="text/css" href="<c:url value="/static/css/jquery-ui/jquery-ui-1.10.3.min.css"/>" rel="stylesheet" />
	<link type="text/css" href="<c:url value="/static/css/jquery-ui/jquery-ui-timepicker.css"/>" rel="stylesheet" />
</head>
<body>
<div id="wrap">
	<%@ include file="menu.jsp" %>
	<div class="container">
	<%@ include file="panicoRequired.jsp" %>