package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class ExportarMenuItem extends JMenuItem{

	private static final long serialVersionUID = -6954326931219129620L;

	public ExportarMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.EXPORTAR);

		addActionListener(menuAction);
	}
}
