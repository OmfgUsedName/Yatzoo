package no.hvl.dat109.tests;
import no.hvl.dat109.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class TerningTest {

	@Test
	void testtrill() {
		
		int threshold = 1000000; //Mengden itterasjonar som k�yrast for � bli relvativ sikker
		// p� at metoden fungerer som den skal
		
		LinkedList<Dyr> liste = new LinkedList<>();
		for(Dyr dyr:Dyr.values()) {
			liste.add(dyr);
		}
		assertTrue(liste.size() != 0);
		for(int i = 0; i<=threshold;i++ ) {
			liste.remove(Terning.trill());
			if(liste.size() == 0) {
				break;
			}
		}
		assertTrue(liste.size() == 0);
	}

}
