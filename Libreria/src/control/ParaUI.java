package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Estanteria;
import modelo.Libro;

import utiles.Validaciones;
import vista.UI;

public class ParaUI extends UI {

	private Estanteria libreria = new Estanteria();

	public ParaUI() {

		textFieldISBN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldISBN.setForeground(Color.RED);
				if (Validaciones.validarISBN(textFieldISBN.getText())) {
					textFieldISBN.setForeground(Color.GREEN);
				}
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validaciones.validarISBN(textFieldISBN.getText())
						&& Validaciones.validarLetras(textFieldAutor.getText())
						&& Validaciones.validarLetras(textFieldEditorial.getText())
						&& Validaciones.isNumeroFloat(textFieldPrecio.getText())
						&& getTextBtnSeleccionado(grupoFormato) != null) {
					if (libreria.obtenerLibro(textFieldISBN.getText()) == null) {
						libreria.guardar(new Libro(textFieldISBN.getText(), textFieldTitulo.getText(),
								textFieldAutor.getText(), textFieldEditorial.getText(),
								Integer.valueOf(textFieldCantidad.getText()), Float.valueOf(textFieldPrecio.getText()),
								getTextBtnSeleccionado(grupoFormato), getTextBtnSeleccionado(grupoEstado)));

						rellenarTabla();
						JOptionPane.showMessageDialog(null, "Libro guardado");
						vaciarCampos();
						btnConsultar.setEnabled(true);

					} else {
						JOptionPane.showMessageDialog(null, "ISBN existente");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Campos erroneos");
				}

			}

		});
		tablaLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tablaLibros.getSelectedRowCount() > 0) {
					btnBorrar.setEnabled(true);
					btnAddUnidad.setEnabled(true);
					btnModificar.setEnabled(true);


				} else {
					btnBorrar.setEnabled(false);
					btnAddUnidad.setEnabled(false);
					btnModificar.setEnabled(false);

				}

			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			String[] botonesVentanaBorrar = { "Borrar libro", "Borrar unidades" };

			public void actionPerformed(ActionEvent e) {
				JTextField txtnumeroLibrosModificar = new JTextField();

				int opcion = JOptionPane.showOptionDialog(null, "¿Que quieres borrar?", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesVentanaBorrar, null);

				if (opcion == 0) {
					libreria.borrarLibros(tablaLibros.getSelectedRow());
					JOptionPane.showMessageDialog(null, "Libro borrado");

				} else if (opcion == 1) {

					JOptionPane.showOptionDialog(null, txtnumeroLibrosModificar, "¿Cuantos libros quieres borrar?",
							JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (!txtnumeroLibrosModificar.getText().isEmpty()) {
						libreria.obtenerLibro(libreria.ISBNconcreto(tablaLibros.getSelectedRow()))
								.restarCantidad(Integer.valueOf(txtnumeroLibrosModificar.getText()));
						if (Integer.valueOf(txtnumeroLibrosModificar.getText()) > (libreria
								.obtenerLibro(libreria.ISBNconcreto(tablaLibros.getSelectedRow()))).getCantidad()) {
							JOptionPane.showMessageDialog(null, "borro más unidades de las que hay en stock");
						} else {
							JOptionPane.showMessageDialog(null, " unidades borradas");
						}

					}
				}
				rellenarTabla();

			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String ISBNSel = JOptionPane.showInputDialog("Introduce ISBN");
					if (libreria.obtenerLibro(ISBNSel) == null && !ISBNSel.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No existe");
					}

					JOptionPane.showMessageDialog(null, libreria.obtenerLibro(ISBNSel).toString());

				} catch (Exception e2) {

				}

			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCentro.setSelectedIndex(0);
				mostrarCampos(libreria.obtenerLibro(libreria.ISBNconcreto(tablaLibros.getSelectedRow())));
				textFieldISBN.setEditable(false);
				libreria.borrarLibros(tablaLibros.getSelectedRow());

			}
		});
		btnAddUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField txtnumeroLibrosModificar = new JTextField();
				JOptionPane.showOptionDialog(null, txtnumeroLibrosModificar, "¿Cuantas unidades quieres añadir?",
						JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (!txtnumeroLibrosModificar.getText().isEmpty()) {
					libreria.obtenerLibro(libreria.ISBNconcreto(tablaLibros.getSelectedRow()))
							.sumarCantidad(Integer.valueOf(txtnumeroLibrosModificar.getText()));
					rellenarTabla();
					JOptionPane.showMessageDialog(null, "Unidades añadidas");
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
		String nombresColumnas[] = { "ISBN", "TITULO", "AUTOR", "EDITORIAL", "CANTIDAD", "PRECIO", "FORMATO",
				"ESTADO" };
		String[][] filasTabla = new String[hashMapLibro.size()][nombresColumnas.length];
		for (int i = 0; i < hashMapLibro.size(); i++) {
			Libro libro = libreria.getLibro(i);
			filasTabla[i][0] = libro.getISBN();
			filasTabla[i][1] = libro.getTitulo();
			filasTabla[i][2] = libro.getAutor();
			filasTabla[i][3] = libro.getEditorial();
			filasTabla[i][4] = String.valueOf(libro.getCantidad());
			filasTabla[i][5] = String.valueOf(libro.getPrecio());
			filasTabla[i][6] = libro.getFormato();
			filasTabla[i][7] = libro.getEstado();

		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tablaLibros.setModel(tablaCompleta);
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tablaLibros.getColumnCount(); i++) {
			tablaLibros.getColumnModel().getColumn(i).setCellRenderer(alinear);
		}
	}

	public void mostrarCampos(Libro libro) {
		textFieldISBN.setText(libro.getISBN());
		textFieldPrecio.setText(String.valueOf(libro.getPrecio()));
		textFieldTitulo.setText(libro.getTitulo());
		textFieldEditorial.setText(libro.getEditorial());
		textFieldAutor.setText(libro.getAutor());
		textFieldCantidad.setText(String.valueOf(libro.getCantidad()));
		completeRadioButtonForm(grupoFormato, libro.getFormato());
		completeRadioButtonForm(grupoEstado, libro.getEstado());

	}

	public String getTextBtnSeleccionado(ButtonGroup radiousButtonGroup) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	private void completeRadioButtonForm(ButtonGroup radiousButtonGroup, String nameRadio) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.getText() == nameRadio) {
				button.setSelected(true);
			}
		}
	}

}
