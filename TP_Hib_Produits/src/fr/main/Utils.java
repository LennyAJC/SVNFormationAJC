package fr.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {

	private static Utils instance = null;
	public Scanner sc;

	public Utils() {

	}

	public static Utils getInstance() {
		if (instance == null) {
			instance = new Utils();
		}
		return instance;
	}

	public int lireInt(String str) {
		afficher(str);
		int lu;
		lu = sc.nextInt();
		sc.nextLine();
		return lu;
	}

	public void afficher(String str) {
		System.out.println(str);
	}

	public String lireString(String str) {
		afficher(str);
		String lu;
		lu = sc.nextLine();
		return lu;
	}

	public Date lireDate(String str) throws ParseException {
		afficher(str);
		String lu = sc.next();
		Date datef = new SimpleDateFormat("dd/MM/yy").parse(lu);
		return datef;
	}

}
