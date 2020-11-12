package controllers;

import models.NumberFormatter;

public class Controller {
	public void hello() {
		System.out.println("Hello");
	}

	public String formatDouble(double number) {
		NumberFormatter formatter = new NumberFormatter();
		
		return formatter.formatDouble(number);
	}
}
