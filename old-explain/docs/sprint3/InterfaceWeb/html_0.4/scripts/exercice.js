// Constantes
const EXO_QP  = "QP";
const EXO_QL  = "QL";
const EXO_QCM = "QCM";
const EXO_QRF = "QRF";

// Importer un exercice
function importFile() {
	initDiv("import");
	if($('#import-file').length == 0) {
		var bloc = '<div id="import-file">';
		var input = '<input id="import-file-chooser" type="file">';
		$('#exercice-contenu').append(bloc);
		$('#import-file').append(input);
		$('#import-file').append('<br>');
		sendButton();
	} else {
		alert("Attention :\nVous ne pouvez pas cliquer deux fois sur ce bouton!");
	}
}

// Afficher exercice Exercice (renommé showExercice())
function createExercice() {
	initDiv("exercice");
	if($('#new-exo').length == 0) {
		var bloc = '<div id="new-exo">'; // bloc d'un exercice
		var exo = new exercice();
		$('#exercice-contenu').append(bloc);
		var blocQuestions = '<div id="button-exo">';
		$('#new-exo').append(blocQuestions); // bloc boutons des questions
		var buttonQP  = '<input id="buttonQP"  type="button" onclick="addQ(EXO_QP)" value="QP"  >';
		var buttonQL  = '<input id="buttonQL"  type="button" onclick="addQ(EXO_QL)" value="QL"  >';
		var buttonQCM = '<input id="buttonQCM" type="button" onclick="addQ(EXO_QCM)" value="QCM" >';
		var buttonQRM = '<input id="buttonQRF" type="button" onclick="addQ(EXO_QRF)" value="QRF" >';
		$('#button-exo').append(buttonQP);
		$('#button-exo').append(buttonQL);
		$('#button-exo').append(buttonQCM);
		$('#button-exo').append(buttonQRM);
		var blocContent = '<div id="content-exo">';
		$('#new-exo').append(blocContent); // bloc contenu
		$('#new-exo').append('<br>');
		sendButton();
	} else {
		alert("Attention :\nVous ne pouvez pas cliquer deux fois sur ce bouton!");
	}
	
	this.addQ = function addQ(type) {
		switch(type) {
		case EXO_QP:
			exo.addQuestion(new question(exo.getLength()+1, "QP" ));
			break;
		case EXO_QL:
			exo.addQuestion(new question(exo.getLength()+1, "QL" ));
			break;
		case EXO_QCM:
			exo.addQuestion(new question(exo.getLength()+1, "QCM" ));
			break;
		case EXO_QRF:
			exo.addQuestion(new question(exo.getLength()+1, "QRF" ));
			break;
		default:
			alert("Erreur");
			break;
		}
	}
}

// Bouton envoyer l'exercice
function sendButton() {
	var input = '<input id="send-button" type="submit" value="Soumettre l\'exercice">';
	$('#exercice-contenu').append(input);
}

// Création d'un exercice
function exercice() {
	var arrayQuestions = [];
	this.getLength = function getLength() { // taille du tableau de question
		return arrayQuestions.length;
	}
	this.addQuestion = function addQuestion(Object) { // ajoute un élément
		arrayQuestions.push(Object);
		var current = arrayQuestions[arrayQuestions.length-1];
		current.displayQuestion();
	}
	this.removeQuestion = function removeQuestion(index) { // supprime un élément
		if(arrayQuestions.length > 0) {
			arrayQuestions.splice(index, 1);
		}
	}
	this.display = function display() { // affiche un exercice
		for(i = 0; i < arrayQuestions.lenght; i++) {
			alert("Test");
			alert(arrayQuestions.diplayQuestion);
		}
	}
}

// Création d'une question
function question(id, type) {
	this.id = id;
	this.type = type;
	this.displayQuestion = function displayQuestion() {
		switchQuestions(id, type);
	}
}

// Switch question
function switchQuestions(id, type) {
	// partie commune aux questions
	var bloc = "<div id=question-exo" + id + " type=" + type + ">";
	var question_title = "<h2>Question " + id + " :</h2>";
	var question_question = "<input type=\"text\" placeholder=\"Veuillez entrer votre question...\" size=\"40px\" />";
	$('#content-exo').append(bloc); // bloc
	$('#question-exo' + id).append(question_title); // titre
	$('#question-exo' + id).append(question_question); // question
	
	switch(type) {
	case EXO_QP:
		var question_QP = "<p>Fichiers annexes : </p> <input type=\"file\" />";
		$('#question-exo' + id).append(question_QP);
		break;
	case EXO_QL:
		var question_QL = "<p>Nombre de charact&egrave;re maximum : </p> <input type=\"text\" placeholder=\"Veuillez entrer un nombre...\" size=\"40px\" />";
		$('#question-exo' + id).append(question_QL);
		break;
	case EXO_QCM:
		var question_QCM = "<p id=answer" + id + ">R&eacute;ponses : </p>";
		$('#question-exo' + id).append(question_QCM);
		var reponse = "<div id=reponse-qcm-exo" + id + " >";
		$('#question-exo' + id).append(reponse);
		var new_QCM = new prepare_QCM(); // Object réponse QCM
		var button_add_QCM = '<input id=button_add' + id +  ' type="button" value="Ajouter"/>'; 
		$('#question-exo' + id).append(button_add_QCM);
		$('#button_add' + id).click( function(){ new_QCM.addQcm(id); });
		break;
	case EXO_QRF:
		var question_QRF = "<p>Expression r&eacute;guli&egrave;re : </p> <input type=\"text\" placeholder=\"Veuillez entrer l'expresion r&eacute;guli&egrave;re...\" size=\"40px\" />";
		$('#question-exo' + id).append(question_QRF);
		break;
	default:
		alert("err: entr&eacute;e non valide");
		break;
	}
}

function prepare_QCM() {
	var answers = [];
	this.addQcm = function addQcm(id) {
		var bloc = "<div id=reponse-qcm-exo" + id + "-question" + this.size + ">";
		var code = '<input type="checkbox" name="choix1" value="1"> <input type="text" name="choix1" placeholder="Veuillez entrer une r&eacute;ponse..." size="40px" > <img id=delete' + id + '-question' + this.size + ' src="./images/cross_red.png" width="16px" height="16px" onclick="removeQcm(' + id + ',' + this.size + ')" /> <br />';
		$('#reponse-qcm-exo' + id).append(bloc);
		$('#reponse-qcm-exo' + id + "-question" + this.size).append(code);
		this.size++;
	}
	/*this.removeQcm = function removeQcm(id, index) {
		//if(this.size > 0 && index > 0 && index < this.size) {
			var i = this.size;
			answers.splice(i-1, 1);
			this.size--;
			$('#reponse-qcm-exo' + id + '-question' + index).remove();
		//}
	}*/
	this.size = 0;
	this.downSize = function downSize() {
		this.size--;
	}
	this.upSize = function upSize() {
		this.size++;
	}
	this.getSize = function getSize() {
		return this.size;
	}
}

// Supprime  une réponse d'un QCM
function removeQcm(id, index) {
	with(this) {
		$('#reponse-qcm-exo' + id + '-question' + index).remove();
		this.size--;
	}
}

// Supprime une div
function removeDivById(id) {
	$('#' + id).remove();
}

// Initialise les blocs
function initDiv(flags) {
	if(flags == "import") {
		if($('#new-exo').length) {
			removeDivById('new-exo');
			removeDivById('send-button');
		}
	} else if(flags == "exercice") {
		if($('#import-file').length) {
			removeDivById('import-file');
			removeDivById('send-button');
		}
	}
}
