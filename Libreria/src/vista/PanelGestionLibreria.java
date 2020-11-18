package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.IparaUI;
import modelo.Iview;
import javax.swing.border.EtchedBorder;

public class PanelGestionLibreria extends JPanel implements Iview {

	private JPanel contentPane;
	protected JTextField textFieldISBN;
	protected JTextField textFieldTitulo;
	protected JTextField textFieldAutor;
	protected JTextField textFieldEditorial;
	protected JTextField textFieldCantidad;
	protected JTextField textFieldPrecio;
	
	public JTable getTableFichero() {
		return tableFichero;
	}

	protected JTable tablaLibros;
	protected JButton btnGuardar;
	

	protected JButton btnBorrar;
	protected JButton btnConsultar;
//	protected JButton btnSalir;
	protected JButton btnAddUnidad;
	protected JButton btnModificar;

	
	protected JRadioButton rdbtnCartone;
	private JRadioButton rdbtnRustica;
	private JRadioButton rdbtnGrapada;
	private JRadioButton rdbtnEspiral;
	private JRadioButton rdbtnReedicion;
	private JRadioButton rdbtnNovedad;
	
	protected ButtonGroup grupoFormato= new ButtonGroup();
	protected ButtonGroup grupoEstado=new  ButtonGroup();
	
	protected JTabbedPane panelCentro;
	protected JComboBox comboBoxTema;
	
	
	private JPanel panelNorte;
	private JPanel Libro;
	private JPanel panelSur;
	private JLabel lblLibreriaDeFelix;
	private JPanel panelEstado;
	private JPanel panelFormato;
	private JPanel panelFichero;
	protected JPanel panelTituloFichero;
	protected JPanel panelCentroFichero;
	protected JLabel lblTituloFichero;
	protected JTable tableFichero;
	
	
	
