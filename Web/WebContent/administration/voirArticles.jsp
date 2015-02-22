<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Employe"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plateforme de gestion des articles</title>
</head>

<body>
<%@include file="homeAdministration.jsp" %>
<div style="width:  900px;margin: auto;background-color: #F8F8F8 ;color:black">
	<table style="width: 100%">
		<tr>
			
			<td width="85%;" style="padding:10px;"><c:forEach var="entry"
					items="<%=session.getAttribute("mesArticles")%>">

					<h2>${entry.getTitre()}</h2>
							${entry.getCorps()}
							<br>
							<br>
							<c:if test="${entry.getValidateur() == null }">
								<span style="font-style: italic;">status : NON VALIDE</span>
							</c:if>
							<c:if test="${entry.getValidateur() != null }">
								<span style="font-style: italic;">status : validé</span>
							</c:if>
							<hr>
					</c:forEach></td>
		</tr>
	</table>
</div>

</body>
</html>