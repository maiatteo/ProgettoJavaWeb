package it.etlabora.progettojavaweb.service;

import java.util.List;

import it.etlabora.progettojavaweb.dto.LibriDto;

public interface LibriService {
	
	public LibriDto create(LibriDto dto);

	public LibriDto update(LibriDto dto);

	public LibriDto getOne(Integer id);

	public void delete(Long id);

	public List<LibriDto> getAll();
	
	public List<LibriDto> search(String termine);
}