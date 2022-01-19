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
			String sql = "SELECT username, password FROM utenti";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(username == rs.getString("username") && password == rs.getString("password")) {
					Utenti utente = new Utenti();
					utente.setId(rs.getInt("ID"));
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setEmail(rs.getString("email"));
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					utente.setAmministratore(rs.getBoolean("amministratore"));
					UtentiDto dto = UtentiMapper.toDto(utente);		
					return dto;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
