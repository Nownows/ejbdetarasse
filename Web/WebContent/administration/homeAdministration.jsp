<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="model.Employe"%>
<html>
<head>
<title><s:text name="accueil.label"/></title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<div id="enveloppe">
<%
Employe employe = (Employe)session.getAttribute("employe");
%>

<%= employe.getDisc()%>

<%
if(employe.getDisc().equals("Journaliste")==true){

%>
maison du journaliste
    <ul>
    <li><s:a href="nouvelArticle">ajouter un article </s:a></li>
    <li><s:a href="mesArticles">voir mes articles </s:a></li>
    </ul>
<%
}else if(employe.getDisc().equals("Redacteur")==true){
%>
maison du rédacteur
		<ul>
			<li><s:a href="validationArticles">voir les articles à valider </s:a></li>
		</ul>
<%
}else if(employe.getDisc().equals("Facturation")){


%>
    maison du responsable
<%
}
%>
				
    
    
</div>
</body>
</html>
