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
import com.cuit.impledao.QueryDao;
import com.cuit.service.QueryService;

/**
 * Servlet implementation class QueryOneDevice
 */
@WebServlet("/QueryLab")
public class QueryLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryLab() {
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
		if("hao".equals(action)){
			System.out.println(action);
			if(request.getParameter("labMsge")!=""){
				int id=Integer.parseInt(request.getParameter("labMsge"));
				System.out.println(id);
				QueryService query=new QueryDao();
				Lab lab=query.FindLabById(id);
				List<Device> device = query.FindDeviceByLabId(6310);
				
				request.setAttribute("lab", lab);
				request.setAttribute("device",device);
				RequestDispatcher rd = request.getRequestDispatcher("QueryShow.jsp");
				rd.forward(request, response);
			}
			else{
				System.out.println("没有参数");
			}
			
		}
		else if(action == "ming"){
			String name=request.getParameter("name");
			QueryService query=new QueryDao();
			Lab lab=query.FindLabByName(name);
			request.setAttribute("lab", lab);
			RequestDispatcher rd = request.getRequestDispatcher("ShowForVis.jsp");
			rd.forward(request, response);
		}
		else if(action == "all"){
			List<Lab> list=new ArrayList<Lab>();
			QueryService query=null;
			list=query.FindLabAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("ShowForVis.jsp");
			rd.forward(request, response);
		}
		else if(action == "fuz"){
			String name=request.getParameter("name");
			QueryService query=null;
			Lab lab=new Lab();
			query.FindLabByDim(name);
			request.setAttribute("lab", lab);
			RequestDispatcher rd = request.getRequestDispatcher("ShowForVis.jsp");
			rd.forward(request, response);
		}
	}

}
