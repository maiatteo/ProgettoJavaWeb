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
import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.service.LibriService;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.LibriServiceImpl;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class Login extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();
	LibriService libriService = new LibriServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UtentiDto dto = utenteService.login(username, password);
		boolean check = false;
		if (dto == null) {
			check = true;
			session.setAttribute("check", Boolean.valueOf(check));
			req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
			return;
		}
		session.setAttribute("username", dto.getUsername());
		session.setAttribute("amministratore", dto.getAmministratore());
		List<LibriDto> libri = libriService.getAll();
		req.setAttribute("libri", libri);
		req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String termine = req.getParameter("termine");
		req.setAttribute("termine", termine);
		System.out.println("gof");
		List<LibriDto> libri = libriService.search(termine);
		req.setAttribute("libri", libri);
		req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
	}
}
