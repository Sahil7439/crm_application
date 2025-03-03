package genricUtility;

import java.util.Random;

public class JavaUtility {
	public static int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
}
