package no.hvl.dat109.tests;

import no.hvl.dat109.Dyr;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.TerningKopp;

class TerningKoppTest {

	@Test
	void testtrillAlleTerninger() {
		int antallterninger = 3;
		TerningKopp kopp = new TerningKopp(antallterninger);
		sjekkAlleTerningar(kopp, Dyr.ELEFANT);
		kopp.trillAlleTerninger();
		sjekkAlleTerningar(kopp, null);
	}

	@Test
	void testtrillTerning() {
		int antallterninger = 3;
		TerningKopp kopp = new TerningKopp(antallterninger);
		Dyr d = kopp.getTerninger()[0];
		for (int i = 0; i < 100; i++) {
			kopp.trillTerning(0);
			if(kopp.getTerninger()[0] != d) {
				break;
			}
		}
		assertTrue(d != kopp.getTerninger()[0]);
	}

	void sjekkAlleTerningar(TerningKopp kopp, Dyr statement) {
		for (Dyr d : kopp.getTerninger()) {
			assertTrue(d != statement);
		}
	}

}
