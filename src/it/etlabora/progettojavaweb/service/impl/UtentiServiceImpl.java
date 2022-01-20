package it.etlabora.progettojavaweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.mapper.UtentiMapper;
import it.etlabora.progettojavaweb.model.Utenti;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.util.DbConnection;


public class UtentiServiceImpl implements UtentiService{

	@Override
	public UtentiDto create(UtentiDto dto) {
		return null;
	}

	@Override
	public UtentiDto update(UtentiDto dto) {
		return null;
	}

	@Override
	public UtentiDto getOne(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {		
	}

	@Override
	public List<UtentiDto> getAll() {
		return null;
	}

	public UtentiDto login(String username, String password) {		
		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM utenti";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
					System.out.println("true");
					Utenti utente = new Utenti();
					utente.setId(rs.getInt("ID"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setEmail(rs.getString("email"));
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setAmministratore(rs.getBoolean("amministratore"));
					UtentiDto dto = UtentiMapper.toDto(utente);	
					conn.close();
					return dto;
				}
				System.out.println("False");
			}
			conn.close();
			return null;

		}
		catch (Exception e) {
			System.out.println("exce");
			e.printStackTrace();
		}
		return null;
	}

	public void registrazione(UtentiDto dto) {
		try{
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM utenti";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(dto.getUsername().equals(rs.getString("username")) || dto.getEmail().equals(rs.getString("email"))) {
					System.out.println("True");
					conn.close();
					return;
				}
			}
			System.out.println("False");
			rs.close();
			
			sql = "INSERT INTO utenti \n" +
					"(nome, cognome, email, username, password, amministratore) \n" +
					"VALUES(?, ?, ?, ?, ?, ?) \n";
			statement = conn.prepareStatement(sql);
			statement.setString(1, dto.getNome());
			statement.setString(2, dto.getCognome());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getUsername());
			statement.setString(5, dto.getPassword());
			statement.setBoolean(6, false);
			statement.executeUpdate();
			
			conn.close();
			return;

		}
		catch (Exception e) {
			System.out.println("exce");
			e.printStackTrace();
		}
		return;
	}
}
