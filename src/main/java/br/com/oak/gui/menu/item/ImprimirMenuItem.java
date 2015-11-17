package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class ImprimirMenuItem extends JMenuItem {

	private static final long serialVersionUID = 5661620852222685238L;

	public ImprimirMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.IMPRIMIR_REGISTRO);

		addActionListener(menuAction);
	}
}
