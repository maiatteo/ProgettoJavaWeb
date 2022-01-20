package it.etlabora.progettojavaweb.service;

import java.util.List;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.model.Utenti;

public interface UtentiService {
	
		public UtentiDto create(UtentiDto dto);

		public UtentiDto update(UtentiDto dto);

		public UtentiDto getOne(Integer id);

		public void delete(Integer id);

		public List<UtentiDto> getAll();
		
		public UtentiDto login(String username, String password);
		
		public void registrazione(UtentiDto dto);
		
}
