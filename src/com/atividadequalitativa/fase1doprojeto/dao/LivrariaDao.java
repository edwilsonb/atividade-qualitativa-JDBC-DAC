package com.atividadequalitativa.fase1doprojeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atividadequalitativa.fase1doprojeto.connection.ConnectionFactory;
import com.atividadequalitativa.fase1doprojeto.entities.Editora;
import com.atividadequalitativa.fase1doprojeto.entities.Livraria;
import com.atividadequalitativa.fase1doprojeto.entities.Livro;

public class LivrariaDao {

	private Connection connection;
	
	public LivrariaDao() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void criaTabelaLivraria() {
		
		String sql = "CREATE TABLE IF NOT EXISTS livraria"
				+ "("
				+ "    id_livro integer NOT NULL,"
				+ "    id_editora integer NOT NULL,"
				+ "    CONSTRAINT livraria_pkey PRIMARY KEY (id_livro, id_editora),"
				+ "    CONSTRAINT livraria_id_editora_fkey FOREIGN KEY (id_editora)"
				+ "        REFERENCES public.editoras (id_editora) MATCH SIMPLE"
				+ "        ON UPDATE CASCADE"
				+ "        ON DELETE CASCADE,"
				+ "    CONSTRAINT livraria_id_livro_fkey FOREIGN KEY (id_livro)"
				+ "        REFERENCES public.livros (id) MATCH SIMPLE"
				+ "        ON UPDATE CASCADE"
				+ "        ON DELETE CASCADE"
				+ ")";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereLivraria(Livro livro, Editora editora) {
		
		String sql = "insert into livraria (id_livro, id_editora) values (?,?)";
		
		if (livro.getId() == null || editora.getIdEditora() == null) {
			System.out.println("Id de livro ou de editora inválido!");
			return;
		}
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, livro.getId());
			stmt.setLong(2, editora.getIdEditora());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Livraria> all() {
		
		try {
			List<Livraria> relacionamentos = new ArrayList<Livraria>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from livraria");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Livraria relacionamento = new Livraria();
				relacionamento.getEditora().setIdEditora(rs.getLong("id_editora"));
				relacionamento.getLivro().setId(rs.getLong("id_livro"));
				
				relacionamentos.add(relacionamento);
			}
			rs.close();
			stmt.close();
			return relacionamentos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
}
