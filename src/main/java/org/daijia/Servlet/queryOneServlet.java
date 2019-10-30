package org.daijia.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.drivingdao;
import dao.drivingdaoimp;
public class queryOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public queryOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> m=new HashMap<String, Object>();
		String s=request.getParameter("s");
		System.out.println(s);
		drivingdao dr=new drivingdaoimp();
		try {
			m.putAll(dr.queryOnedriving(s));
			System.out.println(m.get("d1"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 response.setContentType("text/json;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
		ObjectMapper ma=new ObjectMapper();
		ma.writeValue(response.getWriter(), m);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
