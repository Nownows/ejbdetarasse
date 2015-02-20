<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Employe"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'un article</title>
</head>
<body>
<%@include file="homeAdministration.jsp" %>
<div style="width:  900px;margin: auto;background-color: #F8F8F8 ;color:black">
	<table style="width: 100%">
		<tr>
		
			
			<td width="85%;"><s:form method="post" action="AjouterArticle" >
					<s:textfield name="titre" id="titre" label="Titre"
						labelposition="top" cssClass="input" />
					<s:textfield name="header" id="header" label="Header"
						labelposition="top" cssClass="input" />
					<s:textfield name="prix" id="prix" label="Prix" labelposition="top"
						cssClass="input" />
					<s:textarea name="corps" id="corps" label="Corps"
						labelposition="top" cssClass="input" />
					<s:submit value="Ajouter l'article" />
				</s:form></td>
		</tr>
	</table>

</div>
</body>
</html>