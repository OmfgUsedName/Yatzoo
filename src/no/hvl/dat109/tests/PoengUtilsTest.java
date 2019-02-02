package no.hvl.dat109.tests;
import no.hvl.dat109.Dyr;
import no.hvl.dat109.PoengUtils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PoengUtilsTest {

	@Test 
	void testfinnLikeAv() {
		Dyr[] d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA,Dyr.SLANGE};
		for(Dyr a: Dyr.values()) {
			assertTrue(PoengUtils.finnLikeAv(a, d) == 1);
		}
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT};
		assertTrue(PoengUtils.finnLikeAv(Dyr.ELEFANT, d) == 5);
		assertTrue(PoengUtils.finnLikeAv(Dyr.LOEVE, d) == 0);
	}
	
	@Test
	void testfinnMaksAntallLike() {
		Dyr[] d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA,Dyr.SLANGE};
		assertTrue(PoengUtils.finnMaksAntallLike(d) == 1);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT};
		assertTrue(PoengUtils.finnMaksAntallLike(d) == 5);
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.GRIS,Dyr.GRIS,Dyr.PANDA};
		assertTrue(PoengUtils.finnMaksAntallLike(d) == 2);
	}
	
	
	@Test
	void testharToPar() {
		Dyr[] d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA,Dyr.SLANGE};
		assertFalse(PoengUtils.harToPar(d));
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT};
		assertFalse(PoengUtils.harToPar(d));
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.GRIS,Dyr.GRIS,Dyr.PANDA};
		assertTrue(PoengUtils.harToPar(d));
	}
	
	@Test
	void testharHus() {
		Dyr[] d = new Dyr[] {Dyr.ELEFANT,Dyr.GRIS,Dyr.HVAL,Dyr.LOEVE,Dyr.PANDA,Dyr.SLANGE};
		assertFalse(PoengUtils.harHus(d));
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT,Dyr.ELEFANT};
		assertFalse(PoengUtils.harHus(d));
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.GRIS,Dyr.GRIS,Dyr.PANDA};
		assertFalse(PoengUtils.harHus(d));
		
		d = new Dyr[] {Dyr.ELEFANT,Dyr.ELEFANT,Dyr.GRIS,Dyr.GRIS,Dyr.GRIS};
		assertTrue(PoengUtils.harHus(d));
	}

}
