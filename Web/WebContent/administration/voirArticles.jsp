<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="articles.GestArticleInterface"%>
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
			
			<td width="85%;" style="padding:10px;">
			<%
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			GestArticleInterface bean = (GestArticleInterface) ctx
					.lookup("java:global/EARTest/Gestion/GestionArticles!articles.GestArticleInterface");
					Journaliste j = (Journaliste)session.getAttribute("journaliste");
			%>
			<c:forEach var="entry"
					items="<%=bean.getArticlesByJournalist(j)%>">

					<h2>${entry.getTitre()}</h2>
							${entry.getCorps()}
							<br>
							<br>
							<c:if test="${entry.getValidateur() == null }">
								<span style="font-style: italic;color:red;">status : NON VALIDE</span>
							</c:if>
							<c:if test="${entry.getValidateur() != null }">
								<span style="font-style: italic;color:green;">status : validé</span>
							</c:if>
							<hr>
					</c:forEach> 
			<%
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%></td>
		</tr>
	</table>
</div>

</body>
</html>