	public PanelGestionLibreria(IparaUI paraUi) {
		
		setBounds(500, 100, 700, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		

		panelNorte = new JPanel();
		panelNorte.setBackground(new Color(124, 252, 0));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		lblLibreriaDeFelix = new JLabel("LIBRERIA DE FELIX");
		lblLibreriaDeFelix.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelNorte.add(lblLibreriaDeFelix);

		panelCentro = new JTabbedPane(JTabbedPane.TOP);
		panelCentro.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(panelCentro, BorderLayout.CENTER);

		Libro = new JPanel();
		Libro.setBackground(new Color(240, 230, 140));
		panelCentro.addTab("Libro", null, Libro, null);

		JLabel lblISBN = new JLabel("ISBN");

		JLabel lblTitulo = new JLabel("Titulo");
		
		JLabel lblTema = new JLabel("Tema");

		JLabel lblAutor = new JLabel("Autor");

		JLabel lblEditorial = new JLabel("Editorial");

		JLabel lblPrecio = new JLabel("Precio");

		textFieldISBN = new JTextField();
		textFieldISBN.setColumns(10);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);

		textFieldEditorial = new JTextField();
		textFieldEditorial.setColumns(10);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		
		JLabel lblImgenLibro = new JLabel("");
		lblImgenLibro.setIcon(new ImageIcon(PanelGestionLibreria.class.getResource("/img/libro_opt.png")));
		
		panelFormato = new JPanel();
		panelFormato.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormato.setBackground(new Color(240, 230, 140));
		
		panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado.setBackground(new Color(240, 230, 140));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		
		comboBoxTema = new JComboBox();
		comboBoxTema.addItem("");
		comboBoxTema.addItem("Amor");
		comboBoxTema.addItem("Acción");
		comboBoxTema.addItem("Terror");
		comboBoxTema.addItem("Técnico");
		
		
		
		GroupLayout gl_Libro = new GroupLayout(Libro);
		gl_Libro.setHorizontalGroup(
			gl_Libro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblISBN, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblPrecio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAutor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblEditorial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCantidad))
						.addComponent(lblTema))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldCantidad, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(textFieldPrecio, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(textFieldAutor, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(textFieldEditorial, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(textFieldTitulo, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addGroup(gl_Libro.createSequentialGroup()
							.addComponent(textFieldISBN, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addComponent(comboBoxTema, 0, 148, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(lblImgenLibro)
					.addGap(36))
				.addGroup(gl_Libro.createSequentialGroup()
					.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelEstado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelFormato, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_Libro.setVerticalGroup(
			gl_Libro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libro.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Libro.createSequentialGroup()
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblISBN)
								.addComponent(textFieldISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTitulo)
								.addComponent(textFieldTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTema)
								.addComponent(comboBoxTema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutor)
								.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEditorial)
								.addComponent(textFieldEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad)
								.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecio)
								.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblImgenLibro, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblEstado = new JLabel("Estado:");
		
		rdbtnReedicion = new JRadioButton("Reedición");
		rdbtnReedicion.setBackground(new Color(240, 230, 140));
		
		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setBackground(new Color(240, 230, 140));
		
		GroupLayout gl_panelEstado = new GroupLayout(panelEstado);
		gl_panelEstado.setHorizontalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEstado)
					.addGap(18)
					.addComponent(rdbtnReedicion)
					.addGap(18)
					.addComponent(rdbtnNovedad)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		gl_panelEstado.setVerticalGroup(
			gl_panelEstado.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEstado.createSequentialGroup()
					.addGroup(gl_panelEstado.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(rdbtnReedicion)
						.addComponent(rdbtnNovedad))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelEstado.setLayout(gl_panelEstado);
		
		JLabel lblFormato = new JLabel("Formato:");
		
		rdbtnCartone = new JRadioButton("Cartoné");
		rdbtnCartone.setBackground(new Color(240, 230, 140));
		
		rdbtnRustica = new JRadioButton("Rústica");
		rdbtnRustica.setBackground(new Color(240, 230, 140));
		
		rdbtnGrapada = new JRadioButton("Grapada");
		rdbtnGrapada.setBackground(new Color(240, 230, 140));
		
		rdbtnEspiral = new JRadioButton("Espiral");
		rdbtnEspiral.setBackground(new Color(240, 230, 140));
		
		GroupLayout gl_panelFormato = new GroupLayout(panelFormato);
		gl_panelFormato.setHorizontalGroup(
			gl_panelFormato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFormato.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFormato)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnCartone)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnRustica)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnGrapada)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnEspiral)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelFormato.setVerticalGroup(
			gl_panelFormato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFormato.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelFormato.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFormato)
						.addComponent(rdbtnCartone)
						.addComponent(rdbtnRustica)
						.addComponent(rdbtnGrapada)
						.addComponent(rdbtnEspiral))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelFormato.setLayout(gl_panelFormato);
		Libro.setLayout(gl_Libro);

		JPanel Estanteria = new JPanel();
		panelCentro.addTab("Estanteria", null, Estanteria, null);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_Estanteria = new GroupLayout(Estanteria);
		gl_Estanteria.setHorizontalGroup(gl_Estanteria.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE));
		gl_Estanteria.setVerticalGroup(gl_Estanteria.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Estanteria.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tablaLibros = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		scrollPane.setViewportView(tablaLibros);
		Estanteria.setLayout(gl_Estanteria);

		panelSur = new JPanel();
		panelSur.setBackground(new Color(240, 128, 128));
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnGuardar = new JButton("Guardar");

		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnBorrar);
		

		btnConsultar = new JButton("Consultar");
		btnConsultar.setEnabled(false);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnModificar);
		
		btnAddUnidad = new JButton("Añadir Unidad");
		btnAddUnidad.setEnabled(false);
		btnAddUnidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnAddUnidad);

