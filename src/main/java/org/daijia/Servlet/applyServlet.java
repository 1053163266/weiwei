package org.daijia.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.registerdao;
import dao.registerdaoimp;
import net.sf.json.JSONObject;
import util.user;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/applyServlet")
public class applyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicant=request.getParameter("applicant");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		




	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
