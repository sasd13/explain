package Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Entites.*;

public class AccesDataImpl implements IAccesData
{	
	private ArrayList<FeuilleDevoir> listDevoirs;
	private ArrayList<FeuilleSoumise> listSoumises;
	private ArrayList<Cours> listCours;
	private ArrayList<Etudiant> listEtudiants;
	private ArrayList<User> listUsers;
	
	public AccesDataImpl(){
		listDevoirs = new ArrayList<FeuilleDevoir>();
		listSoumises  = new ArrayList<FeuilleSoumise>();
		listCours = new ArrayList<Cours>();
		listEtudiants = new ArrayList<Etudiant>();
		listUsers = new ArrayList<User>();
	}	
	
	
		//liste des feuilles d'excercices
		public ArrayList<FeuilleDevoir> selectAllDevoirs()
		{
			return listDevoirs;
		}
		
		//liste des feuilles d'excercices d'un prof
		public ArrayList<FeuilleDevoir> selectDevoirsProf(int idProf)
		{
			ArrayList<FeuilleDevoir> devoirs= new ArrayList<FeuilleDevoir>();
			//liste devoirs
			ArrayList<FeuilleDevoir> list = selectAllDevoirs();
			
			if (list != null)			
				for (Iterator<FeuilleDevoir> iter = list.iterator(); 
						iter.hasNext();)
				{
					if (iter.next().getIdProf() == idProf)
						devoirs.add(iter.next());
				}			
			return devoirs;
		}		
		
		
		//liste des devoirs déjà soumises
		public ArrayList<FeuilleSoumise> selectAllFeuillesSoumises()
		{
			return listSoumises;
		}
		
		//liste des devoirs soumises d'un etudiant
		public ArrayList<FeuilleSoumise> selectFeuillesSoumises(int idEtudiant)
		{
			ArrayList<FeuilleSoumise>  listSoumisesEtudiant =
					new ArrayList<FeuilleSoumise>();
			ArrayList<FeuilleSoumise> devoirsSoumises = 
					this.selectAllFeuillesSoumises();
			
			if (devoirsSoumises != null)
				for (Iterator<FeuilleSoumise> iter = 
					devoirsSoumises.iterator(); iter.hasNext();)
				{
					if ( iter.next().getIdEtudiant() == idEtudiant)
						//ajout dans la liste de FeuilleSoumise de l'etudiant
						listSoumisesEtudiant.add(iter.next());
				}
			return listSoumisesEtudiant;
			
		}
		
		//liste de tous les cours
		public ArrayList<Cours> selectAllCours()
		{
			return this.listCours;
		}
		
		//liste des cours d'un professeur
		public ArrayList<Cours> selectCoursProf(int idProf)
		{
			ArrayList<Cours> coursProf = new ArrayList<Cours>();	
			ArrayList<Cours> list = selectAllCours();
			
			if (list != null)			
				for (Iterator<Cours> iter = list.iterator(); iter.hasNext();)
				{
					if (iter.next().getIdProf() == idProf)
						coursProf.add(iter.next());
				}			
			return coursProf;
		}
		
		
		//liste de Cours inscrits par un Etudiant
		public ArrayList<Cours> selectCoursInscrits(int idEtudiant)
		{			
			ArrayList<Cours> listCoursInscrits = new ArrayList<Cours>();
			ArrayList<Cours> listCours = this.selectAllCours();
			
			Etudiant etudiant =getEtudiantById(idEtudiant);
			
			int[] idsCoursDeEtudiant = etudiant.getIdsCours();	
			int nbr = idsCoursDeEtudiant.length;
			
			if( nbr != 0)
			{	
				for (int i= 0; i < nbr; i++)
				{
					if (listCours != null)
						//parcourir list de cours
						for (Iterator<Cours> iter = listCours.iterator(); 
								iter.hasNext();)
							//comparer l'id Cours dans liste de cours et list idsCoursDeEtudiant
							if (iter.next().getIdCour() == idsCoursDeEtudiant[i])
								listCoursInscrits.add(iter.next());					
				}
			}
			return listCoursInscrits;
		}
		
		public ArrayList<Etudiant> selectAllEtudiants()  //ok
		{
			return listEtudiants;
		}
		
		public ArrayList<User> getAllUsers(){
			return listUsers;
		}
	
