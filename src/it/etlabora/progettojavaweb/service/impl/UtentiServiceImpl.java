package it.etlabora.progettojavaweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.etlabora.progettojavaweb.dto.LibriDto;
import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.mapper.UtentiMapper;
import it.etlabora.progettojavaweb.model.Libri;
import it.etlabora.progettojavaweb.model.Utenti;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.util.DbConnection;


public class UtentiServiceImpl implements UtentiService{

	private UtentiMapper utentiMapper = new UtentiMapper();
	
	@Override
	public UtentiDto create(UtentiDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.getId() != null) {
			return this.update(dto);
		}
		UtentiDto savedDto = null;
		try {
			Connection conn = DbConnection.getConnection();
			Utenti entity = utentiMapper.toModel(dto);
			String sql = "INSERT INTO utenti \n" +
					"(nome, cognome, email, username, password, amministratore) \n" +
					"VALUES(?, ?, ?, ?, ?, ?) \n";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getNome());
			statement.setString(2, entity.getCognome());
			statement.setString(3, entity.getEmail());
			statement.setString(4, entity.getUsername());
			statement.setString(5, entity.getPassword());
			statement.setBoolean(6, entity.getAmministratore());
			
			statement.executeUpdate();
			String sql2 = "SELECT MAX(id) FROM utenti";
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			ResultSet rs = statement2.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			conn.close();

			savedDto = this.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedDto;
	}

	@Override
	public UtentiDto update(UtentiDto dto) {
		if (dto == null) {
			return null;
		}
		if (dto.getId() == null) {
			return this.create(dto);
		}
		UtentiDto savedDto = null;
		try {
			Connection conn = DbConnection.getConnection();
			Utenti entity = utentiMapper.toModel(dto);
			String sql = "UPDATE utenti \n"
				+ "SET nome=?, cognome=?, email=?, username=?, password=?, amministratore=?"
				+ "WHERE id=? \n";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getNome());
			statement.setString(2, entity.getCognome());
			statement.setString(3, entity.getEmail());
			statement.setString(4, entity.getUsername());
			statement.setString(5, entity.getPassword());
			statement.setBoolean(6, entity.getAmministratore());

			int updated = statement.executeUpdate();
			if (updated != 1) {
				throw new Exception("Entity has been deleted");
			}

			conn.close();

			savedDto = this.getOne(entity.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedDto;
	}

	public UtentiDto getOne(Integer id) {

		UtentiDto dto = null;

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM nation WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			// "1" is the index 1-based
			// setLong method lets me set the x param as given long
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			rs.next(); //potrebbe dare errore non sono sicuro
			Utenti utente = new Utenti();
			utente.setId(rs.getInt("id"));
			utente.setNome(rs.getString("nome"));
			utente.setCognome(rs.getString("cognnome"));
			utente.setEmail(rs.getString("email"));
			utente.setUsername(rs.getString("username"));
			utente.setPassword(rs.getString("password"));
			utente.setAmministratore(rs.getBoolean("amministratore"));
			dto = utentiMapper.toDto(utente);

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void delete(Integer id) {
		try {
			System.out.println(id);
			Connection conn = DbConnection.getConnection();
			String sql = "DELETE FROM utenti WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UtentiDto> getAll() {
		List<UtentiDto> utenti = new ArrayList<>();

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM utenti";

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			Utenti utente;
			while (rs.next()) {
				System.out.print("E");
				utente = new Utenti();
				utente.setId(rs.getInt("id"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
				utente.setEmail(rs.getString("email"));
				utente.setUsername(rs.getString("username"));
				utente.setAmministratore(rs.getBoolean("amministratore"));
				utenti.add(UtentiMapper.toDto(utente));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utenti;
	}

	public UtentiDto login(String username, String password) {		
		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM utenti WHERE username = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
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
			else{
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
