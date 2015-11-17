package br.com.oak.gui.componente;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JSplitPane;

import br.com.oak.gui.componente.tree.ObservadorTree;
import br.com.oak.gui.componente.tree.TreeObservavel;
import br.com.oak.gui.componente.tree.TreeRegistry;

public class ExplorerRegistry extends JSplitPane implements TreeObservavel, ObservadorTree{

	private static final long serialVersionUID = 2486363580409865612L;

	private TreeRegistry treeRegistry;

	private DetailKeyPanel detailKey;

	private List<ObservadorTree> observers;

	public ExplorerRegistry(){

		super(JSplitPane.HORIZONTAL_SPLIT, true);

		this.observers = new ArrayList<ObservadorTree>();

		treeRegistry = new TreeRegistry();
		detailKey = new DetailKeyPanel();

		treeRegistry.addObserverTree(this);
		treeRegistry.addObserverTree(detailKey);

		setLeftComponent(treeRegistry);
		setRightComponent(detailKey);
	}
	
	@Override
	public void update(Object obj) {
		if (obj != null){
			String d = (String) obj;
			for (ObservadorTree obs : this.observers) {
				obs.update(d);
			}
		}
	}

	@Override
	public void addObserverTree(ObservadorTree obs) {
		this.observers.add(obs);
	}

	@Override
	public void delObserverTree(ObservadorTree obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyObserversTree() {
	}
}
