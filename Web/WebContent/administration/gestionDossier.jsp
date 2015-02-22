<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Employe"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="articles.GestArticleInterface"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>

<body>
	<%@include file="homeAdministration.jsp"%>
	<div
		style="width: 900px; margin: auto; background-color: #F8F8F8; color: black">
		<table style="width: 100%">
			<tr>
				<td width="15%;" style="padding: 10px;"><s:form method="post"
						action="AjouterDossier">
						<s:textfield name="label" id="label" label="Label"
							labelposition="top" cssClass="input" />
						<s:submit value="Ajouter le dossier" />
					</s:form></td>
				<td width="85%;" style="padding: 10px;"><c:forEach var="entry"
						items="<%=session.getAttribute("mesDossiers")%>">

						<h2>${entry.getLibelle()}</h2>
						<c:if
							test="${entry.getLesArticles().size() == 0 || entry.getLesArticles() == null}">
							<span style="font-style: italic;">Aucun article dans ce
								dossier.</span>
						</c:if>
						<c:if
							test="${entry.getLesArticles().size() != 0 || entry.getLesArticles() != null}">
							<ul>
								<c:forEach var="article" items="${entry.getLesArticles()}">
									<li><s:url action="articleAdmin" var="urlArticle"
											escapeAmp="false">
											<s:param name="idArticle">${article.getIdArticle()}</s:param>
											<s:param name="idDossier">${entry.getId()}</s:param>
										</s:url>

										<h2>
											<a href="<s:property value="#urlArticle" />">${article.getTitre()}</a>
										</h2></li>
								</c:forEach>
							</ul>
						</c:if>

						<br>
						<br>
						<c:if test="${entry.getValidateur() == null }">
							<span style="font-style: italic;">status : NON VALIDE</span>
						</c:if>
						<c:if test="${entry.getValidateur() != null }">
							<span style="font-style: italic;">status : validé</span>
						</c:if>

						<s:url action="listArticlesDossier" var="urlArticlesDossier"
							escapeAmp="false">
							<s:param name="idDossier">${entry.getId()}</s:param>
						</s:url>
						<br />
						<a href="<s:property value="#urlArticlesDossier" />">Ajouter
							un article</a>

						<hr>
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>