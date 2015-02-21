<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
<%@ page import="model.Categorie"%>
<html>
<head>
<link href="style.css" type="text/css" media="screen" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<%@include file="../header.jsp" %>
<%@include file="../categories.jsp" %>

	<div style="width:  900px;margin: auto;background-color: #F8F8F8">
	<table style="width: 100%">
		<tr>
			<td width="10%;"></td>
			<td width="90%;"><c:forEach var="entry"
					items="<%=session.getAttribute("articles")%>">
					<s:url action="article" var="urlArticle">
						<s:param name="idArticle">${entry.getIdArticle()}</s:param>
					</s:url>
					<h2>
						<a href="<s:property value="#urlArticle" />">${entry.getTitre()}</a>
					</h2>
					<h3>${entry.getHeader()}</h3>

					<%
						if (session.getAttribute("lecteur") == ""
									|| session.getAttribute("lecteur") == null) {
					%>
								Vous devez vous connecter pour voir la suite de l'article.
						<%
						} %>
					<br>
					<br>

					<hr>
				</c:forEach></td>
		</tr>
	</table>
</div>

</body>
</html>