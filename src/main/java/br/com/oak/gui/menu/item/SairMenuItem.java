package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class SairMenuItem extends JMenuItem {

	private static final long serialVersionUID = 7366625804358815554L;

	public SairMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.MENU_SAIR);

		addActionListener(menuAction);
	}
}