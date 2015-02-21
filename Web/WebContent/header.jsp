
<%@page import="controle.Parametres"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Lecteur;"%>
<div id="headerConnexion">
	<div style="float: left; margin-top: -10px">
		<h2>Plateforme Article</h2>
	</div>

	<div style="float: right; margin-right: 15px">
		<%
			if (session.getAttribute("lecteur") == ""
					|| session.getAttribute("lecteur") == null) {
		%>

		<p style="margin: 3px;">

			<s:form method="post" action="ValiderIdentification" theme="simple">
				<a class="btn btn-primary btn-sm" href="gotoInscription"
					role="button">Inscription</a>
				<s:textfield name="identifiant" id="identifiant" label="Identifiant"
					labelposition="left" cssClass="input" />
				<s:property value="errIidentifiant" />
				<s:password name="motdepasse" id="motdepasse" label="Mot de passe"
					labelposition="left" cssClass="input" />
				<s:property value="errMotdepasse" />
				<s:submit value="Identification" />
			</s:form>
		</p>
		<p style="margin: -16px; float: right; margin-right: 5px;">
			<s:a href="gotopage2">administration </s:a>
		</p>
		<%
			} else {
				Lecteur l = (Lecteur) session.getAttribute("lecteur");
		%>
		<p style="margin: 3px;">
			<%
				if (l.getStatus()== Parametres.LECTEUR_INSCRIT) {
			%>
			<a class="btn btn-primary btn-sm" href="gotoAbonnement" role="button">S'abonner</a>
			<%
				}
			%>
			Bonjour
			<%=l.getNom() + " " + l.getPrenom()%></p>
		<p style="margin: -5px; float: right; margin-right: 5px;">
			<s:a href="deconnexion">deconnexion </s:a>
		</p>
		<%
			}
		%>


	</div>
</div>