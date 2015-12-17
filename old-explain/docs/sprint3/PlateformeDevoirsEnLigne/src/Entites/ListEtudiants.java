package Entites;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEtudiants {
	
	private ArrayList<Etudiant> listEtudiants;
	
	public void setListEtudiants(ArrayList<Etudiant> etudiants)
	{
		this.listEtudiants = etudiants;
	}
	
	public ArrayList<Etudiant> getListEtudiants(){
		return this.listEtudiants;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder().append("[");
		
		for (Iterator<Etudiant> iter = listEtudiants.iterator(); iter.hasNext();)
			s.append(iter.next().toString()).append("\n");
		s.append("]");
		
		return s.toString();
	}
	
	
}
