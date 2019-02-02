package no.hvl.dat109;
import java.util.Random;

public class Terning {
	
	static Random rand = new Random();
	/**
	 * @return tilfeldig dyr
	 */
	public static Dyr trill() {
		return Dyr.finnDyr(rand.nextInt(6)+1);
	}
	
}
