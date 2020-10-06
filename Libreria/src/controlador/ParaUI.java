package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Estanteria;
import modelo.Libro;
import utilies.Validaciones;
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
					if (libreria.obtenerLibro(textFieldISBN.getText())==null) {
						libreria.guardar(new Libro(textFieldISBN.getText(), textFieldTitulo.getText(), textFieldAutor.getText(),
								textFieldEditorial.getText(), Float.valueOf(textFieldPrecio.getText())));
						rellenarTabla();
						JOptionPane.showMessageDialog(null, "Libro guardado");
						vaciarCampos();
					}else {
						JOptionPane.showMessageDialog(null, "ISBN existente");
					}


				}else {
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

//	private void mostrarCampos(Libro libro) {
//		textFieldISBN.setText(libro.getISBN());
//		textFieldTitulo.setText(libro.getTitulo());
//		textFieldAutor.setText(libro.getAutor());
//		textFieldEditorial.setText(libro.getEditorial());
//		textFieldPrecio.setText(String.valueOf(libro.getPrecio()));
//	}
//	
	public void rellenarTabla() {
		ArrayList<Libro> arrayLibro = libreria.getArrayLibro();
		String nombreColumnas[] = { "ISBN", "Titulo", "Editorial", "Autor", "Precio" };
		String[][] filasTabla = new String[arrayLibro.size()][nombreColumnas.length];
		for (int i = 0; i < arrayLibro.size(); i++) {
			filasTabla[i][0] = arrayLibro.get(i).getISBN();
			filasTabla[i][1] = arrayLibro.get(i).getTitulo();
			filasTabla[i][2] = arrayLibro.get(i).getAutor();
			filasTabla[i][3] = arrayLibro.get(i).getEditorial();
			filasTabla[i][4] = String.valueOf(arrayLibro.get(i).getPrecio());
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombreColumnas);
		tablaLibros.setModel(tablaCompleta);
		DefaultTableCellRenderer alinear= new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
			tablaLibros.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
	}
}
