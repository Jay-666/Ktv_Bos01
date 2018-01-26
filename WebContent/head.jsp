<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
			body{
				background-color: palevioletred;
				height: auto;
				width: 1000;
			}
			h1{
				padding: 0;
				text-align: center;
				line-height: 100px;
			}
			span{
				float: right;
			}
		</style>
</head>
<body>
		<h1>
			KTV包厢管理系统
		</h1>
		<br />
		<span id="span">
		<a>用户：</a>
		<a id="username"><%=session.getAttribute("name") %></a>
		</span>
</body>
</html>