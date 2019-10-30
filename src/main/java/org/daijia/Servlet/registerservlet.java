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
@WebServlet("/registerServlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		user u=new user();
		u.setName(name);
		u.setPassword(pwd);
		registerdao registerdao=new registerdaoimp();
		try {
			System.out.println(u.getName());
			int i=registerdao.register(u);			
			if(i==1) {
				   response.setContentType("text/json;charset=UTF-8");
			        response.setCharacterEncoding("UTF-8");
			        System.out.println("61");
			        System.out.println("mz");
			        PrintWriter out = response.getWriter();
			        out.println("注册成功");
			        out.flush();
			        out.close();
			        System.out.println("mz1");
//				response.sendRedirect("loginsucess.html");
			}else {
				System.out.println("注册失败");
				request.getRequestDispatcher("loginsucess.html").forward(request, response);
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
