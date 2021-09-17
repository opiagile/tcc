<%@ page pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<a class="navbar-brand"><fmt:message key="label.nomeProjeto" /></a>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach var="menu" items="${itensMenu}">
					<li class="${menu.classe}">
						<a href="<c:url value="${menu.url}" />" <c:if test="${menu.dropdown}">${menu.dataToggle}</c:if>>
							${menu.descricao}
						</a>
						<c:if test="${menu.dropdown}">
							<ul class="dropdown-menu">
								<c:forEach var="item" items="${menu.itens}">
									<li class="${item.classe}">
										<a href="${item.url}">${item.descricao}</a>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>