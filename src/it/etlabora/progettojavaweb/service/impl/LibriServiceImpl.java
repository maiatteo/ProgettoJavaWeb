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
	public LibriDto getOne(Long id) {
		return null;
	}

	//@Override
	public void delete(Long id) {		
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
				libri.add(libriMapper.toDto(libro));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libri;
	}


}