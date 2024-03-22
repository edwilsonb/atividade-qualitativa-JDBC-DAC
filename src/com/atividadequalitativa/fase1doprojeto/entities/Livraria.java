package com.atividadequalitativa.fase1doprojeto.entities;

public class Livraria {
	
	private Editora editora = new Editora();
	private Livro livro = new Livro();
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
