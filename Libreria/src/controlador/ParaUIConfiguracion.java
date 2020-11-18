package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.IparaUI;
import modelo.Iview;
import vista.PanelConfiguracion;
import vista.PanelGestionLibreria;
import vista.PanelPapelera;

public class ParaUIConfiguracion implements IparaUI {

	private PanelConfiguracion configuracion;
	private PanelGestionLibreria panelGestion;
	private PanelPapelera panelPapelera;

	public ParaUIConfiguracion(PanelGestionLibreria panelGestion, PanelPapelera panelPapelera) {
		super();
		this.panelGestion = panelGestion;
		this.panelPapelera = panelPapelera;

	}

	@Override
	public void accept(Iview view) {
		configuracion = (PanelConfiguracion) view;

		configuracion.getBtnModoDia().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configuracion.getPanelConfiguracionNorte().setBackground(new Color(124, 252, 0));
				configuracion.getLblTitutloConfiguracion().setForeground(new Color(0, 0, 0));
				configuracion.getPanelConfiguracionCentro().setBackground(new Color(240, 230, 140));
				configuracion.getBtnModoDia().setBackground(new Color(240, 128, 128));
				configuracion.getBtnModoDia().setForeground(new Color(0, 0, 0));
				configuracion.getBtnModoNoche().setBackground(new Color(240, 128, 128));
				configuracion.getBtnModoNoche().setForeground(new Color(0, 0, 0));
			

				panelGestion.getPanelNorte().setBackground(new Color(124, 252, 0));
				panelGestion.getLblLibreriaDeFelix().setForeground(new Color(0, 0, 0));
				panelGestion.getLibro().setBackground(new Color(240, 230, 140));
				panelGestion.getPanelFormato().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnCartone().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnRustica().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnGrapada().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnEspiral().setBackground(new Color(240, 230, 140));

				panelGestion.getPanelEstado().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnReedicion().setBackground(new Color(240, 230, 140));
				panelGestion.getRdbtnNovedad().setBackground(new Color(240, 230, 140));
				
				panelGestion.getPanelTituloFichero().setBackground(new Color(124,252,0));
				panelGestion.getLblTituloFichero().setForeground(new Color(0,0,0));
				panelGestion.getPanelCentroFichero().setBackground(new Color(240,230,140));

				panelGestion.getPanelSur().setBackground(new Color(240, 128, 128));

				panelPapelera.getPanelPapeleraNorte().setBackground(new Color(124, 252, 0));
				panelPapelera.getLblTituloPapelera().setForeground(new Color(0, 0, 0));
				panelPapelera.getPanelPapeleraSur().setBackground(new Color(240, 128, 128));

			}
		});

		configuracion.getBtnModoNoche().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configuracion.getPanelConfiguracionNorte().setBackground(new Color(0, 0, 0));
				configuracion.getLblTitutloConfiguracion().setForeground(new Color(255, 255, 255));
				configuracion.getPanelConfiguracionCentro().setBackground(new Color(159, 159, 146));
				configuracion.getBtnModoDia().setBackground(new Color(0, 0, 0));
				configuracion.getBtnModoDia().setForeground(new Color(255, 255, 255));
				configuracion.getBtnModoNoche().setBackground(new Color(0, 0, 0));
				configuracion.getBtnModoNoche().setForeground(new Color(255, 255, 255));

				panelGestion.getPanelNorte().setBackground(new Color(0, 0, 0));
				panelGestion.getLblLibreriaDeFelix().setForeground(new Color(255, 255, 255));
				panelGestion.getLibro().setBackground(new Color(159, 159, 146));
				panelGestion.getPanelFormato().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnCartone().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnRustica().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnGrapada().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnEspiral().setBackground(new Color(159, 159, 146));

				panelGestion.getPanelEstado().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnReedicion().setBackground(new Color(159, 159, 146));
				panelGestion.getRdbtnNovedad().setBackground(new Color(159, 159, 146));
				
				panelGestion.getPanelTituloFichero().setBackground(new Color(0,0,0));
				panelGestion.getLblTituloFichero().setForeground(new Color(255,255,255));
				panelGestion.getPanelCentroFichero().setBackground(new Color(159, 159, 146));

				panelGestion.getPanelSur().setBackground(new Color(159, 159, 146));

				panelPapelera.getPanelPapeleraNorte().setBackground(new Color(0, 0, 0));
				panelPapelera.getLblTituloPapelera().setForeground(new Color(255, 255, 255));
				panelPapelera.getPanelPapeleraSur().setBackground(new Color(0, 0, 0));

			}
		});
	}

}
