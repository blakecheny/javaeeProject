<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="实验室,管理系统,登录">
	<meta http-equiv="description" content="登录页面">
	<LINK href="css/login.css" type=text/css rel=stylesheet>
<title>Welcome to Lab Show</title>
</head>
<body>
<div id="container">
	<%@include file="Navi.jsp" %>
    <div id="content">
        <div id="login">
            <div id="wel">
                <span class="sty" style="position: absolute;top:0;left:20%">꧁</span>
                <h4 class="sty">欢迎进入</h4>
                <span class="sty" style="color: rgba(20, 87, 104, 0.4);position: absolute;top:0;right: 22%">꧂</span>
            </div>
            <hr style="color: rgba(20, 87, 104, 0.2);border: solid 2px rgba(20, 87, 104, 0.6);">
            <div id="inpu">
                <form action="UserServlet" method="post" style="line-height: 60px">
                    <label>用户ID：
                        <input type="text" name="uid" id="uId" placeholder="请输入用户id！">
                    </label><br/>
                    <label>密&nbsp;&nbsp;&nbsp; 码：
                        <input type="password" name="password" id="psw">
                    </label>
                    <a href="http://www.cuit.edu.cn" style="font-family: 宋体;font-size: smaller;">忘记密码？</a><br/>
                    &nbsp;&nbsp;
                    <input type="submit" value="登 录" name="submit" class="btn"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" value="访 客" name="visitor" class="btn" onclick="location.href='ShowForVis.jsp'"/><br/><br/>
                </form>
            </div>
        </div>
    </div>
	<%@include file="Foot.jsp" %>
</div>
</body>
</html>