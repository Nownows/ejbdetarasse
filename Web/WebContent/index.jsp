<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur;"%>
<html>
<head>
<link href="style.css" type="text/css" media="screen" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<div id="headerConnexion">
		<div style ="float:left;margin-top:-10px"><h2>Plateforme Article</h2></div>

	<div style="float:right; margin-right:15px ">
				<%
					if (session.getAttribute("lecteur") == ""
							|| session.getAttribute("lecteur") == null) {
				%>
			
			<p style="margin:3px;">
			<s:form method="post" action="ValiderIdentification"
						theme="simple">
						<s:textfield name="identifiant" id="identifiant"
							label="Identifiant" labelposition="left" cssClass="input" />
						<s:property value="errIidentifiant" />
						<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
							labelposition="left" cssClass="input" />
						<s:property value="errMotdepasse" />
						<s:submit value="Identification" />
					</s:form></p>
				<%
					} else {
						Lecteur l = (Lecteur) session.getAttribute("lecteur");
				%>
				<p style="margin:3px;" > Bonjour <%=l.getNom() + " " + l.getPrenom()%></p>
				<%
					}
				%>
				<p style="margin:-12px;float: right;margin-right: 5px;"><s:a href="gotopage2">administration </s:a></p>
			
</div>
	</div>
	

  
  <ul class="nav nav-pills navbar-inverse">
  <li role="presentation" class="active" ><a href="#">Home</a></li>
  <c:forEach var="categorie" items="<%=session.getAttribute("categories")%>">
  <s:url action="categorie" var="urlCategorie">
						<s:param name="idCategorie">${categorie.getId()}</s:param>
					</s:url>
  <li role="presentation"><a href="<s:property value="#urlCategorie" />">${categorie.getLibelle()}</a></li>
  </c:forEach>
  
</ul>

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
						} else {
					%>
<%-- 							${entry.getCorps()} --%>
						<%
							}
						%>
					<br>
					<br>

					<hr>
				</c:forEach></td>
		</tr>
	</table>
</div>

</body>
</html>