import controllers.Controller;

public class Main {

	public static void main(String args[]) {
		
		Controller c = new Controller();
		
		double a = 12450900;
		String result = c.formatDouble(a);
		
		System.out.println(result);
	}
}
