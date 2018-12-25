package com.cuit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.entity.Lab;
import com.cuit.service.DeleteService;
import com.cuit.service.UpDateService;

/**
 * Servlet implementation class DeleteDevice
 */
@WebServlet("/DeleteLab")
public class LabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabServlet() {
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
			delete.DeleteLabById(id);
		}
		else if(action.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			UpDateService update=null;
			Lab lab=new Lab();
			lab.setBelong(request.getParameter("belong"));
			lab.setDevice_num(request.getParameter("device_num"));
			lab.setDevice_type(request.getParameter("device_type"));
			lab.setLab_id(Integer.parseInt(request.getParameter("lab_id")));
			lab.setName(request.getParameter("name"));
			lab.setOpen_or_close(Integer.parseInt(request.getParameter("right")));
			lab.setType(request.getParameter("type"));
			update.UpDateLab(lab);
			response.sendRedirect("bookList.jsp");
		}
	}

}
