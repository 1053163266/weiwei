package org.daijia.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.logindao;
import dao.logindaoimp;
import util.user;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		HashMap<String, Object> map= new HashMap<String, Object>();
		System.out.println("进来了");
		System.out.println(name);
		System.out.println(pwd);
		user u=new user();
		user u1=new user();
		u.setName(name);
		u.setPassword(pwd);
		logindao logindao=new logindaoimp();
		try {
			System.out.println(u.getName());
			u1=logindao.login(u);
			if(u1.getName()!=null) {
			if(u1.getName().equals(u.getName())&&u1.getPassword().equals(u.getPassword())) {
				   response.setContentType("text/json;charset=UTF-8");
			        response.setCharacterEncoding("UTF-8");
			        ObjectMapper obj=new ObjectMapper();
			        map.put("msg", "登陆成功");
			        System.out.println("登陆成功");
			        obj.writeValue(response.getWriter(), map);    
			        //out.println("登陆成功！");			        				      
			}else {
				System.out.println("注册失败");
				request.getRequestDispatcher("loginsucess.html").forward(request, response);
			}
			}else {
				response.setContentType("text/json;charset=UTF-8");
		        response.setCharacterEncoding("UTF-8");
				ObjectMapper obj=new ObjectMapper();
		        map.put("msg", null);
		        obj.writeValue(response.getWriter(), map);  
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
