package br.com.oak.gui.menu.item;

import javax.swing.JMenuItem;

import br.com.oak.gui.menu.MenuAction;
import br.com.oak.gui.util.Constantes;

public class SobreMenuItem extends JMenuItem{

	private static final long serialVersionUID = -6723923949470684101L;

	public SobreMenuItem(final MenuAction menuAction){
		super();
		setText(Constantes.AJUDA_SOBRE);

		addActionListener(menuAction);
	}
}