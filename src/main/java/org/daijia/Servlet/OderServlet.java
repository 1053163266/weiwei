package org.daijia.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.apply;
import dao.applyimp;
import util.applicant;

public class OderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("1name");
		String address=request.getParameter("1address");
		String number=request.getParameter("1number");
		System.out.println(name);
		applicant u=new applicant();
		u.setName(name);
		u.setAddress(address);
		u.setPnumber(number);
		apply a=new applyimp();
		try {
			System.out.println(u.getName());
			int i=a.applys(u);		
			if(i==1) {
				   response.setContentType("text/json;charset=UTF-8");
			        response.setCharacterEncoding("UTF-8");
			        PrintWriter out = response.getWriter();
			        String s="申请成功";
			       ObjectMapper obj= new ObjectMapper();
			       obj.writeValue(out, s);
			}else {
				System.out.println("注册失败");
				request.getRequestDispatcher("loginsucess.html").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
