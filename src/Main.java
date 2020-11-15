import controllers.Controller;

public class Main {

	public static void main(String args[]) {
		
		Controller c = new Controller();
		
		double a = 204350.43008886;
		String result = c.formatDouble(a);
		
		System.out.println(result);
	}
}
