package com.cuit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.User;
import com.cuit.impledao.QueryDao;
import com.cuit.service.QueryService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserConfirm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		if (request.getParameter("uid") != "" && request.getParameter("password") != "") {
			int username = Integer.parseInt(request.getParameter("uid"));
			System.out.println("用户："+username);
			QueryService getname = new QueryDao();
			user = getname.FindUserById(username);

			if (user == null) {
				System.out.println("用户不存在！");
				response.sendRedirect("Login.jsp");
				/*RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);*/

			} else if (user.getPassword().equals(request.getParameter("password")) && user.getUid() == username) {
				response.sendRedirect("ShowForUser.jsp");
			}
			else {
				response.sendRedirect("Login.jsp");
				System.out.println("密码没输");
			}
		}
		else {
			response.sendRedirect("Login.jsp");
			System.out.println("用户名或者密码没输");
		}
	}
}
