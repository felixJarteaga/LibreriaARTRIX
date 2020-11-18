package utilies;

import java.util.regex.Pattern;



import modelo.CuadroDialogos;

public class Validaciones {
	public static boolean validarLetras(String nombre, String nombreCampo) {
		boolean valido = true;
		if (!Pattern.matches("[a-zA-Z\\s]+", nombre)) {
			CuadroDialogos.mostrarErrorCampo(nombreCampo);
			valido = false;
		}
		return valido;
	}

	public static boolean validarISBN(String nombre) {
		return Pattern.matches("[0-9]{13}", nombre);
	}

	public static boolean isNumber(String nombre, String nombreCampo) {
		boolean valido = true;
		if (!Pattern.matches("[0-9]*", nombre)) {
			CuadroDialogos.mostrarErrorCampo(nombreCampo);
			valido = false;
		}
		return valido;
	}

	public static boolean isNumeroFloat(String nombre, String nombreCampo) {
		try {
			Float.parseFloat(nombre);
			char charAt = nombre.charAt(nombre.length() - 1);
			if (charAt == 'f' || charAt == 'd') {
				CuadroDialogos.mostrarErrorCampo(nombreCampo);
				return false;
			}
		} catch (Exception e) {
			CuadroDialogos.mostrarErrorCampo(nombreCampo);
			return false;
		}
		return true;
	}
	

	

}
