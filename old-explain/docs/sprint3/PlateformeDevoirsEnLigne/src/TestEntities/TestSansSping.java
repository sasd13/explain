package TestEntities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Dao.AccesDataImpl;
import Dao.IAccesData;
import Entites.Cours;
import Entites.ElementExo;
import Entites.Etudiant;
import Entites.ListCours;
import Entites.ListEtudiants;
import Entites.Professeur;
import Entites.Qcm;
import Entites.Question;
import Entites.ReponseAChoisir;
import Entites.ReponseValide;
import Entites.TypeExercice;
import Entites.User;

/* ce test n'a pas encore utiliser Spring et base de donnees postgresql*/
public class TestSansSping {

	public static void main(String[] args)
	{
		
		User user=new Etudiant(1,"","", "le","thanh",
				"11/04/2014","lethanh11_4@hotmail.com",null);
		System.out.println(user.toString());
		
		Professeur prof = new Professeur(2,"","", "Yunes","Jean Baptiste",
				"11/04/2014","Yunes.Jean.Baptiste@liafa.fr");
		System.out.println(prof.toString());
		
		Professeur prof2 = new Professeur(prof);
		System.out.println(prof2.toString());
		
		System.out.println("***********************");
		
		//liste de reponses Qcm
		List<ReponseAChoisir> listReponses = new ArrayList<ReponseAChoisir>();
		
		//creer Reponse(idQuestion, reponse);
		
		ReponseAChoisir reponse_q1 = new ReponseAChoisir(1,1, "som egale à 2",2);

		listReponses.add(0, reponse_q1);
		listReponses.add(1, new ReponseAChoisir(2, "som egale à 3"));
		listReponses.add(2, new ReponseAChoisir(3,"som est 5"));
		
		//creer question Qcm
		Question q1 = new Question(1,1, "1 + 1 egale combien?");
		Question q3 = new Question(2,3, "2 * 2 = ?");
/* Exercice(int id,TypeExercice typeExo , int idFeuille,
			int numberExo, Question question)*/		
		//creer un Qcm
		Qcm qcm1 = new Qcm(5,TypeExercice.Qcm, 1, 2 ,q1,listReponses);
		System.out.println(qcm1.toString()+"\n");
		
		//creer QCM corrigé : c'est la question 1 de la Qcm 1
		ReponseValide reponseValide = new ReponseValide(reponse_q1.getId(),1,reponse_q1.getNumero(),reponse_q1.getChaine() );
		
		System.out.println(reponseValide.toString());
		
		
		ElementExo e = new ElementExo(4,4, "ttttttttttttttt", 109);
		System.out.println(e.toString());
		
		Cours cours1 = new Cours();
		Cours cours2 = new Cours();
		Cours cours3 = new Cours();
		ArrayList<Cours> listeCours = new ArrayList<Cours>();
		listeCours.add(cours1);
		listeCours.add(cours2);
		listeCours.add(cours3);
		
		ListCours listCours= new ListCours();
		listCours.setListCours(listeCours);
		System.out.print("\nlisteCours : "+listCours.toString());
		
		Etudiant e1 = new Etudiant(3,"","", "Chroboczeck","Francois","06/04/2014","francois@hotmail.com",null);
		Etudiant e2 = new Etudiant(4,"","", "Nguyen","Ha","06/04/2014","ha@hotmail.com",null);
		Etudiant e4 = new Etudiant(5,"","", "Lacroix","Jean","07/05/2014","jean@hotmail.com",null);
		
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		etudiants.add(e1);
		etudiants.add(e2);
		System.out.print("\nlistEtudiants : "+etudiants.toString());
		
		ListEtudiants listEtu = new ListEtudiants();
		listEtu.setListEtudiants(etudiants);
		ArrayList<Integer> l  = new ArrayList<Integer>();
		l.add(new Integer(3));
		l.add(new Integer(4));
		cours1.setIdsEtudiant(l);
		List<Integer> ids= cours1.getIdsEtudiant();
		//ajoutIdEtudiant(cours1, 15);
		System.out.print("\n les ids etu du cours1 : "+ids);
		System.out.print("\n cours1: "+cours1.toString()+"\n");
		cours1.setIdCours(6);
		System.out.print("\n cours1 now: "+cours1.toString()+"\n");
		
		
		//test Dao:
		System.out.println("\n\n------------test Dao----------------\n");
		
		
		IAccesData daoImpl = new AccesDataImpl();
		daoImpl.insertCours(cours1);
		daoImpl.insertCours(cours2);
		List<Cours> listcours = (List<Cours>) daoImpl.selectAllCours();  
		if (listcours != null)
			System.out.println("list cours:");  
		for (Iterator<Cours> iter=  listcours.iterator(); iter.hasNext(); )
			System.out.println(iter.next().toString()); 

		daoImpl.insertEtudiant(e1);
		daoImpl.insertEtudiant(e2);
		
		System.out.println("listE : "+daoImpl.selectAllEtudiants()); // problem
	
		System.out.println("etudiant4: "+e4.toString());
		daoImpl.insertEtudiant(e4);
		daoImpl.saveEtudiantAuCours(cours1, e4.getId()); 
		System.out.println(cours1.toString()); 
		
		daoImpl.deleteEtudiant(cours1, 5); 
		System.out.println("apres supprimer idE "+ cours1.toString()); 
		
		//burg
		List<Etudiant> etudiantsDeCours = daoImpl.selectEtudiantsDuCours(cours1); 
		
		System.out.println("les etudiants de cours: ");
		for (Iterator<Etudiant> iter=  etudiantsDeCours.iterator(); iter.hasNext(); )
		{
			System.out.println(iter.next().toString()+"|\n");
		}
	}
}
