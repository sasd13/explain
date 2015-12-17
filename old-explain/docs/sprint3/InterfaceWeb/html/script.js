/*
 * Université Paris Diderot: Projet Génie Logiciel
 *
 * Copyright (c) Barillot Anthony,
 *               Boudjemai Celia, 
 *               Joyez Jason, 
 *               Leclercq Vincent,
 *               Legueux Jules
 */

 

/* VARIABLES GLOBALES */
 
/*
 * Variable globale pour suivre le nombre de question
 */
var blocNumber = 1;
var questionNumber = 1;



/* BOUTONS CSS */
 
/*
 * Importer un fichier XML
 */
function importFile() {
	if(document.getElementById("import-file")) {
		exit();
	} else if (document.getElementById("new-exo")) {
		removeChildNodes("exercice-contenu");
		hideItem("exercice-soumission");
		blocNumber = 1;
		questionNumber = 1;
	}
	
	var elem = document.getElementById("exercice-contenu");
	
	var input = document.createElement("input"); // Selecteur de fichier
	input.setAttribute("type", "file");
	input.setAttribute("id", "import-file");
	
	var submit = document.createElement("input"); // Bouton envoyer
	submit.setAttribute("type", "button");
	submit.setAttribute("value", "Envoyer!");
	
	elem.appendChild(addText("Selectionner votre fichier a envoyer.")); // Insertion des éléments
	elem.appendChild(input);
	elem.appendChild(addText(""));
	elem.appendChild(submit);
}

/*
 * Créer un exercice XML
 */
function createExercice() {
	if(document.getElementById("new-exo")) {
		exit();
	} else if (document.getElementById("import-file")) {
		removeChildNodes("exercice-contenu");
	}
 
	var elem = document.getElementById("exercice-contenu");
	var myButton = new Array("QCM", "QRF", "Programme", "QL");
	var myFunction = new Array("addQcm()", "addQrf()", "addProgramme()", "addQuestionLibre()");

	var p = addText("Cliquez au choix sur un des bouttons pour ajouter une question a l'exercice.");
	p.setAttribute("id", "new-exo");
	elem.appendChild(p);
	
	for(var i = 0; i < myButton.length; i++) {
		var item = document.createElement("input");
		item.setAttribute("type", "button");
		item.setAttribute("onclick", myFunction[i]);
		item.setAttribute("value", myButton[i]);
		elem.appendChild(item);
	}
	
	var p = addText("Exercice vide.");
	p.setAttribute("id", "exercice-vide");
	elem.appendChild(p);
}



/* BOUTONS EXERCICES */

/*
 * QCM : Questionnaire à choix multiple
 */
 function addQcm() {
	addLabel();
	addQuestion();
	var addItem = document.getElementById("idBloc" + blocNumber);
	var ul = document.createElement("ul");
	ul.id = "hy";
	for(i = 0; i < 3; i++) {
		var id = "idQuestion" + questionNumber + "idCheckbox" + i;
		var id2 = "idQuestion" + questionNumber + "idLabel" + i;
		addItemQcm(ul, id, "test", "testons", id2);
	}
	addItem.appendChild(ul);
	
	//
	var button = document.createElement("button");
	button.setAttribute("type", "button");
	button.setAttribute("onclick", 'addItemQcm(hy,' + "id" + ',' + "name" + ',' + "value" + ',' + id2 + ');');
	button.innerHTML = "Ajouter une reponse";
	addItem.appendChild(button);
	//
	
	//
	var buttonDelete = document.createElement("button");
	buttonDelete.setAttribute("type", "button");
	buttonDelete.setAttribute("onclick", 'deleteLastItem("hy");');
	buttonDelete.innerHTML = "Supprimer une reponse";
	addItem.appendChild(buttonDelete);
	//
	
	blocNumber++;
	questionNumber++;
}

/*
 * QRF : Question à réponse formaté
 */
function addQrf() {
	addLabel();
	addQuestion();
	var addItem = document.getElementById("idBloc" + blocNumber);
	addItem.appendChild(addAnswerFormated());
	blocNumber++;
	questionNumber++;
}

/*
 * Programme : Envoyer un fichier
 */
function addProgramme() {
	addLabel();
	addQuestion();
	var addItem = document.getElementById("idBloc" + blocNumber);
	addItem.appendChild(addFile());
	blocNumber++;
	questionNumber++;
}

/*
 * Question Libre : Question limité par un certains nombre de caractère
 */
function addQuestionLibre() {
	addLabel();
	addQuestion();
	var addItem = document.getElementById("idBloc" + blocNumber);
	addItem.appendChild(addNumberOfCharacter());
	blocNumber++;
	questionNumber++;
}



/* HELPERS */

/* 
 * Rendre invisible un élément : argument ID
 */
function hideItem(id) {
	document.getElementById(id).style.visibility="hidden";
}

/* 
 * Rendre visible un élément : argument ID
 */
