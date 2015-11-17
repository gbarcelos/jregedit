package br.com.oak.gui.componente.tree;

public interface TreeObservavel {
	void addObserverTree(ObservadorTree obs);
	void delObserverTree(ObservadorTree obs);
	void notifyObserversTree();
}