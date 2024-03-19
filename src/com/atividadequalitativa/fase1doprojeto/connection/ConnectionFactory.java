package com.atividadequalitativa.fase1doprojeto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Banco_Dac", "postgres", "200485");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
