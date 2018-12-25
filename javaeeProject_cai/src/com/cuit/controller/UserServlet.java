package com.cuit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.entity.User;
import com.cuit.service.DeleteService;
import com.cuit.service.UpDateService;

/**
 * Servlet implementation class DeleteDevice
 */
@WebServlet("/DeleteUser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String action=request.getParameter("action");
		if(action.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			DeleteService delete=null;
			delete.DeleteUserById(id);
		}
		else if(action.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			UpDateService update=null;
			User user=new User();
			user.setEmail(request.getParameter("email"));
			user.setMajor(request.getParameter("major"));
			user.setNickname(request.getParameter("nickname"));
			user.setPassword(request.getParameter("password"));
			user.setPhoneNum(request.getParameter("number"));
			user.setSex(Integer.parseInt(request.getParameter("sex")));
			user.setUid(Integer.parseInt(request.getParameter("uid")));
			user.setW_class(request.getParameter("w_class"));
			update.UpDateUser(user);
			response.sendRedirect("bookList.jsp");
		}
	}

}
