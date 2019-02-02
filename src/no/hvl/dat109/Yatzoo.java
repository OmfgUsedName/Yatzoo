package no.hvl.dat109;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Yatzoo {

	private static TekstGrensesnitt tekst = new TekstGrensesnitt();
	private static ArrayList<Spiller> spillere = new ArrayList<>();
	private static PoengTabell poeng;
	private static int antallSpillere;

	public static void main(String[] args) {
		oppstartsProsedyre();
		start();
		slutt();
	}
/**
 * Hovudprogrammet, går igjennom "spel" fasen til applikasjonen
 */
	private static void start() {
		TerningKopp kopp = new TerningKopp(5);
		String trillPaaNytt;
		for (int runde = 1; runde <= 12; runde++) {
			tekst.skrivUtRunde(runde);
			for (int spiller = 1; spiller <= antallSpillere; spiller++) {
				ArrayList<Dyr> terningListe = new ArrayList<>();
				tekst.skrivUtSpillerNavn(spillere.get(spiller - 1).getNavn());
				kopp.trillAlleTerninger();
				for (int i = 1; i <= 3; i++) {
					tekst.skrivUtTerninger(kopp.getTerninger());
					if (i != 3) {
						trillPaaNytt = tekst.getTrillPaaNyttTerning();
					} else {
						trillPaaNytt = "";
					}
					for (int a = 1; a <= 5; a++) {
						if (trillPaaNytt.indexOf(Integer.toString(a)) != -1) {
							kopp.trillTerning(a-1);
						}
					}
				}
				poeng.leggTilTerninger(runde, spiller, terningListe.toArray(new Dyr[terningListe.size()]));
			}
		}
	}
/**
 * Kallast på når spellet er over. Kallar på nødvendige metodar for å kalkulere poeng, og
 * finne ein vinnar.
 */
	private static void slutt() {
		poeng.kalkulerPoeng();
		int[] po = poeng.getPoeng();
		LinkedHashMap<Spiller, Integer> spillerPoeng = new LinkedHashMap<>();
		for (int i = 0; i < antallSpillere;i++) {
			spillerPoeng.put(spillere.get(i), po[i]);
		}
		spillerPoeng = spillerPoeng.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		tekst.skrivUtPoengtabell(spillerPoeng);
	}
/**
 * hentar inn tallet spelarar, og namna deira.
 */
	private static void oppstartsProsedyre() {
		do {
			antallSpillere = tekst.getAntallSpillere();
			if (antallSpillere < 2 || antallSpillere > 5) {
				tekst.feilmelding();
			}
		} while (antallSpillere < 2 || antallSpillere > 5);
		poeng = new PoengTabell(antallSpillere);
		for (int i = 1; i <= antallSpillere; i++) {
			spillere.add(new Spiller(tekst.getSpillernavn(i)));
		}
	}

}
