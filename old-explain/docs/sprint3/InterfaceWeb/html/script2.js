// Constantes
const EXO_QP  = "QP";
const EXO_QL  = "QL";
const EXO_QCM = "QCM";
const EXO_QRF = "QRF";

// Importer un exercice
function importFile() {
	//if(!$('#exercice-contenu').find("input").attr("id","import-file")) {
		var input = '<input id="import-file" type="file">';
		$('#exercice-contenu').append(input);
		$('#exercice-contenu').append('<br/>');
		sendButton();
		var exo = new exercice();
		exo.addQuestion(new question("1", "QL", "Question 1 :"));
		exo.addQuestion(new question("2", "QP", "Question 2 :"));
		exo.addQuestion(new question("3", "QCM", "Question 3 :"));
		exo.addQuestion(new question("4", "QRF", "Question 4 :"));
		//exo.display();
	//}
}

// Bouton envoyer l'exercice
function sendButton() {
	var input = '<input id="send-button" type="button" value="Soumettre l\'exercice">';
	$('#exercice-contenu').append(input);
}
/////////////////////////////////////////////////////////////////////////////////////////
/*var test = new CreerChien("TEST", "TEST2");
test.Afficher();

function CreerChien(le_nom,la_race) {
	this.nom=le_nom;
	this.race=la_race;
	this.Afficher = AfficherChien;
}

function AfficherChien() {
	with(this) {
		alert("Ce chien s'appelle "+this.nom+". C'est un "+this.race+".<BR>");
	}
}*/

/////////////////////////////////////////////////////////////////////////////////////////

// Création d'un exercice
function exercice() {
	var arrayQuestions = [];
	this.addQuestion = function addQuestion(Object) { // ajoute un élément
		arrayQuestions.push(Object);
		var size = arrayQuestions.length;
		var current = arrayQuestions[size-1];
		current.displayQuestion();
		//var code = "<h2 id=" + current.id + " type=" + current.type + ">" + current.sentence + "</h2>";
		//$('#exercice-contenu').append(code);
	}
	this.removeQuestion = function removeQuestion(index) { // supprime un élément
		if(arrayQuestions.lenght != 0) {
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
function question(id, type, sentence) {
	this.id = id;
	this.type = type;
	this.sentence = sentence;
	this.displayQuestion = function displayQuestion() {
		switchQuestions(id, type, sentence);
	}
}

// Switch question
function switchQuestions(id, type, sentence) {
	// Question commun à toute
	var question_title = "<h2 id=" + id + " type=" + type + ">" + sentence + "</h2>";
	$('#exercice-contenu').append(question_title);
	
	switch(type) {
	case EXO_QP:
		var question_QP = "<p>Fichiers annexes : </p> <input id=" + id + " type=\"file\" />";
		$('#exercice-contenu').append(question_QP);
		break;
	case EXO_QL:
		var question_QL = "<p>Nombre de charact&egrave;re limite : </p> <input id=" + id + " type=\"text\" placeholder=\"Veuillez entrer un nombre...\" size=\"40px\" />";
		$('#exercice-contenu').append(question_QL);
		break;
	case EXO_QCM:
		var question_QL = "<p id=answer" + id + ">R&eacute;ponses : </p>";
		$('#exercice-contenu').append(question_QL);
		var test = new prepare_QCM();
		test.addQcm();
		test.addQcm();
		test.addQcm();
		test.addQcm();
		test.addQcm();
		test.addQcm();
		test.removeQcm(0);
		break;
	case EXO_QRF:
		var question_QRF = "<p>Expression r&eacute;guli&egrave;re : </p> <input id=" + id + " type=\"text\" placeholder=\"Veuillez entrer l'expresion r&eacute;guli&egrave;re...\" size=\"40px\" />";
		$('#exercice-contenu').append(question_QRF);
		break;
	default:
		alert("err: entr&eacute;e non valide");
		break;
	}
}

function prepare_QCM() {
	var answers = [];
	this.addQcm = function addQcm() {
		var code = "<input type=\"checkbox\" name=\"choix1\" value=\"1\"> <input type=\"text\" name=\"choix1\" placeholder=\"Veuillez une r&eacute;ponse...\" size=\"40px\" > <br />";
		$('#exercice-contenu').append(code);
	}
	this.removeQcm = function removeQcm(index) {
		if(answers.lenght != 0) {
			answers.splice(index, 1);
		}
	}
}

/////////////////////////////////////////////////////////////////////////////////////////

/*/ Question de programmation
function question_QP() {

}

// Question libre
function question_QL() {

}

// Question à choix multiples
function question_QCM() {

}

// Question à réponse formaté
function question_QRF() {

}

// Champs text
function input(id, ) {
	var
}*/