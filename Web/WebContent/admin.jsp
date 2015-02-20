<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		</div>
		<div style="width:  900px;margin: auto;background-color: #F8F8F8">
	<table width="100%">
		<tr>
			
	<h1>Connexion des Employes</h1>
	<td ><s:form method="post" action="ValiderIdentificationEmploye">
	
		<s:textfield name="identifiant" id="identifiant" label="Identifiant"
						labelposition="top" cssClass="input" />
					<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
						labelposition="top" cssClass="input" />
					<s:submit value="Identification" />
				</s:form>
				
				
				</td>
	</table>
</div>
</body>
</html>