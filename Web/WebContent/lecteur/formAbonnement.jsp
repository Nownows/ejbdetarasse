<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur"%>
<%@ page import="model.Article"%>
<%@ page import="controle.Parametres"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/style.css"
	type="text/css" media="screen" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>
<body>

<%@include file="../header.jsp" %>
<%@include file="../categories.jsp" %>

	<div style="width: 900px; margin: auto; background-color: #F8F8F8">
		<table style="width: 100%">
			<tr>
				<td width="10%;"></td>
				<td width="90%;">
			<h1> Abonnement annuel</h1><br>
			<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi et risus urna. In commodo pretium mauris et mattis.</h2>
			<p> 
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi et risus urna. In commodo pretium mauris et mattis. Sed dictum congue leo sit amet rhoncus. 
			</p><p>
			Nam feugiat at turpis vitae condimentum. Donec porttitor nisi in dui placerat dapibus. 
			Integer in pulvinar turpis. Ut lobortis, mauris quis dignissim rutrum, augue nisl scelerisque mauris, id posuere lorem ex in urna. 
			<br>Praesent sem ligula, rutrum quis nunc et, tincidunt ultricies lacus. Donec egestas nunc sit amet finibus placerat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi vitae lacinia orci. 
			Integer ut egestas mauris, ac auctor enim. 
			Nulla eget ante ut est vulputate efficitur. Donec iaculis magna at mauris condimentum, id suscipit dolor viverra. Curabitur placerat vehicula lacus. Fusce condimentum lobortis varius.
			</p><br>
			<h3> Coordonnées bancaires</h3>
					<div style="width:450px">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">#</span> <input type="text" class="form-control"
								placeholder="Card Number" aria-describedby="basic-addon1">
						</div>
						 <div class="form-group">
						Expiration <select class="form-control" style="width: 60px;">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<select class="form-control" style="width: 60px;">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">#</span> <input type="text" class="form-control"
								placeholder="Clé" aria-describedby="basic-addon1" size="30">
						</div>
						</div>
						 <s:form method="post" action="ValiderAbonnement"
						theme="simple">
						
						<s:submit value="Valider" />
					</s:form>
					</div>
					<hr>

				</td>
			</tr>
		</table>
	</div>

</body>
</html>