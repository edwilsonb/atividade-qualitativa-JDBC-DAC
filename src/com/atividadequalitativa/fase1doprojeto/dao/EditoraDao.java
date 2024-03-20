package com.atividadequalitativa.fase1doprojeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atividadequalitativa.fase1doprojeto.connection.ConnectionFactory;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;

public class EditoraDao {
	
	// A conexão com o banco de dados.
	
	private Connection connection;
	
	public EditoraDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void criaTabelaEditora() {
		String sql = "create table editoras ("
				+ "id_editora serial primary key,"
				+ "nome_editora varchar(100) not null,"
				+ "ano_fundacao varchar(10) not null)";
		
		try {
			// Preparando statement para criar tabela.
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);			
		}				
	}	
	
	public void insereEditora(Editora editora) {
		String sql = "insert into editoras (nome_editora, ano_fundacao) values (?,?)";
		
		try {
			
			// Preparando statement para inserção.
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// Seta os valores.
			
			stmt.setString(1, editora.getNomeEditora());
			stmt.setString(2, editora.getAnoFundacao());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Editora byId(Long id) {
		String sql = "select * from Editoras where id_editora=?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Editora editora = new Editora();
			while (rs.next()) {
				
				//criando o objeto Editora  
				
				editora.setIdEditora(id);
				editora.setNomeEditora(rs.getString("nome_editora"));
				editora.setAnoFundacao(rs.getString("ano_fundacao"));
			}
			return editora;				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public List<Editora> all(){
		
			try {
			
				List<Editora> editoras = new ArrayList<Editora>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from editoras");
				ResultSet rs = stmt.executeQuery();
			
				while (rs.next()) {
				
					// Criando o objeto Editora
				
					Editora editora = new Editora();
					editora.setIdEditora(rs.getLong("id_editora"));
					editora.setNomeEditora(rs.getString("nome_editora"));
					editora.setAnoFundacao(rs.getString("ano_fundacao"));
					
					editoras.add(editora);				
				}
				rs.close();
				stmt.close();
				return editoras;
			
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	public void atualizar(Editora editora, long id) {
		String sql = "update editoras set nome_editora=?, ano_fundacao=? where id_editora=?";
		
		try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, editora.getNomeEditora());
				stmt.setString(2, editora.getAnoFundacao());
				stmt.setLong(3, id);
				stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(long id) {
		
		try {			
				PreparedStatement stmt = connection.prepareStatement("delete from editoras where id_editora=?");
				stmt.setLong(1, id);
				stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	}
