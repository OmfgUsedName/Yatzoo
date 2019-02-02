package no.hvl.dat109;

public enum Dyr {
	LOEVE(1), SLANGE(2), PANDA(3), GRIS(4), ELEFANT(5), HVAL(6);
	private int nr;

	private Dyr(int n) { // Konstrukt�r
		this.nr = n; //         Ikke ordinaltallet
	}

	public int getNr() {
		return nr;
	}

	public static Dyr finnDyr(int n) {
		Dyr dyr = null;
		for (Dyr dy : Dyr.values()) {
			if (dy.nr == n) {
				dyr = dy;
				break;
			}
		}
		return dyr;
	}// metode

	public static Dyr finnDyr(String navn) {
		Dyr dyr = null;
		for (Dyr dy : Dyr.values()) {
			if (dy.toString().equals(navn.toUpperCase())) {
				dyr = dy;
				break;
			}
		}
		return dyr;
	}// metode

}// class