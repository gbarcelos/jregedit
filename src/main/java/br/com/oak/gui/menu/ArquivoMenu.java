package br.com.oak.gui.menu;

import javax.swing.JMenu;

import br.com.oak.gui.menu.item.CarregarHiveMenuItem;
import br.com.oak.gui.menu.item.ConectarRegistroMenuItem;
import br.com.oak.gui.menu.item.DescarregarHiveMenuItem;
import br.com.oak.gui.menu.item.DesconectarRegistroMenuItem;
import br.com.oak.gui.menu.item.ExportarMenuItem;
import br.com.oak.gui.menu.item.ImportarMenuItem;
import br.com.oak.gui.menu.item.ImprimirMenuItem;
import br.com.oak.gui.menu.item.SairMenuItem;
import br.com.oak.gui.util.Constantes;

public class ArquivoMenu extends JMenu{

	private static final long serialVersionUID = 8016536242852927157L;

	public ArquivoMenu(final MenuAction menuAction) {
		
		super(Constantes.MENU_ARQUIVO);
		add(new ImportarMenuItem(menuAction));
		add(new ExportarMenuItem(menuAction));
		addSeparator();
		add(new CarregarHiveMenuItem(menuAction));
		add(new DescarregarHiveMenuItem(menuAction));
		addSeparator();
		add(new ConectarRegistroMenuItem(menuAction));
		add(new DesconectarRegistroMenuItem(menuAction));
		addSeparator();
		add(new ImprimirMenuItem(menuAction));
		addSeparator();
		add(new SairMenuItem(menuAction));
	}
}