package com.atividadequalitativa.fase1doprojeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atividadequalitativa.fase1doprojeto.connection.ConnectionFactory;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;

public class EditoraDao {
	
	// a conexão com o banco de dados.
	
	private Connection connection;
	
	public EditoraDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void criaTabelaEditora() {
		String sql = "create table editoras ("
				+ "id_editora serial primary key,"
				+ "nome_editora varchar(100) not null,"
				+ "ano_fundacao varchar(10) not null_)";
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
		String sql = "insert into editoras (id_editora, nome_editora, ano_fundacao) values (?,?,?)";
		try {
			
			// Preparando statement para inserção.
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// Seta os valores.
			
			stmt.setLong(1, editora.getIdEditora());
			stmt.setString(2, editora.getNomeEditora());
			stmt.setString(3, editora.getAnoFundacao());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Editora byId(Long id) {
		String sql = "select * from Editoras where id=?";
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
	
//	public Editora buscarEditoraComLivros(long id) {
//		String sql = "select edi.id_editora, nome_editora, ano_publicacao \n"
//				+ "FROM editoras edi\n"
//				+ "INNER JOIN livros d on edi.id_livros = d.id\n"
//				+ "WHERE edi.id=?";
//		try {
//			
//			PreparedStatement  stmt = this.connection.prepareStatement(sql);
//			stmt.setLong(1, id);
//			ResultSet rs = stmt.executeQuery();
//			Editora editora = new Editora();
//			while (rs.next()) {
//				//criando a editora
//				
//				editora.setIdEditora(rs.getString("id_editora"));
//				editora.set
//				
//			}			
//			
//		}
//			
//		} catch (SQLExecption e) {
//			throw new RuntimeException(e);
//			
//		}
	
}
