package com.cuit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.service.AddService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddDeviceServlet")
public class AddDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeviceServlet() {
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
		Device device=new Device();
		device.setBrand(request.getParameter("brand"));
		device.setD_type(request.getParameter("d_type"));
		device.setFrom_lab(Integer.parseInt(request.getParameter("from_lab")));
		device.setNote(request.getParameter("note"));
		device.setPrice(Float.parseFloat(request.getParameter("price")));
		device.setUid(Integer.parseInt(request.getParameter("uid")));
		AddService add=null;
		add.AddDevice(device);
		response.sendRedirect("index.jsp");
	}

}
