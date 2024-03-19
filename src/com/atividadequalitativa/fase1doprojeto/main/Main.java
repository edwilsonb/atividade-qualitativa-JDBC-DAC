package com.atividadequalitativa.fase1doprojeto.main;

import com.atividadequalitativa.fase1doprojeto.dao.EditoraDao;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Criando Tabela Editora.
		
		EditoraDao editoraDao = new EditoraDao();
		/*editoraDao.criaTabelaEditora();
		System.out.println("Tabela Criada Com Sucesso");*/
		
		// Insere nova Editora
		
		Editora editora = new Editora();
		
		/*editoraDao.insereEditora(editora);
		System.out.println("Editora Cadastrada Com Sucesso!");*/
		
		// Buscar Editora por Id.
		
		editora = editoraDao.byId(1L);
		
		if (editora.getIdEditora() != null) {
			System.out.println("Id Editora: " + editora.getIdEditora());
			System.out.println("Nome Editora: " + editora.getNomeEditora());
			System.out.println("Ano Fundação: " + editora.getAnoFundacao());			
		}
		else {
			System.out.println("Id inválido, editora não encontrada!");
		}
		
		//Atualizar Editora.
		
		/*editora.setNomeEditora("panini ");
		editora.setAnoFundacao("1961");
		editoraDao.atualizar(editora,1L);
		System.out.println("Editora Atualizada Com Sucesso!");*/
		
		//Excluir Editora 
		
		/*editoraDao.excluir(3L);
		System.out.println("Editora Excluida Com Sucesso!");*/
		
	}	

}
