
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Categorie"%>
<ul class="nav nav-pills">
	<% 
  if(session.getAttribute("idCategorie")==null){ //pas de categorie selectionnee accueil actif
  %>
	<li role="presentation" class="active"><a href="Identification">Home</a></li>
	<%}else{ %>
	<li role="presentation"><a href="Identification">Home</a></li>
	<% } %>
	<c:forEach var="categorie"
		items="<%=session.getAttribute("categories")%>">
		<s:url action="categorie" var="urlCategorie">
			<s:param name="idCategorie">${categorie.getId()}</s:param>
		</s:url>

		<% Categorie c = (Categorie)pageContext.getAttribute("categorie");
			if(session.getAttribute("idCategorie")!=null && c.getId() == (Integer) session.getAttribute("idCategorie")) {
			%>
		<li role="presentation" class="active"><a
			href="<s:property value="#urlCategorie" />">${categorie.getLibelle()}</a></li>
		<% 
			}else{
			%>
		<li role="presentation"><a
			href="<s:property value="#urlCategorie" />">${categorie.getLibelle()}</a></li>
		<% 
			} %>

	</c:forEach>

</ul>