function showItem(id) {
	document.getElementById(id).style.visibility="visible";
}

/*
 * Supprimer un élément : argument ID
 */
function removeElement(id) {
	var element = document.getElementById(id);
	element.parentNode.removeChild(element);
}

/*
 * Supprime tous les noeuds d'un noeud
 */
function removeChildNodes(id) {
	var parent = document.getElementById(id);
	while(parent.hasChildNodes()) {
		parent.removeChild(parent.childNodes[0]);
	}
}

/*
 * Créer un élément texte
 */
function addText(texte) {
	var p = document.createElement("p");
	var text = document.createTextNode(texte);
	p.appendChild(text);
	return p;
}

/*
 * Label : Numéro de question
 */
function addLabel() {
	var addLabel = document.getElementById("exercice-contenu");
	var div = document.createElement("div");
	var titre = document.createElement("h3");
	titre.appendChild(addText("Question "+ questionNumber +":"));
	div.setAttribute("id", "idBloc" + blocNumber);
	div.appendChild(titre);
	addLabel.appendChild(div);
}
  
/*
 * Texte : Question
 */
function addQuestion() {
	noEmpty();
	var addQuestion = document.getElementById("idBloc" + blocNumber);
	var p = addText("Cliquez ici pour modifier la question.");
	p.setAttribute("id", "idQuestion" + questionNumber);
	p.setAttribute("ondblclick", 'changeText(id);');
	addQuestion.appendChild(p);
}

/*
 * Texte : Réponse
 */
function addAnswer(id) {
	var label = document.createElement("label");
	var node = document.createTextNode("Cliquez ici pour modifier la reponse.");
	label.setAttribute("id", id);
	label.setAttribute("class", "reponse");
	label.setAttribute("ondblclick", "changeText(id);");
	label.appendChild(node);
	return label;
}

/*
 * Réponse : Checkbox + Texte
 */
function addItemQcm(ul, idCheckbox, name, value, idAnswer) {
	var li = document.createElement("li");
	li.appendChild(addAnswer(idAnswer));
	ul.appendChild(li);
}

/*
 * Supprimer la dernière réponse au QCM
 */
function deleteLastItem(id) {
	var liste = document.getElementById(id);
	if(liste.childNodes.length > 2) {
		liste.lastChild.remove();
	} else {
		alert("Il doit au moins y avoir deux reponses possibles");
	}
}

/*
 * Réponse : Réponse formaté
 */
function addAnswerFormated() {
	var input = document.createElement("input");
	input.setAttribute("type", "text");
	input.setAttribute("size", "40px");
	input.setAttribute("placeholder", "Entrer le format de reponse ici...");
	input.setAttribute("class", "input_text");
	//input.setAttribute("id", id);
	//input.setAttribute("name", name);
	return input;
}

/*
 * Fichier envoyé : Champ pour soumettre un exercice
 */
function addFile() {
	var input = document.createElement("input");
	input.setAttribute("type", "file");
	//input.setAttribute("id", id);
	//input.setAttribute("name", name);
	return input;
}

/*
 * Nombre de caractères pour une question libre
 */
function addNumberOfCharacter() {
	var input = document.createElement("input");
	input.setAttribute("type","text");
	input.setAttribute("size","40px");
	input.setAttribute("pattern","[1-9]{1}[0-9]{3}");
	input.setAttribute("placeholder","Entrer ici le nombre de mot maximum...");
	input.setAttribute("class", "input_text");
	return input;
}

/*
 * Question et Réponse : Changer le contenue d'une champs texte
 */
function changeText(id) {
	var elem = document.getElementById(id);
	var oldValue = elem.innerHTML;
	var textbox = document.createElement("input");
	textbox.setAttribute("type", "text");
	textbox.setAttribute("value", "Entrer le nouveau texte...");
	textbox.setAttribute("size", textbox.value.length);
	textbox.setAttribute("class", "input_text");
	textbox.onclick = function() {
		textbox.setAttribute("value", "");
	};
	textbox.onblur = function() {
		var newValue = this.value;
		if(newValue == '' || newValue == 'Entrer le nouveau texte...') {
			this.parentNode.innerHTML = oldValue;
		} else {
			this.parentNode.innerHTML = newValue;
		}
	};
	elem.innerHTML = '';
	elem.appendChild(textbox);
}

/*
 * Initialisation de l'interface au chargement de la page
 */
function initLoad() {
	var exercice = document.getElementById("exercice-contenu");
	if(exercice.childNodes.length <= 3) {
		hideItem("exercice-soumission");
	}
}

/*
 * Affiche le bouton pour soumettre l'exercice quand il y a une question d'ajouté
 */
function noEmpty() {
	if(document.getElementById("exercice-soumission")) {
		if(document.getElementById("exercice-soumission").style.visibility=="hidden") {
			showItem("exercice-soumission");
		}
	}
	if(document.getElementById("exercice-vide")) {
		removeElement("exercice-vide");
	}
}