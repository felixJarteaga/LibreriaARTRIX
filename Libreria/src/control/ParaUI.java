package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Estanteria;
import modelo.Libro;

import utiles.Validaciones;
import vista.UI;

public class ParaUI extends UI {

	private Estanteria libreria = new Estanteria();

	public ParaUI() {

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validaciones.validarISBN(textFieldISBN.getText())
						&& Validaciones.validarLetras(textFieldAutor.getText())
						&& Validaciones.validarLetras(textFieldEditorial.getText())
						&& Validaciones.isNumeroFloat(textFieldPrecio.getText())) {
					if (libreria.obtenerLibro(textFieldISBN.getText()) == null) {
						libreria.guardar(
								new Libro(textFieldISBN.getText(), textFieldTitulo.getText(), textFieldAutor.getText(),
										textFieldEditorial.getText(),Integer.valueOf(textFieldCantidad.getText()), Float.valueOf(textFieldPrecio.getText())));
						rellenarTabla();
						JOptionPane.showMessageDialog(null, "Libro guardado");
						vaciarCampos();
					} else {
						JOptionPane.showMessageDialog(null, "ISBN existente");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Campos erroneos");
				}

			}

		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libreria.borrarLibros(tablaLibros.getSelectedRow());
				rellenarTabla();
				JOptionPane.showMessageDialog(null, "Libro borrado");
			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String ISBNSel = JOptionPane.showInputDialog("Introduce ISBN");
					if (libreria.obtenerLibro(ISBNSel) == null && !ISBNSel.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No existe");
					}

//					mostrarCampos(arrayEstanteria.obtenerLibro(ISBNSel));
					JOptionPane.showMessageDialog(null, libreria.obtenerLibro(ISBNSel).toString());

				} catch (Exception e2) {

				}

			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	public void rellenarTabla() {
		HashMap<String, Libro> hashMapLibro = libreria.getHashMapLibro();
		String nombresColumnas[] = { "ISBN", "TITULO", "AUTOR","CANTIDAD", "PRECIO" };
		String[][] filasTabla = new String[hashMapLibro.size()][nombresColumnas.length];
		for (int i = 0; i < hashMapLibro.size(); i++) {
			Libro libro = libreria.getLibro(i);
			filasTabla[i][0] = libro.getISBN();
			filasTabla[i][1] = libro.getTitulo();
			filasTabla[i][2] = libro.getAutor();
			filasTabla[i][3]=String.valueOf(libro.getCantidad());
			filasTabla[i][4] = String.valueOf(libro.getPrecio());

		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
			tablaLibros.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
	}
}
