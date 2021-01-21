import java.lang.reflect.InvocationTargetException;

public class PlayGround {
	// main areas for all Characters
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		CalBros calBros = new CalBros();
		GrandPa grandPa = new GrandPa();
		// Sort by Orchestration
		calBros.shuffle();
		System.out.println("Permutation before sorted");
		calBros.report();
		grandPa.sort(calBros.calBros); // call sort
		System.out.println("Permutation after sort by orchestration");
		calBros.report();
		
		// Sort by Choreography
		calBros.shuffle();
		System.out.println("Permutation before sorted");
		calBros.report();
		calBros.sort(); // call sort
		System.out.println("Permutation after sort by Choreography");
		calBros.report();
	}
}
