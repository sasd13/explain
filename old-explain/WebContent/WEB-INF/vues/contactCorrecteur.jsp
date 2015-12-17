<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- recuperer les parametres du modele -->
<%
	String nom =(String) request.getAttribute("txtNom");
	if (nom == null) nom = "";
	String prenom =(String) request.getAttribute("txtPrenom");	
	if (prenom == null) prenom = "";
	String urlAction=(String) request.getAttribute("urlAction");
 %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacter Correcteur</title>
<script  type="text/javascript"  src="effacer.js"></script>
<script  type="text/javascript"  src="envoyer.js"></script>
</head>

<body>

 <center>
 <h2>Contact à prendre</h2>
 <hr>
 <form name="contacterCorrecteur" action="urlAction" method="post">
 <table>
	 <tr>
		 <td>Nom</td>
		 <td><input name="txtNom" value="<%= nom %>" type="text" size="20"></td>
	 </tr>
	 <tr>
		 <td>Prénom</td>
		 <td><input name="txtPrenom" value="<%= prenom %>" type="text" size="20"></td>
	 </tr>
 </table>

 <table>
	 <tr>
		 <td><input type="submit" value="Submit"></td>
		 <td><input type="button" value="Envoyer" onclick = "envoyer()"></td>
		 <td><input type="button" value="Effacer" onclick = "effacer()"></td>
	 </tr>
 </table>
 
 <input type="hidden" name="action" value="valideContactCorrecteur">
 
 </form>
 </center>



</body>
</html>