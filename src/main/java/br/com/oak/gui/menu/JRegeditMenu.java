package br.com.oak.gui.menu;

import javax.swing.JMenuBar;

public class JRegeditMenu extends JMenuBar{

	private static final long serialVersionUID = -8613197084256681948L;

	private MenuAction menuAction;
	
	public JRegeditMenu(){
		super();
		add(new ArquivoMenu(getJRegeditMenuAction()));
		// Editar
		// Exibir
		//
		add(new AjudaMenu(getJRegeditMenuAction()));
	}

	private MenuAction getJRegeditMenuAction() {
		if (menuAction == null) {
			menuAction = new MenuAction();
		}
		return menuAction;
	}
}
