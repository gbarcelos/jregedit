package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class DesconectarRegistroMenuItem extends JMenuItem {

	private static final long serialVersionUID = 7032611467954666500L;

	public DesconectarRegistroMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.DESCONECTAR_REGISTRO);

		addActionListener(menuAction);
	}
}

