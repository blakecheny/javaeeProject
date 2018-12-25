<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cuit.entity.Lab" %>
<%@ page import="com.cuit.entity.Device" %>
<%@page import="java.sql.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="lab" class="com.cuit.entity.Lab" scope="request"></jsp:useBean>
<jsp:useBean id="device" class="com.cuit.entity.Device" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="实验室,管理系统,登录">
	<meta http-equiv="description" content="查看页面">
	<LINK href="css/showForUOrV.css" type=text/css rel=stylesheet>
<title>Welcome to Lab Show For Users</title>
</head>
<body>
<div id="container">
	<%@include file="Navi.jsp" %>
	<div id="content">
		<div id="lab">
			<div id="title1">实验室信息</div>
			<p style="position:relative;top:16%;left:4%;color:rgba(20, 87, 104, 0.8);
					text-shadow:none;font-family:楷体;">请输入实验室号或实验室名称：</p>
			<div id="input1">
				<form action="QueryLab" method="post" style="line-height: 40px">
				<input type="text" id="labId" name="labMsge">
				<select name="sel">
					<option value="号牌">号牌</option>
					<option value="名称">名称</option>
					<option value="全部">全部</option>
					<option value="模糊">模糊查询</option>
				</select><br/>
				<input type="submit" value="查询" name="submit" class="btn"
				style="position:relative;left:54%"/>
				</form>
			</div>
			<div id="mesg1">
				<%
				try{
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/javaee";
				String user = "root";
				String password = "rootcuit";
				String sql = "select * from j_lab";
				
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				out.print("<table cellspacing='8'><tr><th>"+"号牌"+"</th>");	
				out.print("<th>"+"名称"+"</th>");	
				out.print("<th>"+"隶属"+"</th></tr>");
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>"+rs.getInt("lab_id")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");		
					out.print("<td>"+rs.getString("belong")+"</td>");			
					out.print("</tr>");
					rs.next();
				}
				out.print("</table>");
				rs.close();
				stmt.close();
				con.close();
				}catch(Exception e){}
				%>
			</div>
			<div style="position:absolute;left:1%;bottom:4%;color:rgba(20, 87, 104, 0.8);
					text-decoration:none;font-family:楷体;">
				<a href="http://localhost:8080/javaeeProject/Login.jsp">返回登录页面</a>
			</div>
		</div>
		<div id="device">
			<p style="position:relative;top:12%;left:23%;color:rgba(20, 87, 104, 0.8);
					text-shadow:none;font-family:楷体;">请输入设备号或设备名：</p>
			<div id="input2">
				<form action="QueryDevice" method="post" style="line-height: 40px">
					<input type="text" id="uid" name="deviceMsge">
					<select name="sel">
						<option value="hao">设备名</option>
						<option value="名称">设备号</option>
						<option value="全部">全部</option>
						<option value="模糊">模糊查询</option>
					</select><br/><br/>
					<input type="submit" value="🔍" name="submit" id="query"/>
				</form>
			</div>
			<div id="add">
					<form action="Edit.jsp" method="post" style="line-height: 40px">
						<input type="submit" value="添加新设备" name="submit" class="btn"
						style="width:120px;"/>
				</form>
			</div>
			<div id="mesg2">
				<div id="table">
				<table>
					<tr id="title2"><th colspan="7">设备信息</th></tr>
					<tr>
						<th>从属实验室</th>
						<th>设备号</th>
						<th>类型</th>
						<th>价格</th>
						<th>品牌</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					<%
				try{
				String sql2 = "select * from j_device where from_lab=6310";
				
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/javaee";
				String user = "root";
				String password = "rootcuit";
				
				Connection con = null;
				Statement stmt2 = null;
				ResultSet rs2 = null;
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				stmt2 = con.createStatement();
				rs2 = stmt2.executeQuery(sql2);
			
				int intPageSize; //一页显示的记录数
				int intRowCount; //记录的总数
				int intPageCount; //总页数
				int intPage; //当前页数
				String strPage;
				int i;
				intPageSize = 4; //设置一页显示的记录数
				strPage = request.getParameter("page");//取得待显示的页码
				if (strPage == null) //判断strPage是否等于null,如果是，显示第一页数据
				{
					intPage = 1;
				} else {
					intPage = java.lang.Integer.parseInt(strPage); //将字符串转换为整型
				}
				if (intPage < 1) {
					intPage = 1;
				}
				rs2.last();//获取记录总数
				intRowCount = rs2.getRow();	//得到当前游标所指行的行号，行号从1开始，若结果集无行则返回0
				intPageCount = (intRowCount + intPageSize - 1) / intPageSize; //计算机总页数
				if (intPage > intPageCount)
					intPage = intPageCount; //调整当前页码
				if (intPageCount > 0) {
					//将记录指针定位到当前页的第一条记录上
					rs2.absolute((intPage - 1) * intPageSize + 1);
				}
				//下面用于显示数据
				i = 0;
				while (i < intPageSize && !rs2.isAfterLast()) {
					out.print("<tr>");
					out.print("<td>"+rs2.getInt("from_lab")+"</td>");
					out.print("<td>"+rs2.getInt("d_id")+"</td>");
					out.print("<td>"+rs2.getString("d_type")+"</td>");		
					out.print("<td>"+rs2.getString("price")+"</td>");		
					out.print("<td>"+rs2.getString("brand")+"</td>");		
					out.print("<td>"+rs2.getString("note")+"</td>");
					out.print("<td>"
					+"<a href='Edit.jsp'>编辑</a>"
					+"&nbsp;&nbsp;"
					+"<a href='DeviceServlet'>删除</a>"
					+"</td>");	
					out.print("</tr>");
					rs2.next();
				}
				%><tr><td colspan='7'>
				共<%=intRowCount%>个记录，分<%=intPageCount%>页显示/当前第<%=intPage%>页     <%
						for (int j = 1; j <= intPageCount; j++) {
								out.print("&nbsp;&nbsp;<a href='ShowForUser.jsp?page=" + j + "'>"
										+ j + "</a>");			//此处设置了page参数
							}
					%></td>
					</tr>
				</table><%
				rs2.close();
				stmt2.close();
				con.close();
				}catch(Exception e){}
				%>
				</div>
			</div>
		</div>
	</div>
	<%@include file="Foot.jsp" %>
</div>
</body>
</html>