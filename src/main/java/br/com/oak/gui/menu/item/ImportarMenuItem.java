package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class ImportarMenuItem extends JMenuItem{

	private static final long serialVersionUID = -5152524269381496804L;

	public ImportarMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.IMPORTAR);

		addActionListener(menuAction);
	}
}
