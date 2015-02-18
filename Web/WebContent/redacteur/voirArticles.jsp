<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Redacteur;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td width="15%;" valign="top">
				<%
					Redacteur j = (Redacteur) session.getAttribute("redacteur");
				%> Bonjour, <%=j.getNom() + " " + j.getPrenom()%>
				<ul>
					<li><s:a href="govoirarticles">voir les articles à valider </s:a></li>
				</ul>
			</td>
			<td width="85%;"><c:forEach var="entry"
					items="<%=session.getAttribute("articles")%>">
					<form action="/Web/redacteur/valid.jsp" method="post">
					<input type="hidden" name="id" value="${entry.getIdArticle()}" />
						Titre : <br> <input type="text" name="titre"
							value="${entry.getTitre()}" /><br> Corps : <br>
						<textarea type="text" name="corps">${entry.getCorps()}</textarea>
						<br> Prix : <br> <input type="text" name="prix"
							value="${entry.getPrix()}" /><br>
						<br> <input type="submit" value="valider" />
					</form>

					<br>
					<hr>
				</c:forEach></td>
		</tr>
	</table>


</body>
</html>