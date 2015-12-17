function envoyer()
	{
		//vérifier les parametres avant de les envoyer
		with(document.contacterCorrecteur){
			//le nom ne doit pas etre vide
			champNom=/^\s*$/.exec(txtNom.value);
			
			if (champNom != null)
			{	//le nom est vide
				alert("vous devez indiquer un nom");
				txtNom.value = "";
				//positionner le cursor clignotant sur le champ [txtNom]
				txtNom.focus();
				//retourner à l'interface visuelle, pas de POST au server, des valeurs saisies
				return;
			}
			
			//prenom ne doit pas etre vide
			champPrenom = /^\s*$/.exec(txtPrenom.value);
			if (champPreNom != null)
			{	//le nom est vide
				alert("vous devez indiquer un prenom");
				txtPreNom.value = "";
				txtPreNom.focus();
				return;
			}
			//si tout correct
			sumit();
		}
		
	}