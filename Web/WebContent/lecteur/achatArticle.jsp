<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
<%@ page import="model.Article"%>
<%@ page import="controle.Parametres;"%>
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
	<div id="headerConnexion">
		<div style="float: left; margin-top: -10px">
			<h2>Plateforme ddArticle</h2>
		</div>

		<div style="float: right; margin-right: 15px">
			<%
				if (session.getAttribute("lecteur") == ""
						|| session.getAttribute("lecteur") == null) {
			%>

			<p style="margin: 3px;">
				<s:form method="post" action="ValiderIdentification" theme="simple">
					<s:textfield name="identifiant" id="identifiant"
						label="Identifiant" labelposition="left" cssClass="input" />
					<s:property value="errIidentifiant" />
					<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
						labelposition="left" cssClass="input" />
					<s:property value="errMotdepasse" />
					<s:submit value="Identification" />
				</s:form>
			</p>
			<%
				} else {
					Lecteur l = (Lecteur) session.getAttribute("lecteur");
			%>
			<p style="margin: 3px;">
				Bonjour
				<%=l.getNom() + " " + l.getPrenom()%></p>
			<%
				}
			%>
			<p style="margin: -12px; float: right; margin-right: 5px;">
				<s:a href="gotopage2">administration </s:a>
			</p>

		</div>
	</div>



	<ul class="nav nav-pills navbar-inverse">
		<li role="presentation"><a href="Identification">Home</a></li>
		<c:forEach var="categorie"
			items="<%=session.getAttribute("categories")%>">
			<s:url action="categorie" var="urlCategorie">
				<s:param name="idCategorie">${categorie.getId()}</s:param>
			</s:url>
			<li role="presentation"><a
				href="<s:property value="#urlCategorie" />">${categorie.getLibelle()}</a></li>
		</c:forEach>

	</ul>




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