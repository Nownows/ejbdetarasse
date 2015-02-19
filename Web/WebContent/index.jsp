<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td width="15%;">
				<%
					if (session.getAttribute("lecteur") == ""
							|| session.getAttribute("lecteur") == null) {
				%>
				<s:form method="post" action="ValiderIdentification">
					<s:textfield name="identifiant" id="identifiant"
						label="Identifiant" labelposition="top" cssClass="input" />
					<s:property value="errIidentifiant" />
					<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
						labelposition="top" cssClass="input" />
					<s:property value="errMotdepasse" />
					<s:submit value="Identification" />
				</s:form> <%
 	} else {
 		Lecteur l = (Lecteur) session.getAttribute("lecteur");
 %> Bonjour <%=l.getNom() + " " + l.getPrenom()%>
				<%
					}
				%>
				<ul>
					<li><s:a href="gotopage2">administration </s:a></li>
				</ul>


			</td>
			<td width="85%;"><c:forEach var="entry"
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
							${entry.getCorps()}
						<%
							}
						%>
					<br>
					<br>

					<hr>
				</c:forEach></td>
		</tr>
	</table>


</body>
</html>