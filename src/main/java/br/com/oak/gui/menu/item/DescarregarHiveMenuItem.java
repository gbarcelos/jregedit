package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class DescarregarHiveMenuItem extends JMenuItem {

	private static final long serialVersionUID = 9217890108655566835L;

	public DescarregarHiveMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.DESCARREGAR_HIVE);

		addActionListener(menuAction);
	}
}
