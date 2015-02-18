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
	<%
		Article a = new Article();
		a.setIdArticle(Integer.parseInt(request.getParameter("id")));
		a.setTitre(request.getParameter("titre"));
		a.setCorps(request.getParameter("corps"));
		a.setPrix(Float.valueOf(request.getParameter("prix")));
		a.setValidateur((Redacteur)session.getAttribute("redacteur"));

		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		InitialContext ctx;
		try {
			ctx = new InitialContext(props);
			GestArticleInterface bean = (GestArticleInterface) ctx
					.lookup("java:global/EARTest/Gestion/GestionArticles!articles.GestArticleInterface");
			bean.updateArticle(a);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	%>
	<c:redirect url="http://localhost:8080/Web/govoirarticlesvalider"/>
</body>
</html>