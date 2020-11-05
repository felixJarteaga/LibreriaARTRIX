package controlador;

import java.awt.EventQueue;

import vista.MenuVentanas;

public class Principal {
<<<<<<< Updated upstream:Libreria/src/controlador/Principal.java

=======
	
>>>>>>> Stashed changes:Libreria/src/control/Principal.java
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVentanas frame = new MenuVentanas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

}
