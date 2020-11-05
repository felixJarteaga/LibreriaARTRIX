package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPapelera extends JPanel {
	private JPanel panelPapelera;
	private JTable tablaPapelera;
	private JButton btnRestaurar;
	private JButton btnBorrarLibroPapelera;
	private JPanel panelPapeleraNorte;
	private JPanel panelPapeleraSur;
	private JLabel lblTituloPapelera;

	public PanelPapelera() {
		setLayout(new BorderLayout(0, 0));

		panelPapelera = new JPanel();
		add(panelPapelera, BorderLayout.CENTER);
		panelPapelera.setLayout(new BorderLayout(0, 0));

		panelPapeleraNorte = new JPanel();
		panelPapelera.add(panelPapeleraNorte, BorderLayout.NORTH);

		lblTituloPapelera = new JLabel("PAPELERA LIBRO");
		lblTituloPapelera.setFont(new Font("Segoe UI", Font.BOLD, 35));
		panelPapeleraNorte.add(lblTituloPapelera);
		panelPapeleraNorte.setBackground(new Color(124, 252, 0));

		JPanel panelPapeleraCentro = new JPanel();
		panelPapelera.add(panelPapeleraCentro, BorderLayout.CENTER);
		panelPapeleraCentro.setBackground(new Color(240, 230, 140));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelPapeleraCentro = new GroupLayout(panelPapeleraCentro);
		gl_panelPapeleraCentro.setHorizontalGroup(
			gl_panelPapeleraCentro.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		gl_panelPapeleraCentro.setVerticalGroup(
			gl_panelPapeleraCentro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPapeleraCentro.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(2))
		);
		
		tablaPapelera = new JTable();
		scrollPane.setViewportView(tablaPapelera);
		panelPapeleraCentro.setLayout(gl_panelPapeleraCentro);

		panelPapeleraSur = new JPanel();
		panelPapelera.add(panelPapeleraSur, BorderLayout.SOUTH);
		panelPapeleraSur.setBackground(new Color(240, 128, 128));

		btnRestaurar = new JButton("Restaurar Libro");
		btnRestaurar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelPapeleraSur.add(btnRestaurar);

		btnBorrarLibroPapelera = new JButton("Borrar libro");
		btnBorrarLibroPapelera.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelPapeleraSur.add(btnBorrarLibroPapelera);

	}

	public JPanel getPanelPapeleraNorte() {
		return panelPapeleraNorte;
	}

	public JPanel getPanelPapeleraSur() {
		return panelPapeleraSur;
	}

	public JLabel getLblTituloPapelera() {
		return lblTituloPapelera;
	}

	public JButton getBtnRestaurar() {
		return btnRestaurar;
	}

	public JButton getBtnBorrarLibroPapelera() {
		return btnBorrarLibroPapelera;
	}

	public JTable getTablaPapelera() {
		return tablaPapelera;
	}

	public JPanel getPanelPapelera() {
		return panelPapelera;
	}

}
