package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class AmmUtenti extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UtentiDto> utenti = utenteService.getAll();
		req.setAttribute("utenti", utenti);
		req.getRequestDispatcher("jsp/AmmUtenti.jsp").forward(req, resp);
    	
	}

}
