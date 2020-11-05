package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import modelo.IparaUI;
import modelo.Iview;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConfiguracion extends JPanel implements Iview {
	private JPanel panelConfiguracion;
	protected JButton btnModoNoche;
	protected JButton btnModoDia;
	private JPanel panelConfiguracionNorte;
	private JPanel panelConfiguracionCentro;
	private JLabel lblTitutloConfiguracion;
	private JLabel lblModoDia;
	private JLabel lblModoNoche;
	

	public PanelConfiguracion(IparaUI paraUi) {
		setLayout(new BorderLayout(0, 0));
		
		panelConfiguracion = new JPanel();
		add(panelConfiguracion, BorderLayout.CENTER);
		panelConfiguracion.setLayout(new BorderLayout(0, 0));
		
		panelConfiguracionNorte = new JPanel();
		panelConfiguracion.add(panelConfiguracionNorte, BorderLayout.NORTH);
		panelConfiguracionNorte.setBackground(new Color(124,252,0));
		
		lblTitutloConfiguracion = new JLabel("CONFIGURACION");
		lblTitutloConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 35));
		panelConfiguracionNorte.add(lblTitutloConfiguracion);
		
		panelConfiguracionCentro = new JPanel();
		panelConfiguracion.add(panelConfiguracionCentro, BorderLayout.CENTER);
		panelConfiguracionCentro.setBackground(new Color(240,230,140));
		
		lblModoDia = new JLabel("Modo Dia");
		lblModoDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblModoNoche = new JLabel("Modo Noche");
		lblModoNoche.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnModoDia = new JButton("Activar");
		btnModoDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModoDia.setBackground(new Color(240,128,128));
		
		
		btnModoNoche = new JButton("Activar");
		btnModoNoche.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModoNoche.setBackground(new Color(240,128,128));
		
		
		GroupLayout gl_panelConfiguracionCentro = new GroupLayout(panelConfiguracionCentro);
		gl_panelConfiguracionCentro.setHorizontalGroup(
			gl_panelConfiguracionCentro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConfiguracionCentro.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panelConfiguracionCentro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblModoDia)
						.addComponent(lblModoNoche))
					.addGap(33)
					.addGroup(gl_panelConfiguracionCentro.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModoNoche)
						.addComponent(btnModoDia))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		gl_panelConfiguracionCentro.setVerticalGroup(
			gl_panelConfiguracionCentro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConfiguracionCentro.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panelConfiguracionCentro.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnModoDia)
						.addComponent(lblModoDia))
					.addGap(47)
					.addGroup(gl_panelConfiguracionCentro.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblModoNoche)
						.addComponent(btnModoNoche))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panelConfiguracionCentro.setLayout(gl_panelConfiguracionCentro);
		
		present(paraUi);
		

	}




	public JLabel getLblTitutloConfiguracion() {
		return lblTitutloConfiguracion;
	}




	public JPanel getPanelConfiguracionNorte() {
		return panelConfiguracionNorte;
	}




	public JPanel getPanelConfiguracionCentro() {
		return panelConfiguracionCentro;
	}




	public JPanel getPanelConfiguracion() {
		return panelConfiguracion;
	}




	@Override
	public void present(IparaUI paraUi) {
		paraUi.accept(this);
		
	}
	
	
	public JButton getBtnModoNoche() {
		return btnModoNoche;
	}
	public JButton getBtnModoDia() {
		return btnModoDia;
	}

}
