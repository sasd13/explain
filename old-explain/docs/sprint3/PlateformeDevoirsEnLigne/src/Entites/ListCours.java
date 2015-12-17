package Entites;

import java.util.ArrayList;
import java.util.Iterator;

public class ListCours {
	
	private ArrayList<Cours> listCours;
	
	public void setListCours(ArrayList<Cours> list)
	{
		this.listCours = list;
	} 
	
	public ArrayList<Cours> getListCours(){
		return this.listCours;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder().append("{");
		
		if (listCours != null)
			for (Iterator<Cours> iter = listCours.iterator(); iter.hasNext();)
				s.append(iter.next().toString()).append("\n");
		s.append("}");
		
		return s.toString();
	}

}