		//liste des Etudiants inscrits à un cours
		public List<Etudiant> selectEtudiantsDuCours(Cours cours)  //ok
		{			
			int id, nbrIds;
			Integer i, k;
			Etudiant e;
			List<Integer> idsEleves = new ArrayList<Integer>() ;
			List<Etudiant> etudiantsInscritsCours = new ArrayList<Etudiant>();
			
			//liste des etudiants
			List<Etudiant> list = this.selectAllEtudiants();
			
			if (cours != null)			
				idsEleves = cours.getIdsEtudiant();
			
			System.out.println("list ids etudiants not null");
			nbrIds = cours.getIdsEtudiant().size();
			System.out.println("nbr de ids d'etudiant du cours: "+nbrIds);		
			
			if (idsEleves != null && list != null)
			{	
				for (Iterator<Integer> j= idsEleves.iterator(); j.hasNext();)
				{		
					k = j.next();
					//parcourir liste d'etudiants
					for (Iterator<Etudiant> iter = list.iterator(); iter.hasNext(); )
					{   
						e = iter.next();
						id =e.getId();
						i = new Integer(id);
						if (i.equals(k)) 
							etudiantsInscritsCours.add(e);						
					}						
				}
			}
			return etudiantsInscritsCours;
		}
		
				
		//ajouter un cours
		public void insertCoursProf(int idProf, Cours cours) //ok
		{
			//recuperer les cours du prof
			ArrayList<Cours> listCours = selectCoursProf( idProf);
			listCours.add(cours);
		}
		
		 
		//supprimer un Cours
		public ArrayList<Cours> deleteCours(int idCours)
		{
			ArrayList<Cours> listCours = this.selectAllCours();
			
			if (listCours != null)			
				for (Iterator<Cours> iter = listCours.iterator(); iter.hasNext();)
				{
					if (iter.next().getIdProf() == idCours)
						listCours.remove(idCours);
				}
			return listCours;
		}
		
		//ajouter une FeuilleDevoir 
		public void ajoutFeuilleExo(int idProf, FeuilleDevoir feuille)
		{
			//recuperer les FeuilleDevoir du prof 
			ArrayList<FeuilleDevoir> listDevoirs = this.selectDevoirsProf(idProf);
			listDevoirs.add(feuille);			
		}
		

		//chercher un etudiant ayant cet idEtudiant
		public Etudiant getEtudiantById(int idEtudiant) //ok
		{			
			Etudiant etudiant = null;
			List<Etudiant> list = selectAllEtudiants();
			if (list != null)
				for (Iterator<Etudiant> iter = list.iterator(); iter.hasNext();)
					if (iter.next().getId() == idEtudiant)
						etudiant = iter.next();
			if (etudiant == null)
					System.out.println("etudiatnt est null");
			return etudiant;
		}

		//chercher un cours ayant cet idCours
		public Cours getCoursById(int idCours)
		{			
			Cours c = null;
			ArrayList<Cours> list = selectAllCours();
			if (list != null){
				for (Iterator<Cours> iter = list.iterator(); iter.hasNext();)
				{
					if (iter.next().getIdCours() == idCours)
						c =  iter.next();
				}
			}
			if (c == null) 
				System.out.println("cours est null");
			return c;
		}
		
		//ajout ou modif
		public void saveEtudiantAuCours(Cours cours, int idEtudiant)
		{
			boolean trouve = false;
			List<Etudiant> listE = new ArrayList<Etudiant>();
			Integer i = new Integer(idEtudiant);
			if (cours != null) 
				//si exister deja cet id etudiant
				if (cours.getIdsEtudiant().contains(i)){
					//modif: .....									 ----> à faire cette methode
					System.out.println("deja existe cet Id");	
				}
					//ajout:
					//get all etudiants
					listE = this.selectAllEtudiants();
					if (listE != null)
					{	
						for (Iterator<Etudiant> iter = listE.iterator();
								iter.hasNext();)
						{	//verifier cet id appartient à un etudiant?
							if (iter.next().getId() == idEtudiant){
								System.out.println("il existe l'etudiant ayant cet id");
								trouve = true;
							}
						}		
						if (trouve == true)
							cours.getIdsEtudiant().add(new Integer(idEtudiant)); //ok
					}
		}
		
		
		
		public void deleteEtudiant(Cours cours, int idEtudiant)
		{
			Integer i =new Integer(idEtudiant);
			if (cours != null) 				
				//verifier s'il existe cet id dans la list Ids			
				if (cours.getIdsEtudiant().contains(i))
					cours.getIdsEtudiant().remove(i);
				else
					System.out.println("il n'existe pas cet id");
			
		}
		
		public void insertCours(Cours cours)
		{
			if (cours != null)
				this.listCours.add(cours);
		}
		
		public void insertEtudiant(Etudiant e){
			if (e != null)
				this.listEtudiants.add(e);
		}
		
		/*  à faire
		public void creerCours()
		{
			//creer un cours
			//ajoutCoursEnList
		}*/
		
		/*  à faire
		public void creerDevoir()
		{
			//creer une FeuilleDevoir
			//ajoutFeuilleDevoirEnList
		}*/
}
