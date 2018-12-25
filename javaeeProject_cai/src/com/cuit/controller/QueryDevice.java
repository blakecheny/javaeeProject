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
import com.cuit.entity.Lab;
import com.cuit.entity.User;
import com.cuit.impledao.QueryDao;
import com.cuit.service.QueryService;

/**
 * Servlet implementation class QueryOneDevice
 */
@WebServlet("/QueryDevice")
public class QueryDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDevice() {
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
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("sel2");
		if(action.equals("hao")){
			int id=Integer.parseInt(request.getParameter("deviceMsge"));
			QueryService query=new QueryDao();
			List<Device> device= query.FindDeviceById(id);
			System.out.println(id);
			request.setAttribute("device", device);
			RequestDispatcher rd = request.getRequestDispatcher("QueryShow.jsp");
			rd.forward(request, response);
		}
		else if(action .equals("ming")){
			String name=request.getParameter("deviceMsge");
			QueryService query=null;
			Device device=new Device();
			query.FindDeviceByDim(name);
			request.setAttribute("device", device);
			RequestDispatcher rd = request.getRequestDispatcher("QueryShow.jsp");
			rd.forward(request, response);
		}
		else if(action == "all"){
			List<Device> list=new ArrayList<Device>();
			QueryService query=null;
			list=query.FindDeviceAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("ShowForVis.jsp");
			rd.forward(request, response);
		}
		
	}

}
