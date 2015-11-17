package br.com.oak.gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.com.oak.gui.componente.ExplorerRegistry;
import br.com.oak.gui.componente.StatusBarPanel;
import br.com.oak.gui.menu.JRegeditMenu;
import br.com.oak.gui.util.Constantes;

public class JRegeditGui {

	private static JRegeditGui INSTANCE;

	private JFrame window;

	private ExplorerRegistry explorerRegistry;

	private StatusBarPanel statusBar;

	private JRegeditGui() {
	}

	public static JRegeditGui getInstance() {
		if (JRegeditGui.INSTANCE == null) {
			JRegeditGui.INSTANCE = new JRegeditGui();
		}
		return JRegeditGui.INSTANCE;
	}
	
	public void showWindow() {
		buildWindow();
		window.setJMenuBar(new JRegeditMenu());
		showW();
	}

	private void buildWindow() {
		window = new JFrame(Constantes.NAME_APPLICATION);
		window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.getContentPane().setLayout(new BorderLayout());
		
		explorerRegistry = new ExplorerRegistry();
		statusBar = new StatusBarPanel();
		explorerRegistry.addObserverTree(statusBar);

		window.getContentPane().add(explorerRegistry, BorderLayout.CENTER);
		window.getContentPane().add(statusBar, BorderLayout.SOUTH);
	}

	private void showW() {
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);		
	}
}