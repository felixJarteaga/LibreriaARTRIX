package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Estanteria;
import modelo.IparaUI;
import modelo.Iview;
import modelo.Libro;
import utilies.Validaciones;
import vista.PanelGestionLibreria;
import vista.PanelPapelera;

public class ParaUIGestionLibreria implements IparaUI {

	private Estanteria libreria = new Estanteria();
	private PanelGestionLibreria gestion;
	private PanelPapelera papelera;

	public ParaUIGestionLibreria(PanelPapelera papelera) {
		super();
		this.papelera = papelera;

	}

	@Override
	public void accept(Iview view) {
		gestion = (PanelGestionLibreria) view;

		gestion.getTextFieldISBN().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				gestion.getTextFieldISBN().setForeground(Color.RED);
				if (Validaciones.validarISBN(gestion.getTextFieldISBN().getText())) {
					gestion.getTextFieldISBN().setForeground(Color.GREEN);
				}
			}
		});

		gestion.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validaciones.validarISBN(gestion.getTextFieldISBN().getText())
						&& Validaciones.validarLetras(gestion.getTextFieldAutor().getText())
						&& Validaciones.validarLetras(gestion.getTextFieldEditorial().getText())
						&& Validaciones.isNumeroFloat(gestion.getTextFieldPrecio().getText())
						&& Validaciones.isNumber(gestion.getTextFieldCantidad().getText())
						&& getTextBtnSeleccionado(gestion.getGrupoFormato()) != null
						&& getTextBtnSeleccionado(gestion.getGrupoEstado()) != null
						&& Float.valueOf(gestion.getTextFieldPrecio().getText()) >= 0
						&& gestion.getComboBoxTema().getSelectedItem() != "") {
					if (libreria.obtenerLibro(gestion.getTextFieldISBN().getText()) == null) {
						libreria.guardar(new Libro(gestion.getTextFieldISBN().getText(),
								gestion.getTextFieldTitulo().getText(), gestion.getTextFieldAutor().getText(),
								gestion.getTextFieldEditorial().getText(),
								Integer.valueOf(gestion.getTextFieldCantidad().getText()),
								Float.valueOf(gestion.getTextFieldPrecio().getText()),
								getTextBtnSeleccionado(gestion.getGrupoFormato()),
								getTextBtnSeleccionado(gestion.getGrupoEstado()),
								String.valueOf(gestion.getComboBoxTema().getSelectedItem())));

						rellenarTabla(gestion.getTablaLibros(), false);
						JOptionPane.showMessageDialog(null, "Libro guardado");
						gestion.vaciarCampos();
						gestion.getBtnConsultar().setEnabled(true);

					} else {
						JOptionPane.showMessageDialog(null, "ISBN existente");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Campos erroneos");
				}
				gestion.getTextFieldISBN().setEnabled(true);

			}

		});
		gestion.getTablaLibros().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (gestion.getTablaLibros().getSelectedRowCount() > 0) {
					gestion.getBtnBorrar().setEnabled(true);
					gestion.getBtnAddUnidad().setEnabled(true);
					gestion.getBtnModificar().setEnabled(true);

				} else {
					gestion.getBtnBorrar().setEnabled(false);
					gestion.getBtnAddUnidad().setEnabled(false);
					gestion.getBtnModificar().setEnabled(false);

				}

			}
		});
		gestion.getBtnBorrar().addActionListener(new ActionListener() {
			String[] botonesVentanaBorrar = { "Borrar libro", "Borrar unidades" };

			public void actionPerformed(ActionEvent e) {
				JTextField txtnumeroLibrosModificar = new JTextField();

				int opcion = JOptionPane.showOptionDialog(null, "¿Que quieres borrar?", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesVentanaBorrar, null);

				if (opcion == 0) {
					libreria.borrarLibros(gestion.getTablaLibros().getSelectedRow());
					JOptionPane.showMessageDialog(null, "Libro borrado");

				} else if (opcion == 1) {

					JOptionPane.showOptionDialog(null, txtnumeroLibrosModificar, "¿Cuantos libros quieres borrar?",
							JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (!txtnumeroLibrosModificar.getText().isEmpty()
							&& Integer.valueOf(txtnumeroLibrosModificar.getText()) >= 0) {
						libreria.obtenerLibro(libreria.ISBNconcreto(gestion.getTablaLibros().getSelectedRow()))
								.restarCantidad(Integer.valueOf(txtnumeroLibrosModificar.getText()));
						if (Integer.valueOf(txtnumeroLibrosModificar.getText()) > (libreria
								.obtenerLibro(libreria.ISBNconcreto(gestion.getTablaLibros().getSelectedRow())))
										.getCantidad()
								&& (libreria
										.obtenerLibro(libreria.ISBNconcreto(gestion.getTablaLibros().getSelectedRow())))
												.getCantidad() < 0) {
							JOptionPane.showMessageDialog(null, "borro más unidades de las que hay en stock");
						} else {
							JOptionPane.showMessageDialog(null, " unidades borradas");
						}

					} else {
						JOptionPane.showMessageDialog(null, "solo se acepta borrar con unidades positivas");

					}
				}
				rellenarTabla(papelera.getTablaPapelera(), true);
				rellenarTabla(gestion.getTablaLibros(), false);

			}
		});
		gestion.getBtnConsultar().addActionListener(new ActionListener() {
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
		gestion.getBtnModificar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.getPanelCentro().setSelectedIndex(0);
				mostrarCampos(libreria.obtenerLibro(libreria.ISBNconcreto(gestion.getTablaLibros().getSelectedRow())));
				gestion.getTextFieldISBN().setEnabled(false);
				libreria.borrarLibros(gestion.getTablaLibros().getSelectedRow());

			}
		});
		gestion.getBtnAddUnidad().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField txtnumeroLibrosModificar = new JTextField();
				JOptionPane.showOptionDialog(null, txtnumeroLibrosModificar, "¿Cuantas unidades quieres añadir?",
						JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if (!txtnumeroLibrosModificar.getText().isEmpty()
						&& Integer.valueOf(txtnumeroLibrosModificar.getText()) > 0) {
					libreria.obtenerLibro(libreria.ISBNconcreto(gestion.getTablaLibros().getSelectedRow()))
							.sumarCantidad(Integer.valueOf(txtnumeroLibrosModificar.getText()));
					rellenarTabla(gestion.getTablaLibros(), false);
					JOptionPane.showMessageDialog(null, "Unidades añadidas");
				} else if (Integer.valueOf(txtnumeroLibrosModificar.getText()) < 0) {
					JOptionPane.showMessageDialog(null, "Solo acepta añadir Unidades Positivas");
				}

			}
		});

		papelera.getBtnRestaurar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				libreria.borrarLibros(papelera.getTablaPapelera().getSelectedRow());

				rellenarTabla(papelera.getTablaPapelera(), true);
				rellenarTabla(gestion.getTablaLibros(), false);

			}
		});

		papelera.getBtnBorrarLibroPapelera().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libreria.borrarLibros(papelera.getTablaPapelera().getSelectedRow());
				JOptionPane.showMessageDialog(null, "Libro borrado");
				rellenarTabla(papelera.getTablaPapelera(), false);

			}
		});

	}

	public void rellenarTabla(JTable tabla, boolean borrado) {

		HashMap<String, Libro> hashMapLibro = libreria.getHashMapLibro();
		String nombresColumnas[] = { "ISBN", "TITULO", "AUTOR", "EDITORIAL", "TEMA", "CANTIDAD", "PRECIO", "FORMATO",
				"ESTADO" };
		int filasRellenas = 0;
		filasRellenas = ajustarTabla(borrado, hashMapLibro, filasRellenas);
		String[][] filasTabla = new String[filasRellenas][nombresColumnas.length];
		int i = 0;

		for (HashMap.Entry<String, Libro> entry : hashMapLibro.entrySet()) {

			if (entry.getValue().isBorrado() == borrado) {

				filasTabla[i][0] = entry.getKey();
				filasTabla[i][1] = entry.getValue().getTitulo();
				filasTabla[i][2] = entry.getValue().getAutor();
				filasTabla[i][3] = entry.getValue().getEditorial();
				filasTabla[i][4] = entry.getValue().getTema();
				filasTabla[i][5] = String.valueOf(entry.getValue().getCantidad());
				filasTabla[i][6] = String.valueOf(entry.getValue().getPrecio());
				filasTabla[i][7] = entry.getValue().getFormato();
				filasTabla[i][8] = entry.getValue().getEstado();
				i++;
			}

		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		tabla.setModel(tablaCompleta);
		DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
		alinear.setHorizontalAlignment(SwingConstants.CENTER);
		for (int j = 0; j < gestion.getTablaLibros().getColumnCount(); j++) {
			gestion.getTablaLibros().getColumnModel().getColumn(j).setCellRenderer(alinear);
		}

	}

	private int ajustarTabla(boolean borrado, HashMap<String, Libro> hashMapLibro, int numerofilasRellenas) {
		for (HashMap.Entry<String, Libro> entry : hashMapLibro.entrySet()) {

			if (entry.getValue().isBorrado() == borrado) {
				numerofilasRellenas++;

			}
		}
		return numerofilasRellenas;
	}

	public void mostrarCampos(Libro libro) {
		gestion.getTextFieldISBN().setText(libro.getISBN());
		gestion.getTextFieldPrecio().setText(String.valueOf(libro.getPrecio()));
		gestion.getTextFieldTitulo().setText(libro.getTitulo());
		gestion.getTextFieldEditorial().setText(libro.getEditorial());
		gestion.getTextFieldAutor().setText(libro.getAutor());
		gestion.getTextFieldCantidad().setText(String.valueOf(libro.getCantidad()));
		gestion.getComboBoxTema().setSelectedItem(String.valueOf(libro.getTema()));
		completeRadioButtonForm(gestion.getGrupoFormato(), libro.getFormato());
		completeRadioButtonForm(gestion.getGrupoEstado(), libro.getEstado());

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
