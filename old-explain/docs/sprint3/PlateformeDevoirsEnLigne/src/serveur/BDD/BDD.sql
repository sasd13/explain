/*
 *************************************************************
 *           SOURCE DE LA BDD POUR LE PROJET FUN             *
 *                 (Génie Logiciel avancé)                   *
 *************************************************************
 */

/*
 * Version 1.0

 * Création de la BDD
 * - Tables de log et de sauvegarde d'informations des utilisateurs de la plateforme
 * - Table des cours
 * - Table des exercices
 * - Table des corrections
 * - Table des barèmes
 
 * Version 1.1

 * Après discussion (Thanh, Vincent)
 * - Amélioration du stockage des cours : Ajout des chapitres, parties
 * - Nomenclatures de certaines tables revues : exercices -> feuilles_devoir
 * - Gestion des correcteurs
 * - Organisation du code source et commentaires
 */

CREATE DATABASE "FUN"
  WITH OWNER = glafun
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'fr_FR.UTF-8'
       LC_CTYPE = 'fr_FR.UTF-8'
       CONNECTION LIMIT = -1;
       
CREATE SCHEMA public AUTHORIZATION glafun;

GRANT ALL ON SCHEMA public TO glafun;
COMMENT ON SCHEMA public IS 'Schema publique standard';


/*
 *************************************************************
 * Tables pour la structure du site                          *
 *************************************************************
 */

/* Table des utilisateurs
 * Permet d'identifier un utilisateur, connaitre son rôle et ses informations de base (e-mail, prénom, nom, date de naissance)
 * Une id est attribuée à chaque membre
 * Date de naissance sous la forme 'JJ:MM:AAAA'
 */
CREATE TABLE utilisateurs (
    id_utilisateur bigserial PRIMARY KEY,
    login character varying(30) NOT NULL,
    auth_serial character varying(255) NOT NULL,
    autorisation character(1) NOT NULL,
    email character varying(255) NOT NULL,
    prenom character varying(45) NOT NULL,
    nom character varying(65) NOT NULL,
    date_naissance character(10) NOT NULL,
    date_souscription character(10) NOT NULL,
    CONSTRAINT utilisateurs_autorisation_verif CHECK (autorisation = ANY(ARRAY['A', 'E', 'P'])),
    CONSTRAINT utilisateurs_login_uni UNIQUE (login),
    CONSTRAINT utilisateurs_email_uni UNIQUE (email)
);

/* Table des cours
 * Répertorie les cours :
 * 	- Id
 * 	- Intitulé
 * 	- Appartenance
 */
CREATE TABLE cours (
    id_cours bigserial PRIMARY KEY,
    titre character varying(255) NOT NULL,
    id_prof bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE SET NULL,
    visible boolean NOT NULL DEFAULT FALSE,
    CONSTRAINT cours_titre_uni UNIQUE (titre)
);

/* Table chapitre
 * Répertorie les chapitres
 * 	- Id
 * 	- Titre
 * 	- Id du cours
 * 	- Ordre
 */
CREATE TABLE chapitres (
    id_chapitre bigserial PRIMARY KEY,
    titre character varying(255) NOT NULL,
    id_cours bigint REFERENCES cours(id_cours) ON DELETE CASCADE,
    ordre int DEFAULT NULL,
    CONSTRAINT chapitre_titre_cours UNIQUE (titre, id_cours)
);

/* Table des parties
 * Répertorie les parties
 * 	- Id
 * 	- Titre
 * 	- Id du chapitre
 * 	- Ordre
 */
CREATE TABLE parties (
    id_partie bigserial PRIMARY KEY,
    titre character varying(255) NOT NULL,
    id_chapitre bigint REFERENCES chapitres(id_chapitre) ON DELETE CASCADE,
    ordre int DEFAULT NULL,
    CONSTRAINT parties_titre_chapitre UNIQUE (titre, id_chapitre)
);

/* Table d'associations des élèves aux cours
 * Répertorie quels élèves sont associés a quels cours :
 * 	- Id élève
 * 	- Id cours
 * 	- Date d'inscription
 */
CREATE TABLE eleve_cours (
    id_eleve bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE,
    id_cours bigint REFERENCES cours(id_cours) ON DELETE CASCADE,
    date_inscription character(8) NOT NULL,
    CONSTRAINT ele_cours_pkey PRIMARY KEY (id_eleve, id_cours)
);

