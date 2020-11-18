package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ParaUIConfiguracion;
import controlador.ParaUIGestionLibreria;

public class MenuVentanas extends JFrame  {

	

	private JPanel contentPane;
	
	private PanelPapelera panelPapelera = new PanelPapelera();
	private PanelGestionLibreria panelGestionLibreria= new PanelGestionLibreria(new ParaUIGestionLibreria(panelPapelera));
	private PanelConfiguracion panelConfiguracion = new PanelConfiguracion(new ParaUIConfiguracion(panelGestionLibreria,panelPapelera));
	

	
	
	
	public MenuVentanas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 700, 520);
		
		Image icon = new ImageIcon(getClass().getResource("/img/logoARTRIX.png")).getImage();
		setIconImage(icon);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(124,252,0));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("OPCIONES");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.setBackground(new Color(124,252,0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemGestionLibreria = new JMenuItem("Gestión Libreria");
		mntmNewMenuItemGestionLibreria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cambiarPanel();
		
				((CardLayout) contentPane.getLayout()).show(contentPane, "PanelGestionLibreria");
				
			}

		
		});
		mntmNewMenuItemGestionLibreria.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItemGestionLibreria.setBackground(new Color(240,128,128));
		mnNewMenu.add(mntmNewMenuItemGestionLibreria);
		
		JMenuItem mntmNewMenuItemConfiguracion = new JMenuItem("Configuracion");
		mntmNewMenuItemConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "PanelConfiguracion");
			}
		});
		mntmNewMenuItemConfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItemConfiguracion.setBackground(new Color(240,128,128));
		mnNewMenu.add(mntmNewMenuItemConfiguracion);
		
		JMenuItem mntmNewMenuItemPapelera = new JMenuItem("Papelera de Reciclaje");
		mntmNewMenuItemPapelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, "PanelPapelera");
			}
		});
		mntmNewMenuItemPapelera.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItemPapelera.setBackground(new Color(240,128,128));
		mnNewMenu.add(mntmNewMenuItemPapelera);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		contentPane.add(panelGestionLibreria.getContentPane(), "PanelGestionLibreria");
		contentPane.add(panelConfiguracion.getPanelConfiguracion(),"PanelConfiguracion");
		contentPane.add(panelPapelera.getPanelPapelera(),"PanelPapelera");
		
		panel.setBackground(new Color(240,230,140));
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("LIBRERIA FELIX");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(new Color(240,234,140));
		
		JLabel lblImagenLogo = new JLabel("");
		panel_1.add(lblImagenLogo);
		lblImagenLogo.setIcon(new ImageIcon(MenuVentanas.class.getResource("/img/logoARTRIX_pe.png")));
	
		
		
	}
//	private void cambiarPanel() {
//		((CardLayout) contentPane.getLayout()).show(contentPane, "PanelGestionLibreria");
//	}


}
