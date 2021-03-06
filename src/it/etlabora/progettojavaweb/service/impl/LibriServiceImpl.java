package it.etlabora.progettojavaweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.etlabora.progettojavaweb.service.LibriService;
import it.etlabora.progettojavaweb.util.DbConnection;
import it.etlabora.progettojavaweb.dto.LibriDto;
import it.etlabora.progettojavaweb.mapper.LibriMapper;
import it.etlabora.progettojavaweb.model.Libri;

public class LibriServiceImpl implements LibriService {

	private LibriMapper libriMapper = new LibriMapper();

	//@Override
	public LibriDto create(LibriDto dto) {
		return null;
	}

	//@Override
	public LibriDto update(LibriDto dto) {
		return null;
	}

	//@Override
	public LibriDto getOne(Integer id) {
		if (id == null) {
			return null;
		}
		LibriDto dto = null;

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM libri WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			// "1" is the index 1-based
			// setLong method lets me set the x param as given long
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			// while (rs.next()) {
			rs.next();
			Libri libro = new Libri();
			libro.setId(rs.getInt("id"));
			libro.setTitolo(rs.getString("titolo"));
			libro.setCasaeditrice(rs.getString("casaeditrice"));
			libro.setAutori(rs.getString("autori"));
			libro.setCategoria(rs.getString("categoria"));
			libro.setIsbn(rs.getString("isbn"));
			libro.setNote(rs.getString("note"));
			libro.setStato(rs.getString("stato"));
			dto = libriMapper.toDto(libro);
			// }

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	//@Override
	public void delete(Integer id) {
	}

	//@Override
	public List<LibriDto> getAll() {
		List<LibriDto> libri = new ArrayList<>();

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM libri";

			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			Libri libro;
			while (rs.next()) {
				libro = new Libri();
				libro.setId(rs.getInt("id"));
				libro.setTitolo(rs.getString("titolo"));
				libro.setStato(rs.getString("stato"));
				libri.add(libriMapper.toDto(libro));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libri;
	}

	public List<LibriDto> search(String termine){
		List<LibriDto> libri = new ArrayList<>();

		try {
			System.out.println("Ci provo");
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM libri WHERE titolo LIKE ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, termine + "%");
			ResultSet rs = statement.executeQuery();

			Libri libro;
			while (rs.next()) {
				System.out.println("trovato uno");
				libro = new Libri();
				libro.setId(rs.getInt("id"));
				libro.setTitolo(rs.getString("titolo"));
				libro.setStato(rs.getString("stato"));
				libri.add(libriMapper.toDto(libro));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libri;
	}

	public void prenota(Integer idUtente, Integer idLibro) {
		try {
			System.out.println(idUtente + " " + idLibro);
			Connection conn = DbConnection.getConnection();
			String sql = "UPDATE libri SET stato = 'prenotato', idutente = ? WHERE ID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idUtente);
			statement.setInt(2, idLibro);
			System.out.println(statement);
			statement.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}