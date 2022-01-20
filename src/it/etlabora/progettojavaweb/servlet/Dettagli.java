package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.etlabora.progettojavaweb.dto.LibriDto;
import it.etlabora.progettojavaweb.service.LibriService;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.LibriServiceImpl;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class Dettagli extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();
	LibriService libriService = new LibriServiceImpl();

	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	    HttpSession session = req.getSession();
		    Integer id = 1;
			LibriDto dto = libriService.getOne(id);
			req.setAttribute("libro", dto);
			req.getRequestDispatcher("jsp/dettagli.jsp").forward(req, resp);
		}
		
		
	
	}