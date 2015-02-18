<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="accueil.label" /></title>
<style type="text/css">
@import url(css/styles.css);
</style>
</head>
<body>
	<div id="enveloppe">
		maison du rédacteur
		<ul>
			<li><s:a href="govoirarticlesvalider">voir les articles à valider </s:a></li>
		</ul>
	</div>
</body>
</html>
