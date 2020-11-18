package modelo;

import javax.swing.JOptionPane;

public class CuadroDialogos {
	public static void mostrarErrorCampo(String nombreCampo) {
		JOptionPane.showMessageDialog(null, "Fallo en " + nombreCampo);
	}

	public static void errorExistenciaIsbn() {
		JOptionPane.showMessageDialog(null, "El ISBN no existe");
	}
}
