package br.com.oak.gui.componente.tree;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import br.com.oak.gui.componente.WinRegistry;

public class TreeRegistry extends JPanel implements TreeObservavel {

	private static final long serialVersionUID = 8670446898311073852L;

	private List<ObservadorTree> observers;

	private String caminhoAtual;

	private Object io_selection = null;

	public TreeRegistry() {

		this.observers = new ArrayList<ObservadorTree>();

		setLayout(new BorderLayout());

		add(new JScrollPane(createTree()), BorderLayout.CENTER);
	}

	private JTree createTree() {
		final DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode(
				"Computador");
		nodoRaiz.add(criarNodosPorChave("HKEY_CURRENT_USER",
				WinRegistry.HKEY_CURRENT_USER));
		nodoRaiz.add(criarNodosPorChave("HKEY_LOCAL_MACHINE", WinRegistry.HKEY_LOCAL_MACHINE));

		final JTree tree = new JTree(nodoRaiz) {

			private static final long serialVersionUID = -3908199960447397036L;

			public Insets getInsets() {
				return new Insets(5, 5, 5, 5);
			}
		};

		final DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(UIManager.getIcon("Tree.closedIcon"));

		tree.setCellRenderer(renderer);
		tree.setEditable(true);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(final TreeSelectionEvent e) {

				// Recebe o caminho do node selecionado.
				final TreePath lo_path = e.getNewLeadSelectionPath();
				setCaminhoAtual(getPathAtual(lo_path));

				// Recebe o "nome" do node selecionado.
				io_selection = io_selection == null ? ((DefaultMutableTreeNode) lo_path
						.getPathComponent(lo_path.getPathCount() - 1))
						.getUserObject() : io_selection;

				// Recebe o nome do atual node selecionado.
				Object lo_atual_selection = ((DefaultMutableTreeNode) lo_path
						.getPathComponent(lo_path.getPathCount() - 1))
						.getUserObject();

				// Se não forem iguais ...
				if (!io_selection.equals(lo_atual_selection)) {

					io_selection = lo_atual_selection;
				}
			}
		});
		return tree;
	}

	private String getPathAtual(final TreePath lo_path) {

		final StringBuilder tempSpot = new StringBuilder();

		for (int counter = 0, maxCounter = lo_path.getPathCount(); counter < maxCounter; counter++) {
			if (counter > 0) {
				tempSpot.append(File.separator);
			}
			tempSpot.append(lo_path.getPathComponent(counter));
		}
		return tempSpot.toString();
	}

	private DefaultMutableTreeNode criarNodosPorChave(final String nomeChave,
			final int hkey) {

		final DefaultMutableTreeNode nodeHkey = new DefaultMutableTreeNode(
				nomeChave);

		final List<String> subKeys = getSubKeys(hkey, "");
		for (final String subKey : subKeys) {
			nodeHkey.add(criarNodos(nodeHkey, hkey, subKey));
		}
		return nodeHkey;
	}

	private MutableTreeNode criarNodos(final DefaultMutableTreeNode nodoPai,
			final int hkey, final String key) {

		final DefaultMutableTreeNode nodoFilho = new DefaultMutableTreeNode(
				extrairNomeChave(key));

		if (nodoPai != null) {
			nodoPai.add(nodoFilho);
		}

		final List<String> subKeys = getSubKeys(hkey, key);
		if (subKeys != null) {
			for (final String subKey : subKeys) {

				if (key != null && !"".equals(key)) {
					nodoFilho.add(criarNodos(nodoFilho, hkey, key
							+ File.separator + subKey));
				} else {
					nodoFilho.add(criarNodos(nodoFilho, hkey, subKey));
				}
			}
		}
		return nodoFilho;
	}

	private static String extrairNomeChave(final String chave) {
		String nomeChave = chave;

		if (chave.lastIndexOf(File.separator) > -1) {
			nomeChave = chave.substring(chave.lastIndexOf(File.separator) + 1);
		}
		return nomeChave;
	}

	private List<String> getSubKeys(final int hkey, final String key) {
		List<String> subKeys = null;
		try {
			subKeys = WinRegistry.readStringSubKeys(hkey, key);
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		return subKeys;
	}

	public String getCaminhoAtual() {
		return caminhoAtual;
	}

	public void setCaminhoAtual(String caminhoAtual) {
		this.caminhoAtual = caminhoAtual;
		notifyObserversTree();
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
		for (ObservadorTree obs : this.observers) {
			obs.update(caminhoAtual);
		}
	}
}