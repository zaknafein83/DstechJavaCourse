/**
 * 
 */
package org.dstech.lulizi.net;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luca
 *
 */
public class EsempioServlet extends HttpServlet{
/* (non-Javadoc)
 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
 */
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	resp.setContentType("text/plain"); //per dire che mandiamo testo

	PrintWriter writer= resp.getWriter();
	writer.println("Hello World");
	super.doGet(req, resp);
}
}
