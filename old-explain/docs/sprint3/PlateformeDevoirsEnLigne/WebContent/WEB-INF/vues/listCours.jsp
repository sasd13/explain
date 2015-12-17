<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<%@ page isELIgnored="false" %>



<%@ page import="Entites.*" %>
<%@ page import="Dao.*" %>
<%@ page import="java.util.List"  %>
<%@ page import="java.util.ArrayList" %>

<%

Cours cours1 = new Cours(1,"cours 1", 1,true,null);
Cours cours2 = new Cours(2,"cours 2", 1, true,null);
Cours cours3 = new Cours(3,"cours 3", 1,true,null);

IAccesData dao = new AccesDataImpl();

dao.insertCours(cours1);
dao.insertCours(cours2);
dao.insertCours(cours3);
List<Cours> listCours = (List<Cours>) dao.selectAllCours();
request.setAttribute("listeCours", listCours);
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>entete</title>
	</head>
	<body>
	

		<hr> 
			<h2>Liste de cours</h2>
			 <table>
 				<tr>
					<th>id |</th>
					<th>titre   |</th>
					<th>id prof |</th>
					<th>visible |</th>
 				</tr> 
 				
 				<!-- parcourir la listeCours qui est récuperer dans "items"-->
 				<c:forEach var="cour" items="${listeCours}">
 				<tr>
					<td><c:out value="${cour.idCours} |"/></td>
					<td><c:out value="${cour.titre}|"/></td>
					<td><c:out value="${cour.idProf} |"/></td>						 					
					<td><c:out value="${cour.visible} |"/></td>				
				</tr>
				</c:forEach>
							
			</table> 
	</body>
</html>