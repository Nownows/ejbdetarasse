<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="model.*"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/style.css" type="text/css" media="screen" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<title>Administration</title>
</head>
<body>
<%
Employe employe = (Employe)session.getAttribute("employe");
%>
<div id="headerConnexion">
		<div style ="float:left;margin-top:-10px"><h2>Maison du <%= employe.getDisc()%></h2></div>
			<div style="float:right; margin-right:15px ">
			<p style="margin:3px;" > Bonjour <%=employe.getNom() + " " + employe.getPrenom()%></p>
			</div>
		</div>
		
		
<div style="width:  900px;margin: auto;background-color: #F8F8F8">



<%
if(employe.getDisc().equals("Journaliste")==true){
Journaliste j = (Journaliste)employe;
session.setAttribute("journaliste", j);

%>
    <ul>
    <li><s:a href="nouvelArticle">ajouter un article </s:a></li>
    <li><s:a href="mesArticles">voir mes articles </s:a></li>
    <li><s:a href="gestionDossier">gérer les dossiers d'articles </s:a></li>
    </ul>
<%
}else if(employe.getDisc().equals("Redacteur")==true){
Redacteur r = (Redacteur)employe;
session.setAttribute("redacteur", r);
%>
		<ul>
			<li><s:a href="validationArticles">voir les articles à valider </s:a></li>
			<li><s:a href="validerDossier">valider les dossiers d'articles </s:a></li>
		</ul>
<%
}else if(employe.getDisc().equals("Facturation")){
ResponsableFacturation r = (ResponsableFacturation)employe;
session.setAttribute("facturation", r);

%>


<%
}
%>
				
    
    
</div>
</body>
</html>
