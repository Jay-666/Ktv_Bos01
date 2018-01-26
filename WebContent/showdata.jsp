<%@page
		import="java.util.List" 
 		import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	var tid = window.loaction.href.split("=")[1];
	window.location.href="http://127.0.0.1:8080/Ktv_Bos01/ShowData?id="+tid;
}


</script>
</head>
<body>
<form action="Updata" method="get">
<table>
<c:forEach items="${list}" var="map">
	<tr>
	<td>id:</td>
	<td><input hidden name="room_id" value="${map['id']}">${map['id']}</a></td>
	</tr>
	<tr>
	<td>分区：</td>
	<td>${map['district']}</td>
	</tr>
		<tr>
	<td>类型：</td>
	<td>${map['type']}</td>
	</tr>
		<tr>
	<td>价格：</td>
	<td>${map['prices']}</td>
	</tr>
		<tr>
	<td>是否可用：</td>
	<td><input hidden name="situation" value="${map['situation']}">${map['situation']}</a></td>
	</tr>
		<tr>
	<td>备注：</td>
	<td>${map['remark']}</td>
	</tr>
	<tr>
<td>用户名:</td>
<td><input type="text" name="user_name" value=""></td>
</tr>
<tr>
<td>电话:</td>
<td><input type="text" name="tel" value=""></td>
</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="订房" />
							</td>
						</tr>
</c:forEach>
</table>
</form>

</body>
</html>