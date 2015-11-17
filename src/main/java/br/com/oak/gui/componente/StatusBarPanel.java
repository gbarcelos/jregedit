package br.com.oak.gui.componente;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.oak.gui.componente.tree.ObservadorTree;

public class StatusBarPanel extends JPanel implements ObservadorTree {

	private static final long serialVersionUID = 1970314605887998709L;

	private JLabel label;

	public StatusBarPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(getWidth(), 20));

		label = new JLabel();
		add(label);		
	}

	@Override
	public void update(final Object obj) {
		if (obj != null){
			label.setText((String) obj);
		}
	}
}