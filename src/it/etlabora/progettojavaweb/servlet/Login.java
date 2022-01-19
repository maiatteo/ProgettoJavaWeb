package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class Login extends HttpServlet{
	
	UtentiService utenteService = new UtentiServiceImpl();

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
		req.setAttribute("username", dto.getUsername());
		req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
	}
}
