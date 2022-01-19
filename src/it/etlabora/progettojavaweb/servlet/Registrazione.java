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
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		utenteService.registrazione(nome, cognome, email, username, password);
		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);


		
	}

}
