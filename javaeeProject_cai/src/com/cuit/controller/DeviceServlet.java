package com.cuit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cuit.entity.Device;
import com.cuit.impledao.DeleteDao;
import com.cuit.service.DeleteService;
import com.cuit.service.UpDateService;

/**
 * Servlet implementation class DeleteDevice
 */
@WebServlet("/DeleteDevice")
public class DeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeviceServlet() {
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
		int did=Integer.parseInt(request.getParameter("id"));
		DeleteService delete=new DeleteDao();
		delete.DeleteDeviceById(did);
		response.sendRedirect("ShowForUser.jsp");
		System.out.println("已删除");
		/*if(action.equals("del")){
			int id=Integer.parseInt(request.getParameter("id"));
			DeleteService delete=null;
			delete.DeleteDeviceById(id);
		}
		else if(action.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			UpDateService update=null;
			Device device=new Device();
			device.setBrand(request.getParameter("brand"));
			device.setD_type(request.getParameter("d_type"));
			device.setFrom_lab(Integer.parseInt(request.getParameter("from_lab")));
			device.setNote(request.getParameter("note"));
			device.setPrice(Float.parseFloat(request.getParameter("price")));
			device.setUid(Integer.parseInt(request.getParameter("uid")));
			update.UpDateDevice(device);
			response.sendRedirect("bookList.jsp");
		}*/
	}

}
