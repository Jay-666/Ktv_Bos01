<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post" name="regForm">
					<table border="1xp" width="760xp" height="400xp" align="center" cellpadding="0xp" cellspacing="0xp" bgcolor="aliceblue">
						<tr>
							<td colspan="2">
								<font size="4">会员注册</font> &nbsp;&nbsp;&nbsp;   USER REGISTER
							</td>
							
						</tr>
						<tr>
							<td>用户名</td>
							<td>
								<input type="text" name="user" />
							</td>
						</tr>
						<tr>
							<td>密码</td>
							<td>
								<input type="password" name="password" />
							</td>
						</tr>
						<tr>
							<td>确认密码</td>
							<td>
								<input type="password" name="repassword" />
							</td>
						</tr>

						<tr>
							<td>姓名</td>
							<td>
								<input type="text" name="name"/>
							</td>
						</tr>
						<tr>
							<td>性别</td>
							<td>
								<input type="radio" name="sex" value="男" />男
								<input type="radio" name="sex" value="女" />女
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<input type="submit" value="注册" />
							</td>
						</tr>
					</table>
					</form>
</body>
</html>