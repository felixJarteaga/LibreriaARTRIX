package utilies;

import java.util.regex.Pattern;



public class Validaciones {
	public static boolean validarLetras(String nombre) {
		return Pattern.matches("[a-zA-Z\\s]+", nombre);
	}
	
	public static boolean validarISBN(String nombre) {
		return Pattern.matches("[0-9]{13}", nombre);
	}
	public static boolean isNumber(String nombre) {
		return Pattern.matches("[0-9]*", nombre);
	}
	public static boolean isNumeroFloat(String nombre) {
		try {
			Float.parseFloat(nombre);
			char charAt=nombre.charAt(nombre.length()-1);
			if (charAt=='f'|| charAt=='d') {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
