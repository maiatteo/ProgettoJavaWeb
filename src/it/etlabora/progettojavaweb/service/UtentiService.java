package it.etlabora.progettojavaweb.service;

import java.util.List;

public interface UtentiService {
	
		/**
		 * dto.id has to be null (it'll be ignored)
		 */
		public UtentiDto create(UtentiDto dto);

		/**
		 * Id must not be null
		 */
		public UtentiDto update(UtentiDto dto);

		/**
		 * Id must not be null
		 */
		public UtentiDto getOne(Long id);

		/**
		 * Id must not be null
		 */
		public void delete(Long id);

		public List<UtentiDto> getAll();
	}
}
