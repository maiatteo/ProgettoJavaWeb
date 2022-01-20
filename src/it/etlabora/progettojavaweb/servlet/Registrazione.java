package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class Registrazione extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("jsp/registrazione.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtentiDto dto = new UtentiDto();
		dto.setNome(req.getParameter("nome"));
		dto.setCognome(req.getParameter("cognome"));
		dto.setEmail(req.getParameter("email"));
		dto.setUsername(req.getParameter("username"));
		dto.setPassword(req.getParameter("password"));
		
		utenteService.registrazione(dto);
		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);


		
	}

}
