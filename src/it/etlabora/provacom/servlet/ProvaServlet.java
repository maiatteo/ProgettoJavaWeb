package it.etlabora.provacom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaServlet extends HttpServlet{

	// commento utilissimo
	// CI SIAMO??ok
	// un altro commento utilissimo
	// POV: ci sei
	// OOOUUUKKKEEEYYYY LETS GO!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("<html><body><h1>HELLO WORLD</h1></body></html>");
	}
}
