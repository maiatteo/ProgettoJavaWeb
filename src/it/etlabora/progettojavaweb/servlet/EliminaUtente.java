package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.etlabora.progettojavaweb.service.LibriService;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.LibriServiceImpl;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class EliminaUtente extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();
	LibriService libriService = new LibriServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	req.getRequestDispatcher("jsp/eliminaUtente.jsp").forward(req, resp);
	}
	
}
