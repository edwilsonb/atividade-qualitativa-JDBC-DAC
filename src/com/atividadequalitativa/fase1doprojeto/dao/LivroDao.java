package com.atividadequalitativa.fase1doprojeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atividadequalitativa.fase1doprojeto.connection.ConnectionFactory;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;
import com.atividadequalitativa.fase1doprojeto.entities.Livro;

public class LivroDao {
	
	private Connection connection;
	
	public LivroDao() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void criaTabelaLivro() {
		
		String sql = "create table livros ("
				+ "id serial primary key,"
				+ "nome varchar(100) not null,"
				+ "ano_publicacao varchar(10) not null)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereLivro(Livro livro) {
		
		String sql = "insert into livros (nome, ano_publicacao) values (?,?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAnoPublicacao());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Livro byId(Long id) {
		
		String sql = "select * from livros where id=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Livro livro = new Livro();
			while (rs.next()) {
				livro.setId(id);
				livro.setNome(rs.getString("nome"));
				livro.setAnoPublicacao(rs.getString("ano_publicacao"));
			}
			return livro;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livro> all() {
		
		try {
			List<Livro> livros = new ArrayList<Livro>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from livros");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getLong("id"));
				livro.setNome(rs.getString("nome"));
				livro.setAnoPublicacao(rs.getString("ano_publicacao"));
				
				livros.add(livro);
			}
			rs.close();
			stmt.close();
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void atualizar(Livro livro, long id) {
		
		String sql = "update livros set nome=?, ano_publicacao=? where id=?";
		
		try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, livro.getNome());
				stmt.setString(2, livro.getAnoPublicacao());
				stmt.setLong(3, id);
				stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(long id) {
		
		try {			
				PreparedStatement stmt = this.connection.prepareStatement("delete from livros where id=?");
				stmt.setLong(1, id);
				stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
