package it.etlabora.progettojavaweb.mapper;

import java.util.ArrayList;
import java.util.List;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.model.Utenti;

public class UtentiMapper {
	
	
	public static UtentiDto toDto(Utenti utente) {
		if(utente == null) {
			return null;
		}
		UtentiDto dto = new UtentiDto();
		dto.setId(utente.getId());
		dto.setNome(utente.getNome());
		dto.setCognome(utente.getCognome());
		dto.setEmail(utente.getEmail());
		dto.setUsername(utente.getUsername());
		dto.setPassword(utente.getPassword());
		dto.setAmministratore(utente.getAmministratore());
		return dto;
	}
	
	public Utenti toModel(UtentiDto dto) {
		if(dto == null) {
			return null;
		}
		Utenti utente = new Utenti();
		utente.setId(dto.getId());
		utente.setNome(dto.getNome());
		utente.setCognome(dto.getCognome());
		utente.setEmail(dto.getEmail());
		utente.setUsername(dto.getUsername());
		utente.setPassword(dto.getPassword());
		utente.setAmministratore(dto.getAmministratore());
		return utente;
	}
	
	public List<UtentiDto> toDto(List<Utenti> utenti) {
		if (utenti == null) {
			return null;
		}
		List<UtentiDto> dtos = new ArrayList<>();
		for (Utenti utente : utenti) {
			dtos.add(toDto(utente));
		}
		return dtos;
	}
	
	public List<Utenti> toModel(List<UtentiDto> dtos) {
		if (dtos == null) {
			return null;
		}
		List<Utenti> utenti = new ArrayList<>();
		for (UtentiDto dto : dtos) {
			utenti.add(toModel(dto));
		}
		return utenti;
	}

}
