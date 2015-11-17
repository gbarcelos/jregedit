package br.com.oak.gui.componente;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.oak.gui.componente.tree.ObservadorTree;

public class DetailKeyPanel extends JPanel implements ObservadorTree{

	private static final long serialVersionUID = 1226774556217358071L;

	private JLabel label;
	public DetailKeyPanel(){
		
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
