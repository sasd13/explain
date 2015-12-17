package TestEntities;

import java.util.Date;

import Entites.Etudiant;
import Entites.Professeur;
import Entites.User;

public class TestMain {
	public static void main(String[] args){
		System.out.println("***********************");
		User user=new Etudiant(1, "Anthony","inconnu :D",
				new Date("11/04/2014"),"lethanh11_4@hotmail.com");
		System.out.println(user.toString());
		Professeur pro = new Professeur(2, "le","thanh",
				new Date("11/04/2014"),"lethanh11_4@hotmail.com");
		System.out.println(pro.toString());
		//System.out.println(pro.getAutorisation());
	}
}
