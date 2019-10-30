package org.daijia.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.drivingdao;
import dao.drivingdaoimp;
import util.driving;

/**
 * Servlet implementation class querydaijiaServlet
 */
@WebServlet("/queryAllServlet")
public class queryAllServlet extends HttpServlet {
	
    public queryAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HashMap<String, Object> m=new HashMap<String, Object>();
		drivingdao dr=new drivingdaoimp();
		try {
			m.putAll(dr.queryAlldriving());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 response.setContentType("text/json;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
		ObjectMapper ma=new ObjectMapper();
		ma.writeValue(response.getWriter(), m);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
