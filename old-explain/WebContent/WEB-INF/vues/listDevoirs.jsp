<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/taglibs-datetime.tld" prefix="dt" %>
<%@ page isELIgnored="false" %>




<!--initialisation la vue [feuillesDevoisAFaire.jsp]  -->

<%@ page import="java.util.List"  %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="Entites.*" %> 
<%@ page import="Dao.*" %> 
<%@ page import= "java.util.Date" %>

<%
	//creer test pour FeuilleDevoir
	FeuilleDevoir feuilleDevoir1 = new FeuilleDevoir(1, "f1", 1, 1, 2, new Date("27/05/2014"), "adr devoir");
	FeuilleDevoir feuilleDevoir2 = new FeuilleDevoir(2, "f2", 1, 1, 2, new Date("27/05/2014"), "adr devoir");
	FeuilleDevoir feuilleDevoir3 = new FeuilleDevoir(3, "f3", 1, 1, 2,new Date("27/05/2014"), "adr devoir");

	
	IAccesData dao = new AccesDataImpl();
	dao.ajoutFeuilleExo(1, feuilleDevoir1);
	dao.ajoutFeuilleExo(1, feuilleDevoir2);
	dao.ajoutFeuilleExo(1, feuilleDevoir3);	
	
	List<FeuilleDevoir> listeDevoirs = (List<FeuilleDevoir>) dao.selectAllDevoirs();
	
	request.setAttribute("listeDevoirs", listeDevoirs);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page etudiant</title>
</head>
<body>
	<h1>liste des feuilles devoirs à faire </h1>

		<table>
			<tr>
				<th>Id |</th>
				<th>nom de Feuille |</th>
				<th>id Prof |</th>
				<th>id Cours |</th>
				<th>id Partie |</th>
				<th>id chapitre |</th>
				<th>nbrRenduPermis |</th>
				<th>Date soumission |</th>
				<th>Emplacement</th>
			</tr>

			<c:forEach var="feuilleDevoir" items="${listeDevoirs}">
				<tr>
					<td><c:out value="${feuilleDevoir.id}"/></td>
					<td><c:out value="${feuilleDevoir.nomFeuille}"/></td>
					<td><c:out value="${feuilleDevoir.idProf}"/></td>
					<td><c:out value="${feuilleDevoir.idCours}"/></td>										
					<td><c:out value="${feuilleDevoir.maxRendu}"/></td>
					<td><c:out value="${feuilleDevoir.dateRendu}"/></td>
					<td><dt:format pattern="dd/MM/yyyy">${feuilleDevoir.dateRendu.time}</dt:format></td>				
					<td><c:out value="${feuilleDevoir.emplacement}"/></td>
				</tr>
			</c:forEach>
		</table>
	
</body>
</html>