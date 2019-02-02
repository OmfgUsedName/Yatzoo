package no.hvl.dat109;

public class PoengTabell {

	private int spillere; // Kunne også ha brukt ein array av spillere, men dette gjer programmet enklere.
	private Dyr[][][] dyrTabell;
	private int[] poeng;

	public PoengTabell(int spillere) {
		this.spillere = spillere;
		poeng = new int[spillere];
		dyrTabell = new Dyr[12][spillere][5];
	}

	public void leggTilTerninger(int runde, int spiller, Dyr[] d) {
		dyrTabell[runde - 1][spiller - 1]= d;

	}

	public int[] getPoeng() {
		return poeng;
	}

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
