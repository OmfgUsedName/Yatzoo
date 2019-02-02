package no.hvl.dat109;

import java.util.Arrays;

public class PoengUtils {
	/**
	 * Ein metode for å finne like dyr i ei mengde dyr.
	 * @param d Dyret du vil finne like av
	 * @param dyr Ein tabell med dyr å søke gjennom
	 * @return Heiltallet like dyr
	 */
	public static int finnLikeAv(Dyr d, Dyr[] dyr) {
		return (int) Arrays.stream(dyr).filter(x -> x.equals(d)).count();
	}
	
	/**
	 * Ein metode for å finne maksimalt antall like dyr i ein samling dyr.
	 * @param dyr Ein tabell med dyr å søke gjennom
	 * @return Maksimum tall like dyr i tabellen
	 */
	public static int finnMaksAntallLike(Dyr[] dyr) {
		int maks = 0;
		int i = 0;
		for (Dyr d:Dyr.values()) {
			i = finnLikeAv(d, dyr);
			if (i > maks) {
				maks  = i;
			}
		}
		return maks;
	}
	
	/**
	 * Finner ut om samlinga innheld to par.
	 * @param dyr Ein tabell med dyr å søke gjennom
	 * @return Boolean som indikerar om samlinga innheld to par.
	 */
	public static boolean harToPar(Dyr[] dyr) {
		int i = 0;
		boolean harEitPar = false;
		for (Dyr d:Dyr.values()) {
			i = finnLikeAv(d, dyr);
			if (i > 1) {
				if (harEitPar) {
					return true;
				}
				harEitPar = true;
			}
		}
		return false;
	}
	/**
	 * Går igjennom samlinga og leitar etter ei mengde dyr ein treng for eit hus.
	 * @param dyr Ein tabell med dyr å søke gjennom
	 * @return Boolean som indikerar om samlinga inneheld eit hus
	 */
	public static boolean harHus(Dyr[] dyr) {
		if (finnMaksAntallLike(dyr) == 3) {
			for (Dyr d:Dyr.values()) {
				if (finnLikeAv(d,dyr) == 2) {
					return true;
				}
			}
		}
		return false;
	}
}
