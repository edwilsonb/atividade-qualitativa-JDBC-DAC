package com.atividadequalitativa.fase1doprojeto.main;

import com.atividadequalitativa.fase1doprojeto.dao.EditoraDao;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Criando Tabela Editora.
		
		EditoraDao editoraDao = new EditoraDao();
		editoraDao.criaTabelaEditora();
		System.out.println("Tabela Criada com Sucesso");

	}

}
