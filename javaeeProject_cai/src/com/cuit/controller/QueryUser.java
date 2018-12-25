package com.cuit.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.entity.User;
import com.cuit.service.QueryService;

/**
 * Servlet implementation class QueryDeviceAll
 */
@WebServlet("/QueryUsersAll")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("sel");
		if(action == "all"){
			List<User> list=new ArrayList<User>();
			QueryService query=null;
			list=query.FindUserAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("showData/showOneDatafromUDao.jsp");
			rd.forward(request, response);
		}
		else if(action == "ming"){
			String name=request.getParameter("name");
			QueryService query=null;
			User user=query.FindUserByName(name);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("show/show1.jsp");
			rd.forward(request, response);
		}
		else if(action == "hao"){
			int id=Integer.parseInt(request.getParameter("id"));
			QueryService query=null;
			Device device=query.FindDeviceById(id);
			request.setAttribute("device", device);
			RequestDispatcher rd = request.getRequestDispatcher("show/show1.jsp");
			rd.forward(request, response);
		}
		else if(action == "fuz"){
			String name=request.getParameter("name");
			QueryService query=null;
			User user=new User();
			query.FindUserByDim(name);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("show/show1.jsp");
			rd.forward(request, response);
		}
	}

}