/* Table des feuilles de devoir
 * Répertorie les devoirs :
 * 	- Id
 * 	- Emplacement sur le disque
 * 	- Appartenance (id_prof)
 * 	- Nombre de rendus
 * 	- Date de rendu max (Format JJ:MM:AAAA)
 */
CREATE TABLE feuilles_devoir (
    id_feuille_devoir bigserial PRIMARY KEY,
    emplacement character varying(255) NOT NULL,
    id_prof bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE SET NULL,
    max_rendus int NOT NULL,
    date_rendu character(10) NOT NULL,
    CONSTRAINT fd_max_rendus_verif CHECK max_rendus > 0,
    CONSTRAINT fd_emplacement_uni UNIQUE (emplacement)
);

/* Table d'associations des exercices aux cours
 * Répertorie quels exercices sont associés a quels cours :
 * 	- Id exercices
 * 	- Id cours
 * 	- Date de rendu
 */
CREATE TABLE exercice_partie (
    id_exercice bigint REFERENCES feuilles_devoir(id_feuille_devoir) ON DELETE CASCADE,
    id_partie bigint REFERENCES parties(id_partie) ON DELETE CASCADE,
    date_rendu character(8),
    CONSTRAINT exo_cours_pkey PRIMARY KEY (id_exercice, id_cours)
);

/* Table des correcteurs
 * Répertorie les correcteurs
 * 	- Id du correcteur
 * 	- Id de l'exercice pour lequel il est correcteur
 * 	- Etat (Si il est en attente d'accept : NULL, s'il a refusé on met a FALSE en attendant une suppression de la table, sinon TRUE)
 */
CREATE TABLE correcteurs (
    id_utilisateur bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE,
    id_exercice bigint REFERENCES feuilles_devoir(id_feuille_devoir) ON DELETE CASCADE,
    etat boolean DEFAULT NULL,
    CONSTRAINT correcteurs_id_user_id_exo_uni UNIQUE (id_utilisateur, id_exercice)
);


/*
 *************************************************************
 * Tables pour les exercices                                 *
 *************************************************************
 */
 
/* Table des barêmes
 * Répertorie les valeurs des exercices:
 * 	- Id exercice
 * 	- Numéro de la question
 * 	- Bareme
 */
CREATE TABLE baremes (
    id_exercice bigint REFERENCES feuilles_devoir(id_feuille_devoir) ON DELETE CASCADE,
    numero_question int NOT NULL,
    bareme float NOT NULL,
    CONSTRAINT exo_question_uni UNIQUE (id_exercice, numero_question)
);

/* Table des feuilles de réponses
 * Répertorie les feuilles de réponses et les brouillons des élèves:
 * 	- Id 
 * 	- Id élève
 * 	- Id exercice
 * 	- Id correcteur
 * 	- Rendu (permet de savoir si c'est cette feuille que l'élève rends au prof)
 * 	- Note (Note obtenue après correction)
 * 	- Etat (NC : non corrigé, C : corrigé, EC : en cours)
 */
CREATE TABLE feuilles (
    id_feuille bigserial PRIMARY KEY,
    id_eleve bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE,
    id_exercice bigint REFERENCES feuilles_devoir(id_feuille_devoir) ON DELETE CASCADE,
    id_correcteur bigint REFERENCES utilisateurs(id_utilisateur) ON DELETE RESTRICT DEFAULT NULL,
    rendu boolean DEFAULT TRUE,
    note float DEFAULT NULL,
    etat character varying(2) DEFAULT 'NC',
    CONSTRAINT feuilles_eleve_exo_rendu_uni UNIQUE (id_eleve, id_exercice, rendu),
    CONSTRAINT feuilles_etat_verif CHECK (etat = ANY(ARRAY['NC', 'EC', 'C'])),
    CONSTRAINT feuilles_correcteur_eleve_verif CHECK (id_eleve <> id_correcteur)
);

/* Table des réponses
 * Répertorie les réponses des élèves aux exercices :
 * 	- Id élève
 * 	- Id exercice
 * 	- Numéro de la question
 * 	- Réponse
 */
CREATE TABLE reponses (
    id_feuille bigint REFERENCES feuilles(id_feuille) ON DELETE CASCADE,
    numero_question int NOT NULL,
    note_pourcent float DEFAULT NULL,
    reponse text NOT NULL,
    CONSTRAINT reponses_feuille_exo_num_uni UNIQUE (id_feuille, numero_question),
    CONSTRAINT reponses_note_pourcent_verif CHECK (note_pourcent <= 1.0 AND note_pourcent >= 0.0)
);
