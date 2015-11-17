package br.com.oak.gui.componente;

import br.com.oak.gui.componente.table.ColumnTableModel;

public class DetailKey {
	
	@ColumnTableModel(name="Nome", posicao=0)
	private String nome;
	
	@ColumnTableModel(name="Tipo", posicao=1)
	private String tipo;
	
	@ColumnTableModel(name="Dados", posicao=2)
	private String valor;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}