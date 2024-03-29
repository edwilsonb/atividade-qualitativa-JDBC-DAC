package com.atividadequalitativa.fase1doprojeto.main;

import java.util.List;

import com.atividadequalitativa.fase1doprojeto.dao.EditoraDao;
import com.atividadequalitativa.fase1doprojeto.dao.LivrariaDao;
import com.atividadequalitativa.fase1doprojeto.dao.LivroDao;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;
import com.atividadequalitativa.fase1doprojeto.entities.Livro;
import com.atividadequalitativa.fase1doprojeto.entities.Livraria;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// Criando Tabela Editora.
		
		EditoraDao editoraDao = new EditoraDao(); // Não comentar essa linha.
		
		/*editoraDao.criaTabelaEditora();
		System.out.println("Tabela Editora Criada Com Sucesso");*/
		
		
		// Insere nova Editora
		
		Editora editora = new Editora(); // Não comentar essa linha.
		
		/*editora.setNomeEditora("Companhia das Letras");
		editora.setAnoFundacao("1986");		
		editoraDao.insereEditora(editora);
		System.out.println("Editora Cadastrada Com Sucesso!");*/
		
		
		//Listar Todas as Editoras.
		
		/*List<Editora> editoras = editoraDao.all();
		
		if (editoras.isEmpty()) {
			System.out.println("Nenhum Editora Cadastrada!");
		} else {
			for (Editora edi: editoras) {
				System.out.println("\nId da editora: " + edi.getIdEditora());
				System.out.println("Nome da editora: " + edi.getNomeEditora());
				System.out.println("Ano da fundaçao: " + edi.getAnoFundacao());
			}
		}*/
		
		
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
		
		/*editora.setNomeEditora("Editora jbc ");
		editora.setAnoFundacao("1995");
		long editoraId = 2L;
		Boolean editoraExiste = editoraDao.byId(editoraId).getIdEditora() != null ? true : false;
		if (editoraExiste) {
			editoraDao.atualizar(editora, editoraId);
			System.out.println("Editora atualizada com sucesso!");
		} else {
			System.out.println("Id inválido, nenhuma editora foi atualizada!");
		}*/
		
		
		//Excluir Editora 
		
		/*long editoraId = 2L;
		Boolean editoraExiste = editoraDao.byId(editoraId).getIdEditora() != null ? true : false;
		if (editoraExiste) {
			editoraDao.excluir(editoraId);
			System.out.println("Editora excluída com sucesso!");
		} else {
			System.out.println("Id inválido, nenhuma editora foi excluída!");
		}*/
		
		
		// Criando tabela livros
		
		LivroDao livroDao = new LivroDao(); // Não comentar essa linha.
		
		/*livroDao.criaTabelaLivro();
		System.out.println("Tabela livros criada com sucesso");*/

		
		// Insere novo livro
				
		Livro livro = new Livro(); // Não comentar essa linha.
		
		/*livro.setNome("O Hobbit");
		livro.setAnoPublicacao("1937");
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
				
		/*long livroId = 2L;
		Boolean livroExiste = livroDao.byId(livroId).getId() != null ? true : false;
		if (livroExiste) {
			livroDao.excluir(livroId);
			System.out.println("Livro excluído com sucesso!");
		} else {
			System.out.println("Id inválido, nenhum livro foi excluído!");
		}*/
		
		
		// Criando tabela livraria, responsável pelo relacionamento entre livro e editora
		
		LivrariaDao livrariaDao = new LivrariaDao(); // Não comentar essa linha
				
		/*livrariaDao.criaTabelaLivraria();
		System.out.println("Tabela livraria criada com sucesso");*/
			
		
		// Inserindo relacionamento na tabela livraria
				
		/*livro = livroDao.byId(1L);
		editora = editoraDao.byId(1L);
		livrariaDao.insereLivraria(livro, editora);
		System.out.println("Relacionamento inserido com sucesso!");*/

		
		// Lista todos os relacionamentos da tabela livraria
		
		/*List<Livraria> relacionamentos = livrariaDao.all();

		if (relacionamentos.isEmpty()) {
			System.out.println("Nenhum relacionamento cadastrado");
		} else {
			for (Livraria r: relacionamentos) {
				System.out.println("\nRelacionamento:");
				System.out.println("Id do livro: " + r.getLivro().getId());
				System.out.println("Id da editora: " + r.getEditora().getIdEditora());
			}
		}*/
	}	
}
