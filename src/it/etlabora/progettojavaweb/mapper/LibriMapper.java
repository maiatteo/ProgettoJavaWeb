package it.etlabora.progettojavaweb.mapper;

import java.util.ArrayList;
import java.util.List;

import it.etlabora.progettojavaweb.dto.LibriDto;
import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.model.Libri;
import it.etlabora.progettojavaweb.model.Utenti;


public class LibriMapper {
	
	public static LibriDto toDto(Libri libro) {
		if(libro == null) {
			return null;
		}
		LibriDto dto = new LibriDto();
		dto.setId(libro.getId());
		dto.setTitolo(libro.getTitolo());
		dto.setCasaeditrice(libro.getCasaeditrice());
		dto.setAutori(libro.getAutori());
		dto.setCategoria(libro.getCategoria());
		dto.setIsbn(libro.getIsbn());
		dto.setNote(libro.getNote());
		dto.setStato(libro.getStato());
		dto.setIdutente(libro.getIdutente());
		return dto;
	}
	
	public Libri toModel(LibriDto dto) {
		if(dto == null) {
			return null;
		}
		Libri libro = new Libri();
		dto.setId(libro.getId());
		dto.setTitolo(libro.getTitolo());
		dto.setCasaeditrice(libro.getCasaeditrice());
		dto.setAutori(libro.getAutori());
		dto.setCategoria(libro.getCategoria());
		dto.setIsbn(libro.getIsbn());
		dto.setNote(libro.getNote());
		dto.setStato(libro.getStato());
		dto.setIdutente(libro.getIdutente());
		return libro;
	}
	
	public List<LibriDto> toDto(List<Libri> libri) {
		if (libri == null) {
			return null;
		}
		List<LibriDto> dtos = new ArrayList<>();
		for (Libri libro : libri) {
			dtos.add(toDto(libro));
		}
		return dtos;
	}
	
	public List<Libri> toModel(List<LibriDto> dtos) {
		if (dtos == null) {
			return null;
		}
		List<Libri> libri = new ArrayList<>();
		for (LibriDto dto : dtos) {
			libri.add(toModel(dto));
		}
		return libri;
	}

}
