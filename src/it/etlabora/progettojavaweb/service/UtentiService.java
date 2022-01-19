package it.etlabora.progettojavaweb.service;

import java.util.List;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.model.Utenti;

public interface UtentiService {
	
		public UtentiDto create(UtentiDto dto);

		public UtentiDto update(UtentiDto dto);

		public UtentiDto getOne(Long id);

		public void delete(Long id);

		public List<UtentiDto> getAll();
		
		public UtentiDto login(String username, String password);
		
}
