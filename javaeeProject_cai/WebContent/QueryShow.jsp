<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cuit.entity.Lab" %>
<%@ page import="com.cuit.entity.Device" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="lab" class="com.cuit.entity.Lab" scope="request"></jsp:useBean>
<%-- <jsp:useBean id="device" class="com.cuit.entity.Device" scope="request"></jsp:useBean>
 --%>
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
<title>Welcome to Lab Show</title>
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
				<form action="/QueryLab" method="post" style="line-height: 40px">
				<input type="text" id="labId" name="labMsge">
				<select name="sel">
					<option value="hao">号&nbsp;&nbsp;&nbsp;&nbsp;牌</option>
					<option value="ming">名&nbsp;&nbsp;&nbsp;&nbsp;称</option>
					<option value="模查">模糊查询</option>
					<option value="all" selected="selected">全&nbsp;&nbsp;&nbsp;&nbsp;部</option>
				</select><br/>
				<input type="submit" value="查询" name="submit" class="btn"
				style="position:relative;left:54%"/>
				</form>
			</div>
			<div id="mesg1" style="text-align:left;position:relative;left:10%;">
				号牌：	${requestScope.lab.lab_id }	<br/><br/>
				类型：	${requestScope.lab.type }	<br/><br/>
				名称：	${requestScope.lab.name }	<br/><br/>
				隶属学院：	${requestScope.lab.belong }	<br/><br/>
				是否开放：	${requestScope.lab.open_or_close }	<br/><br/>
				设备类型：	${requestScope.lab.device_type }	<br/><br/>
				设备数量：	${requestScope.lab.device_num }	<br/>
			</div>
			<div style="position:absolute;left:1%;bottom:4%;color:rgba(20, 87, 104, 0.8);
					text-decoration:none;font-family:楷体;">
				<a href="http://localhost:8080/j165group_05_javaeeManagerSystem/Login.jsp">返回登录页面</a>
			</div>
		</div>
		<div id="device">
		<p style="position:relative;top:12%;left:23%;color:rgba(20, 87, 104, 0.8);
					text-shadow:none;font-family:楷体;">请输入设备号或设备名：</p>
			<div id="input2">
				<form action="QueryDevice" method="post" style="line-height: 40px">
					<input type="text" id="uid" name="deviceMsge">
					<select name="sel2">
					<option value="hao" selected="selected">设备号</option>
					<option value="ming">设备名</option>
				</select><br/>
					<input type="submit" value="🔍" name="submit" id="query"/>
				</form>
			</div>
			<div id="add">
					<form action="http://localhost:8080/j165group_05_javaeeManagerSystem/Edit.jsp" method="post" style="line-height: 40px">
						<input type="submit" value="添加新设备" name="add" class="btn"
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
					<tr>
						<c:forEach items="${requestScope.device}" var="info">	
						
							<td>${info.from_lab }</td>
							<td>${info.uid }</td>
							<td>${info.d_type }</td>
							<td>${info.price }</td>
							<td>${info.brand }</td>
							<td>${info.note }</td>
							<td>
								<a href="${pageContext.request.contextPath}/edit.jsp">编辑</a>
								<a href="${pageContext.request.contextPath}/DeleteDevice?id=${info.uid }">删除</a>
							</td> 
							</tr>
						</c:forEach>	
					
				</table></div>
			</div>
		</div>
	</div>
	<%@include file="Foot.jsp" %>
</div>
</body>
</html>