//		btnSalir = new JButton("Salir");
//		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
//		panelSur.add(btnSalir);
		
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnRustica);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnEspiral);
		
		grupoEstado.add(rdbtnReedicion);
		grupoEstado.add(rdbtnNovedad);
		
		panelFichero = new JPanel();
		panelFichero.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(panelFichero, BorderLayout.EAST);
		panelFichero.setLayout(new BorderLayout(0, 0));
		panelFichero.setBackground(new Color(240,230,140));
		
		panelTituloFichero = new JPanel();
		panelFichero.add(panelTituloFichero, BorderLayout.NORTH);
		panelTituloFichero.setBackground(new Color(124,252,0));
		
		lblTituloFichero = new JLabel("ALMACEN");
		lblTituloFichero.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelTituloFichero.add(lblTituloFichero);
		lblTituloFichero.setBackground(new Color(124,252,0));
		
		
		panelCentroFichero = new JPanel();
		panelFichero.add(panelCentroFichero, BorderLayout.CENTER);
		panelCentroFichero.setBackground(new Color(240,230,140));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelCentroFichero = new GroupLayout(panelCentroFichero);
		gl_panelCentroFichero.setHorizontalGroup(
			gl_panelCentroFichero.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCentroFichero.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelCentroFichero.setVerticalGroup(
			gl_panelCentroFichero.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCentroFichero.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableFichero = new JTable() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
		
		scrollPane_1.setViewportView(tableFichero);
		panelCentroFichero.setLayout(gl_panelCentroFichero);
		
		present(paraUi);
		
	}
	
	

	public JPanel getPanelCentroFichero() {
		return panelCentroFichero;
	}



	public JLabel getLblTituloFichero() {
		return lblTituloFichero;
	}

	public JPanel getPanelEstado() {
		return panelEstado;
	}

	public JPanel getPanelFormato() {
		return panelFormato;
	}

	public JLabel getLblLibreriaDeFelix() {
		return lblLibreriaDeFelix;
	}

	public JPanel getPanelSur() {
		return panelSur;
	}

	public JPanel getLibro() {
		return Libro;
	}

	public JPanel getPanelNorte() {
		return panelNorte;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void vaciarCampos() {
		textFieldISBN.setText("");
		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldEditorial.setText("");
		textFieldCantidad.setText("");
		textFieldPrecio.setText("");
		grupoFormato.clearSelection();
		grupoEstado.clearSelection();
		comboBoxTema.setSelectedItem("");

	}

	@Override
	public void present(IparaUI paraUi) {
		paraUi.accept(this);
	}
	public JPanel getPanelTituloFichero() {
		return panelTituloFichero;
	}
	public JTextField getTextFieldISBN() {
		return textFieldISBN;
	}

	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}

	public JTextField getTextFieldAutor() {
		return textFieldAutor;
	}

	public JTextField getTextFieldEditorial() {
		return textFieldEditorial;
	}

	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	public JTable getTablaLibros() {
		return tablaLibros;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

//	public JButton getBtnSalir() {
//		return btnSalir;
//	}

	public JButton getBtnAddUnidad() {
		return btnAddUnidad;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JRadioButton getRdbtnCartone() {
		return rdbtnCartone;
	}

	public JRadioButton getRdbtnRustica() {
		return rdbtnRustica;
	}

	public JRadioButton getRdbtnGrapada() {
		return rdbtnGrapada;
	}

	public JRadioButton getRdbtnEspiral() {
		return rdbtnEspiral;
	}

	public JRadioButton getRdbtnReedicion() {
		return rdbtnReedicion;
	}

	public JRadioButton getRdbtnNovedad() {
		return rdbtnNovedad;
	}

	public ButtonGroup getGrupoFormato() {
		return grupoFormato;
	}

	public ButtonGroup getGrupoEstado() {
		return grupoEstado;
	}

	public JTabbedPane getPanelCentro() {
		return panelCentro;
	}

	public JComboBox getComboBoxTema() {
		return comboBoxTema;
	}
}
