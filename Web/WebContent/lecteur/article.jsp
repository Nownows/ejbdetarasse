<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
<%@ page import="model.Article;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td width="15%;">
			<% if (session.getAttribute("lecteur") == "" || session.getAttribute("lecteur") == null){ %>
			 <s:form method="post" action="ValiderIdentification">
					<s:textfield name="identifiant" id="identifiant" label="Identifiant" labelposition="top" cssClass="input" />
						<s:property value="errIidentifiant"/>
					<s:password name="motdepasse" id="motdepasse" label="Mot de passe" labelposition="top" cssClass="input" />
						<s:property value="errMotdepasse"/>
					<s:submit value="Identification" />
			</s:form>
				
			<% } 
			else { 
				Lecteur l = (Lecteur)session.getAttribute("lecteur");%>
    			Bonjour <%= l.getNom()+" "+l.getPrenom() %>
    		<%} %>
			<ul>
			<li>
				<s:a href="gotopage2">administration </s:a>
			</li>
			</ul>
			
			
				</td>
			<td width="85%;">
				
			<% Article a = (Article) session.getAttribute("article"); %>
			
						<h2><%= a.getTitre() %></h2>
						<h3><%= a.getHeader() %></h3>
						<% if (session.getAttribute("lecteur") == "" || session.getAttribute("lecteur") == null){ %>
								Vous devez vous connecter pour voir la suite de l'article.
						<% } 
						else {  
						%>
						<p>
						<%= a.getCorps() %>
						 
						<% } %>  
							<br>
							<br>
							
							<hr>
					
			</td>
		</tr>
	</table>


</body>
</html>