package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class CarregarHiveMenuItem extends JMenuItem {

	private static final long serialVersionUID = 2110647410013771324L;

	public CarregarHiveMenuItem(final MenuAction menuAction) {
		super();
		setText(Constantes.CARREGAR_HIVE);

		addActionListener(menuAction);
	}
}
