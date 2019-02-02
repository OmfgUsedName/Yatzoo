package no.hvl.dat109;

import java.util.Arrays;

public class PoengUtils {
	
	public static int finnLikeAv(Dyr d, Dyr[] dyr) {
		return (int) Arrays.stream(dyr).filter(x -> x.equals(d)).count();
	}
	
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
