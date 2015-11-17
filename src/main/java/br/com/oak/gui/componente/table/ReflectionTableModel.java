package br.com.oak.gui.componente.table;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ReflectionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 6488146662379822601L;

	private List<?> lista;
	private Class<?> classe;

	public ReflectionTableModel(List<?> lista) {
		this.lista = lista;
		this.classe = lista.get(0).getClass();
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		int colunas = 0;
		for (Method m : classe.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ColumnTableModel.class))
				colunas++;
		}
		return colunas;
	}

	@Override
	public Object getValueAt(int row, int column) {
		try {
			Object objeto = lista.get(row);
			for (Method m : classe.getDeclaredMethods()) {
				ColumnTableModel c = m.getAnnotation(ColumnTableModel.class);
				if (c != null && c.posicao() == column) {
					return m.invoke(objeto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		for (Method m : classe.getDeclaredMethods()) {
			ColumnTableModel c = m.getAnnotation(ColumnTableModel.class);
			if (c != null && c.posicao() == column) {
				return c.name();
			}
		}
		return null;
	}

}