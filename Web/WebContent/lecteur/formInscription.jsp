<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
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
	
<jsp:include page="../header.jsp" />
<jsp:include page="../categories.jsp" />
  
 

	<div style="width:  900px;margin: auto;background-color: #F8F8F8">
	<table style="width: 100%">
		<tr>
			<td width="10%;"></td>
			<td width="90%;">
			
			<h2>Inscription</h2>
			<s:form method="post" action="ValiderInscription">

						<s:textfield name="nom" id="nom" label="Nom" labelposition="left"
							cssClass="input" />
							<s:textfield name="prenom" id="prenom" label="Prenom" labelposition="left"
							cssClass="input" />
							<s:textfield name="email" id="email" label="Email" labelposition="left"
							cssClass="input" />
						<s:password name="password" id="password" label="Mot de passe"
						labelposition="left" cssClass="input" />
						<s:textfield name="pays" id="pays" label="Pays" labelposition="left"
							cssClass="input" />
					<s:submit value="Inscription" />
				</s:form>
				
				
				</td>
			

		</tr>
	</table>
</div>

</body>
</html>