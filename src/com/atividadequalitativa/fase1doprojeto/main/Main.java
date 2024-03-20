package com.atividadequalitativa.fase1doprojeto.main;

import java.util.List;

import com.atividadequalitativa.fase1doprojeto.dao.EditoraDao;
import com.atividadequalitativa.fase1doprojeto.dao.LivroDao;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;
import com.atividadequalitativa.fase1doprojeto.entities.Livro;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Criando Tabela Editora.
		
		EditoraDao editoraDao = new EditoraDao(); // Não comentar
		
		/*editoraDao.criaTabelaEditora();
		System.out.println("Tabela Criada Com Sucesso");*/
		
		// Insere nova Editora
		
		Editora editora = new Editora(); // Não comentar
		
		/*editoraDao.insereEditora(editora);
		System.out.println("Editora Cadastrada Com Sucesso!");*/
		
		// Buscar Editora por Id.
		
		/*editora = editoraDao.byId(1L);
		if (editora.getIdEditora() != null) {
			System.out.println("Id Editora: " + editora.getIdEditora());
			System.out.println("Nome Editora: " + editora.getNomeEditora());
			System.out.println("Ano Fundação: " + editora.getAnoFundacao());			
		}
		else {
			System.out.println("Id inválido, editora não encontrada!");
		}*/
		
		//Atualizar Editora.
		
		/*editora.setNomeEditora("panini ");
		editora.setAnoFundacao("1961");
		editoraDao.atualizar(editora,1L);
		System.out.println("Editora Atualizada Com Sucesso!");*/
		
		//Excluir Editora 
		
		/*editoraDao.excluir(3L);
		System.out.println("Editora Excluida Com Sucesso!");*/
		

		// Criando tabela livros
		
		LivroDao livroDao = new LivroDao(); // Não comentar
		
		/*livroDao.criaTabelaLivro();
		System.out.println("Tabela livros criada com sucesso");*/
				
		// Insere novo livro
				
		Livro livro = new Livro(); // Não comentar
		
		/*livro.setNome("Duna");
		livro.setAnoPublicacao("1965");
		livroDao.insereLivro(livro);
		System.out.println("Livro inserido com sucesso");*/
		
		// Busca todos os livros
		
		/*List<Livro> livros = livroDao.all();
		
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado");
		} else {
			for (Livro l: livros) {
				System.out.println("\nId do livro: " + l.getId());
				System.out.println("Nome: " + l.getNome());
				System.out.println("Ano da publicação: " + l.getAnoPublicacao());
			}
		}*/
	
		// Busca livro por Id

		/*long livroId = 2L;
		livro = livroDao.byId(livroId);
		if (livro.getId() != null) {
			System.out.println("Id do livro: " + livro.getId());
			System.out.println("Nome: " + livro.getNome());
			System.out.println("Ano da publicação: " + livro.getAnoPublicacao());
		} else {
			System.out.println("Id inválido, nenhum livro foi encontrado!");
		}*/
		
		// Atualizar livro
		
		/*livro.setNome("Revolução dos bichos");
		livro.setAnoPublicacao("1945");
		long livroId = 1L;
		Boolean livroExiste = livroDao.byId(livroId).getId() != null ? true : false;
		if (livroExiste) {
			livroDao.atualizar(livro, livroId);
			System.out.println("Livro atualizado com sucesso!");
		} else {
			System.out.println("Id inválido, nenhum livro foi atualizado!");
		}*/
				
		// Excluir livro 
				
		/*long livroId = 5L;
		Boolean livroExiste = livroDao.byId(livroId).getId() != null ? true : false;
		if (livroExiste) {
			livroDao.excluir(livroId);
			System.out.println("Livro excluído com sucesso!");
		} else {
			System.out.println("Id inválido, nenhum livro foi excluído!");
		}*/

	}	
}
