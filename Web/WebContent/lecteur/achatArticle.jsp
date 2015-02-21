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

					<h2>
						Acheter l'article "<%=a.getTitre()%>"
					</h2> <br> Prix : <%=a.getPrix()%> <%
 	Lecteur lecteur = (Lecteur) session.getAttribute("lecteur");
 %>
					<div style="width:450px">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">#</span> <input type="text" class="form-control"
								placeholder="Card Number" aria-describedby="basic-addon1">
						</div>
						 <div class="form-group">
						Expiration <select class="form-control" style="width: 60px;">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<select class="form-control" style="width: 60px;">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">#</span> <input type="text" class="form-control"
								placeholder="Clé" aria-describedby="basic-addon1" size="30">
						</div>
						</div>
						 <s:form method="post" action="ValiderAchat"
						theme="simple">
						
						<s:submit value="Valider" />
					</s:form>
					</div>
					<hr>

				</td>
			</tr>
		</table>
	</div>

</body>
</html>