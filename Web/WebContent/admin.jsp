<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form method="post" action="ValiderIdentification">
		<s:textfield name="identifiant" id="identifiant" label="Identifiant"
			labelposition="top" cssClass="input" />
		<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
			labelposition="top" cssClass="input" />
		<s:submit value="Identification" />
	</s:form>
</body>
</html>