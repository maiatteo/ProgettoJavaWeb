package it.etlabora.progettojavaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.progettojavaweb.dto.UtentiDto;
import it.etlabora.progettojavaweb.service.UtentiService;
import it.etlabora.progettojavaweb.service.impl.UtentiServiceImpl;

public class Login extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter(username);
		String password = req.getParameter(password);
		UtentiDto dto = UtentiServiceImpl.login(username, password);
		req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
	}
}
