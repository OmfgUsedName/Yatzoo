package no.hvl.dat109.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.Dyr;
import no.hvl.dat109.PoengTabell;

class PoengTabellTest {

	PoengTabell poeng;
	@Test
	
	void test() {
		/*
		 * tester alle metoder inkludert konstruktøren til klassen.
		 */
		int spillere = 1;
		poeng = new PoengTabell(spillere);
		assertTrue(poeng.getPoeng().length == spillere);
		assertTrue(poeng.getPoeng()[0] == 0);
		
		Dyr[] d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA,Dyr.SLANGE};
		for(int i = 1; i <= 12; i++) {
			poeng.leggTilTerninger(i, 1, d);
		}
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.LOEVE,Dyr.PANDA};
		poeng.leggTilTerninger(11, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 6);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.LOEVE,Dyr.PANDA};
		poeng.leggTilTerninger(7, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 9);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.PANDA};
		poeng.leggTilTerninger(8, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 13);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.GRIS,Dyr.LOEVE,Dyr.LOEVE};
		poeng.leggTilTerninger(9, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 17);
		
		d = new Dyr[] {Dyr.GRIS,Dyr.GRIS,Dyr.GRIS,Dyr.LOEVE,Dyr.LOEVE};
		poeng.leggTilTerninger(10, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 22);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA};
		poeng.leggTilTerninger(11, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 27);
	
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT};
		poeng.leggTilTerninger(12, 1, d);
		poeng.kalkulerPoeng();
		assertTrue(poeng.getPoeng()[0] == 37);
		
		
	}

}
