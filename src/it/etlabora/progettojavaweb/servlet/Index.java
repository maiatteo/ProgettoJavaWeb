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

public class Index extends HttpServlet{
	
    
LibriService libriService = new LibriServiceImpl();
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	List<LibriDto> libri = libriService.getAll();
		req.setAttribute("libri", libri);
		req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
	}
}
