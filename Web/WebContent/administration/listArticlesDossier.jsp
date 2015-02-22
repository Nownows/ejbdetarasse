<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*;"%>
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
					if (session.getAttribute("journaliste") == ""
							|| session.getAttribute("journaliste") == null) {
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
						Journaliste l = (Journaliste) session.getAttribute("journaliste");
				%>
				<p style="margin:3px;" > Bonjour <%=l.getNom() + " " + l.getPrenom()%></p>
				<%
					}
				%>
				<p style="margin:-12px;float: right;margin-right: 5px;"><s:a href="gotopage2">administration </s:a></p>
			
</div>
	</div>
	

  
  <ul class="nav nav-pills">
  <li role="presentation"><a href="Identification">Home</a></li>
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
			<td width="90%;" style="padding:10px;">
			<% List<Article> la = (List<Article>)session.getAttribute("listeArticles");
			if (la.size() == 0 || la == null){
			%>
				Tous les articles disponibles sont déjà dans ce dossier.
			<%
			}
			
			%>
			<c:forEach var="entry"
					items="<%=session.getAttribute("listeArticles")%>">

					<h2>${entry.getTitre()}</h2>
						<h3>${entry.getHeader()}</h3>
							${entry.getCorps()}
							<br>
							<br>
							<form method="post" action="administration/addArticleDossier.jsp">
							<input type="hidden" name="idArticle" value="${entry.getIdArticle()}"/>
							<input type="hidden" name="idDossier" value="<%= request.getParameter("idDossier") %>"/>
							<input type="hidden" name="op" value="add"/>
							<input type="submit" value="Ajouter au dossier" />
							</form>
							<hr>
					</c:forEach>
			
			</td>
		</tr>
	</table>
</div>

</body>
</html>