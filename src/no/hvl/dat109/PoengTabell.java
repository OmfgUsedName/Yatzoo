package no.hvl.dat109;

public class PoengTabell {

	private int spillere; // Kunne også ha brukt ein array av spillere, men dette gjer programmet enklere.
	private Dyr[][][] dyrTabell;
	private int[] poeng;

	/**
	 * Ein konstruktør som sett opp tabellar basert på tallet spillere.
	 * @param spillere Heiltall mengde spillere
	 */
	public PoengTabell(int spillere) {
		this.spillere = spillere;
		poeng = new int[spillere];
		dyrTabell = new Dyr[12][spillere][5];
	}
/**
 *  Legger til ein tabell med dyr. Viss tabellen er fyllt allereie skriv denne over tidlegare verdi.
 * @param runde Runda i spelet.
 * @param spiller Spillaren indikert med indeksen til tabellen.
 * @param d Ein tabell av dyr du vil legge til.
 */
	public void leggTilTerninger(int runde, int spiller, Dyr[] d) {
		dyrTabell[runde - 1][spiller - 1]= d;

	}
/**
 * 
 * @return Tabell med poenga for kvar spelar
 */
	public int[] getPoeng() {
		return poeng;
	}
/**
 * Kalkulerar poenga basert på tidlegare gitt inn terningar, brukast etter alle 12 rundane er 
 * utført og lagt til i tabellen med metoden {@link no.hvl.dat109.PoengTabell#leggTilTerninger(int, int, Dyr[])}
 */
	public void kalkulerPoeng() {
		for (int i = 0; i < spillere; i++) {
			poeng[i] = 0;
			for (int run = 0; run <= 5; run++) {
				poeng[i] += PoengUtils.finnLikeAv(Dyr.finnDyr(run + 1), dyrTabell[run][i]);
			}
			if (PoengUtils.finnMaksAntallLike(dyrTabell[6][i]) >= 3) {
				poeng[i] += 3;
			}
			if (PoengUtils.finnMaksAntallLike(dyrTabell[7][i]) >= 4) {
				poeng[i] += 4;
			}
			if (PoengUtils.harToPar(dyrTabell[8][i])) {
				poeng[i] += 4;
			}
			if (PoengUtils.harHus(dyrTabell[9][i])) {
				poeng[i] += 5;
			}
			if (PoengUtils.finnMaksAntallLike(dyrTabell[10][i]) == 1) {
				poeng[i] += 5;
			}
			if (PoengUtils.finnMaksAntallLike(dyrTabell[11][i]) == 5) {
				poeng[i] += 10;
			}
		}
	}
}
