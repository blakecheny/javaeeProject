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
	<meta http-equiv="description" content="编辑页面">
	<LINK href="css/edit.css" type=text/css rel=stylesheet>
<title>Welcome to Lab Show For Edition</title>
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
				<form action="AddDeviceServlet" method="post" style="line-height: 40px">
				<input type="text" id="labId" name="labMsge">
				<select>
					<option value="号牌">号牌</option>
					<option value="名称">名称</option>
				</select><br/>
				<input type="submit" value="查询" name="submit" class="btn"
				style="position:relative;left:54%"/>
				</form>
			</div>
			<div id="mesg1">
			<%--
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/XXXXX";
			String user = "XXXXX";
			String password = "XXXXX";
			String sql = "select * from XXXX where lab_Id = XX";
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			
			rs.close();
			stmt.close();
			con.close();
	
			--%>
				号牌：	${requestScope.Lab.lab_Id }	<br/><br/>
				名称：	${requestScope.Lab.name }	<br/><br/>
				隶属学院：	${requestScope.Lab.belong }	<br/><br/>
				是否开放：	${requestScope.Lab.open_or_close }	<br/><br/>
				设备类型：	${requestScope.Lab.device_type }	<br/><br/>
				设备数量：	${requestScope.Lab.device_num }	<br/>
			</div>
			<div style="position:absolute;left:1%;bottom:4%;color:rgba(20, 87, 104, 0.8);
					text-decoration:none;font-family:楷体;">
				<a href="http://localhost:8080/j165group_05_javaeeManagerSystem/Login.jsp">返回登录页面</a>
			</div>
		</div>
		<div id="editAndAdd">
			<p style="position:relative;top:10%;left:38%;color:rgba(20, 87, 104, 0.8);
					text-shadow:none;font-family:楷体;">请在下方编辑：</p>
			<div id="EAA">
			<%--
			try {
				//驱动类
				String url = "jdbc:mysql://localhost:3306/db_book";
				String username = "root"; //用户名
				String password = "rootcuit"; //密码
				Connection conn = null;
				Statement statement = null;
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
				statement = conn.createStatement();
				String sql = "select * from XXXX where uid="+request.getParameter("uid");
				ResultSet rs = statement.executeQuery(sql);
			%><%
			if (rs.next()) {		value="<%=request.getParameter("uid")%>"
			--%>
			<form action="" method="post" style="line-height: 40px" id="edi">
				<table style="font-family:微软雅黑;" cellpadding="4" cellspacing="10">
					<tr>
				    	<td><label for="name">设备名: </label></td>
						<td><input type="text" id="name" name="from_lab" tabindex="1"></td>
	            	</tr>
	            	<tr>
					    <td><label for="number">设备号: </label></td>
						<td><input type="text" id="num" name="uid" tabindex="2"></td>
					</tr>
					<tr>
		    			<td><label for="type">设备类型: </label></td>
						<td><input type="text" id="price" name="d_type" tabindex="3"></td>
					</tr>
	            	<tr>
		    			<td><label for="price">设备价格: </label></td>
						<td><input type="text" id="price" name="price" tabindex="4"></td>
					</tr>
					<tr>
		    			<td><label for="price">设备品牌: </label></td>
						<td><input type="text" id="price" name="brand" tabindex="5"></td>
					</tr>
					<tr>
		    			<td><label for="price">备注信息: </label></td>
						<td><input type="text" id="price" name="note" tabindex="6"></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;&nbsp;
							<input id="submit" type="submit" tabindex="7" value="确认"
							class="btn">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" tabindex="8" id="cancel" class="btn"
							onclick="location.href='ShowForUser.jsp'">取消</button>
						</td>
					</tr>
				</table>
			</form>
			<%--
			}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			--%>
			</div>
		</div>
	</div>
	<%@include file="Foot.jsp" %>
</div>
</body>
</html>