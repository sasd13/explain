<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- initialisation vue [entete.jsp] -->

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%
	//lien 1
	Map<String,String> link1 = new HashMap<String,String>();
	link1.put("href", "href1");
	link1.put("lien","listCoursPage");
	
	//lien 2
	Map<String,String> link2= new HashMap<String, String>();
	link2.put("href", "href2");
	link2.put("lien", "liste de cours");

	Map<String, String> link3= new HashMap<String,String>();
	link3.put("hrep", "hrep3");
	link3.put("lien", "mes cours");
	
	Map<String, String> link4= new HashMap<String,String>();
	link4.put("hrep", "hrep4");
	link4.put("lien", "contact correcteur");
	
	// tableau de liens
	Map[] liens = new Map[]{link1, link2,link3, link4};

	// le tableau des liens est placé dans le requête du client
	request.setAttribute("liens", liens);
%>



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>entete</title>
	</head>
	<body>
		<table>
			
			<tr>
				<td ><h2>Page etudiant</h2></td>
			</tr>
			<tr>
				<td>|</td>
				<td><a href="./vues/contactCorrecteur.jsp">Contacter le Correcteur</a>
			
				<td>|</td>
				<td><a href="./vues/mesCours.jsp">Mes cours</a>
				
				<td>|</td>
				<td><a href="./vues/listDevoirs.jsp">Liste de devoirs</a></td>
				
				<td>|</td>
				<td><a href="./vues/listCours.jsp">Liste de cours</a></td>				
			</tr>
		</table>
	</body>
</html>