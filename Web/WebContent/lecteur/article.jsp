<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
<%@ page import="model.Article"%>
<%@ page import="controle.Parametres"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/style.css"
	type="text/css" media="screen" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<%@include file="../header.jsp" %>
<%@include file="../categories.jsp" %>


		<div style="width: 900px; margin: auto; background-color: #F8F8F8">
		<table style="width: 100%">
			<tr>
				<td width="10%;"></td>
				<td width="90%;">
					<%
						Article a = (Article) session.getAttribute("article");
					%>

					<h2><%=a.getTitre()%></h2>
					<h3><%=a.getHeader()%></h3> <%
 	if (session.getAttribute("lecteur") == ""
 			|| session.getAttribute("lecteur") == null) {
 %> Vous devez vous connecter pour voir la suite de l'article. <%
 	} else {
 		Lecteur lecteur = (Lecteur) session.getAttribute("lecteur");
 		Boolean consultable = (Boolean) session.getAttribute("consultation");
 		if (consultable.booleanValue() ==true) {
 			consultable = (Boolean) session.getAttribute("consultation");
 		}
 		if (lecteur.getStatus() == Parametres.LECTEUR_ABONNE
 				|| consultable == true) {//il lit l'article si abonné
 %>


					<p>
						<%=a.getCorps()%>

						<%
							} else { // si pas abonné
						%>
					
					<p>Pour avoir l'accès complet à cet article, vous devez vous
						abonner ou acheter à l'unité.</p>

					<p>
						<a class="btn btn-primary btn-lg" href="acheterArticle"
							role="button">Acheter cet article</a>
					</p> <%
 	}
 	}
 %> <br> <br>
					<hr>

				</td>
			</tr>
		</table>
	</div>

</body>
</html>