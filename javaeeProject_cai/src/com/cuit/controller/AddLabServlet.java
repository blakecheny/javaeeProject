package com.cuit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.service.AddService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddLabServlet")
public class AddLabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLabServlet() {
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
		Lab lab=new Lab();
		lab.setBelong(request.getParameter("belong"));
		lab.setDevice_num(request.getParameter("device_num"));
		lab.setDevice_type(request.getParameter("device_type"));
		lab.setLab_id(Integer.parseInt(request.getParameter("lab_id")));
		lab.setName(request.getParameter("name"));
		lab.setOpen_or_close(Integer.parseInt(request.getParameter("right")));
		lab.setType(request.getParameter("type"));
		AddService add=null;
		add.AddLab(lab);
		response.sendRedirect("index.jsp");
	}

}
