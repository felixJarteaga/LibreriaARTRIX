package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
public class UI extends JFrame {

	private JPanel contentPane;
	protected JTextField textFieldISBN;
	protected JTextField textFieldTitulo;
	protected JTextField textFieldAutor;
	protected JTextField textFieldEditorial;
	protected JTextField textFieldPrecio;
	protected JTable tablaLibros;
	protected JButton btnGuardar;
	protected JButton btnBorrar;
	protected JButton btnConsultar;
	protected JButton btnSalir;
	private JRadioButton rdbtnCartone;
	private JRadioButton rdbtnRustica;
	private JRadioButton rdbtnGrapada;
	private JRadioButton rdbtnEspiral;
	private JRadioButton rdbtnReedicion;
	private JRadioButton rdbtnNovedad;
	private ButtonGroup grupoFormato= new ButtonGroup();

	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 534, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Image icon = new ImageIcon(getClass().getResource("/img/logoARTRIX.png")).getImage();
		setIconImage(icon);

		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(new Color(124, 252, 0));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblLibreriaDeFelix = new JLabel("LIBRERIA DE FELIX");
		lblLibreriaDeFelix.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelNorte.add(lblLibreriaDeFelix);

		JTabbedPane panelCentro = new JTabbedPane(JTabbedPane.TOP);
		panelCentro.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(panelCentro, BorderLayout.CENTER);

		JPanel Libro = new JPanel();
		Libro.setBackground(new Color(240, 230, 140));
		panelCentro.addTab("Libro", null, Libro, null);

		JLabel lblISBN = new JLabel("ISBN");

		JLabel lblTitulo = new JLabel("Titulo");

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
		lblImgenLibro.setIcon(new ImageIcon(UI.class.getResource("/img/libro_opt.png")));
		
		JPanel panelFormato = new JPanel();
		panelFormato.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormato.setBackground(new Color(240, 230, 140));
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado.setBackground(new Color(240, 230, 140));
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
							.addComponent(lblEditorial, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Libro.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldPrecio, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldAutor, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldEditorial, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(textFieldTitulo, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addGroup(gl_Libro.createSequentialGroup()
							.addComponent(textFieldISBN, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(10)
					.addComponent(lblImgenLibro)
					.addGap(36))
				.addGroup(gl_Libro.createSequentialGroup()
					.addGroup(gl_Libro.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelEstado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.addComponent(panelFormato, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
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
							.addGap(28)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutor)
								.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_Libro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEditorial)
								.addComponent(textFieldEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
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

		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(240, 128, 128));
		contentPane.add(panelSur, BorderLayout.SOUTH);

		btnGuardar = new JButton("Guardar");

		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnGuardar);

		btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnBorrar);

		btnConsultar = new JButton("Consultar");

		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnConsultar);

		btnSalir = new JButton("Salir");

		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelSur.add(btnSalir);
		
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnEspiral);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnNovedad);
		grupoFormato.add(rdbtnReedicion);
		grupoFormato.add(rdbtnRustica);
		
	}

	public void vaciarCampos() {
		textFieldISBN.setText("");
		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldEditorial.setText("");
		textFieldPrecio.setText("");

	}
}
