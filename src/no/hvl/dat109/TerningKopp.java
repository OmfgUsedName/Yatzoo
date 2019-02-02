package no.hvl.dat109;

public class TerningKopp {
	private Dyr[] terninger;
	/**
	 * Opprettar ein kopp som inneheld ei viss mengde terningar
	 * @param i antall terninger i koppen
	 */
	public TerningKopp(int i) {
		terninger = new Dyr[i];
	}

	public Dyr[] getTerninger() {
		return terninger;
	}
	
	/**
	 * Triller ein terning
	 * @param i Indeksen til terningen som skal trillast.
	 */
	public void trillTerning(int i) {
		terninger[i] = Terning.trill();
	}
	
	public void trillAlleTerninger() {
		for(int i = 0; i <terninger.length; i++) {
			trillTerning(i);
		}
	}
	
}
