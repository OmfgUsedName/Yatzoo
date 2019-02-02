package no.hvl.dat109;

import java.util.Map;
import java.util.Scanner;

public class TekstGrensesnitt {
	private Scanner keyboard = new Scanner(System.in);
	
	public void skrivUtRunde(int runde) {
		System.out.println("-------------------------------------------------");
		System.out.println("Runde " + runde + ":");
	}
	public void skrivUtSpillerNavn(String spiller) {
		System.out.println(spiller + "s tur:");
	}
	public String getSpillernavn(int i) {
		System.out.print("Spiller " + i + ": ");
		return keyboard.nextLine();
	}
	public void skrivUtTerninger(Dyr[] dyr) {
		System.out.print("Rullet: ");
		for(int i = 1; i<=dyr.length;i++) {
			System.out.print("("+i+")"+dyr[i-1]);
			if(i != dyr.length) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	public int getAntallSpillere() {
		System.out.println("Tast inn antall spillere(mellom 2 og 5): ");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	public String getTrillPaaNyttTerning() {
		System.out.print("Skriv inn nummeret til alle terningane du vil trille på nytt: ");
		return keyboard.nextLine();
	}
	
	public void skrivUtPoengtabell(Map<Spiller,Integer> map) {
		System.out.println("Vinnaren er den med flest poeng");
		System.out.println("Poengtabell:");
		for(Map.Entry<Spiller,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey().getNavn()+": " + entry.getValue()+" poeng");
		}
	}
	
	public void feilmelding() {
		System.out.println("Ulovlig spiller antall");
	}
}
