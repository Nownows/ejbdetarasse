<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td width="15%;"><s:form method="post"
					action="ValiderIdentification">
					<s:textfield name="identifiant" id="identifiant"
						label="Identifiant" labelposition="top" cssClass="input" />
					<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
						labelposition="top" cssClass="input" />
					<s:submit value="Identification" />
				</s:form>
			</td>
			<td width="85%;">
				<table border="1" width="100%">
					<tr>
						<td>Article 1</td>
						<td>actions</td>
					</tr>
					<tr>
						<td>Article 2</td>
						<td>actions</td>
					</tr>
					<tr>
						<td>Article 3</td>
						<td>actions</td>
					</tr>
				</table>
				<s:a href="gotopage2">ouvrir la page </s:a>
			</td>
		</tr>
	</table>


</body>
</html>