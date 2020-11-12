package models;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberFormatter {
	
	private static final double UPPER_BOUND = Math.pow(10, 7);
	private static final double LOWER_BOUND = Math.pow(10, -7);

	public String formatDouble(double number) {
		
		if (number >= UPPER_BOUND || number <= LOWER_BOUND) {
			NumberFormat formatter = new DecimalFormat("0.######E0");
			
			return formatter.format(number).replaceAll(",", ".");
			
		} else {
			
			String formattedNumber = String.format("%,6f", number)
					.replaceAll("[,]", "a");
			
			formattedNumber = formattedNumber
					.replaceAll("[.]", ",")
					.replaceAll("[a]", ".");
			
			return formattedNumber.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
		}
	}
}
