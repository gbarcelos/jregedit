package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class ConectarRegistroMenuItem extends JMenuItem {

	private static final long serialVersionUID = -1737391462182887462L;

	public ConectarRegistroMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.CONECTAR_REGISTRO);

		addActionListener(menuAction);
	}
}
