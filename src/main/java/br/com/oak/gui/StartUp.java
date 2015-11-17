package br.com.oak.gui;

import javax.swing.UIManager;

public class StartUp {

	public static void main(String[] args) {

		try {

			UIManager.put("DesktopPaneUI",
					"javax.swing.plaf.basic.BasicDesktopPaneUI");
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}

		JRegeditGui.getInstance().showWindow();
	}
}