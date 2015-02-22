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
		
			
			<td width="85%;" style="padding:10px;"><s:form method="post" action="AjouterArticle" >
					<s:textfield name="titre" id="titre" label="Titre"
						labelposition="top" cssClass="input" />
					<s:textfield name="header" id="header" label="Header"
						labelposition="top" cssClass="input" />
					<s:textfield name="prix" id="prix" label="Prix" labelposition="top"
						cssClass="input" />
					<s:textarea name="corps" id="corps" label="Corps"
						labelposition="top" cssClass="input" />
					<label for="titre" class="label">Catégories:</label><br/><br/><br/>
						<select multiple="multiple">
							<option selected value=""/>
							<option value="Monde">Monde</option>
							<option value="Politique">Politique</option>
							<option value="Economie">Economie</option>
							<option value="Musique">Musique</option>
							<option value="Populaire">Populaire</option>
							<option value="Sport">Sport</option>
							<option value="Sciences">Sciences</option>
							<option value="Société">Société</option>
							<option value="Culture">Culture</option>
							<option value="Divers">Divers</option>
						</select>
						<br/>
						<br/>
						<br/>
					<s:submit value="Ajouter l'article" />
				</s:form></td>
		</tr>
	</table>

</div>
</body>
</html>