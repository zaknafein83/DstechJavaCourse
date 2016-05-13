/**
 * 
 */
package org.dstech.Lorenzo.Servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequest extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		PrintWriter writer = resp.getWriter();
		if ("giovanni".equalsIgnoreCase(nome)) {
			writer.append("ciao Giovanni");
		} else if ("antonio".equalsIgnoreCase(nome)) {
			writer.append("ciao antonio");
		} else
			writer.append("ma chi sei");

		writer.flush();
		writer.close();
	}
}
