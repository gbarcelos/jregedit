package br.com.oak.gui.menu;

import javax.swing.JMenu;

import br.com.oak.gui.menu.item.SobreMenuItem;
import br.com.oak.gui.util.Constantes;

public class AjudaMenu extends JMenu{

	private static final long serialVersionUID = 5247254305056685069L;

	public AjudaMenu(final MenuAction menuAction){
		
		super(Constantes.MENU_AJUDA);

		add(new SobreMenuItem(menuAction));
	}

}