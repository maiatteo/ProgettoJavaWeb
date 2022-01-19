package it.etlabora.progettojavaweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import it.etlabora.progettojavaweb.service.LibriService;
import it.etlabora.progettojavaweb.util.DbConnection;
import it.etlabora.progettojavaweb.dto.LibriDto;

public class LibriServiceImpl implements LibriService {
	
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
		return null;
	}
	
	public void printList () {
		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM libri";
			PreparedStatement statement = conn.prepareStatement(sql);
			//da finire
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}