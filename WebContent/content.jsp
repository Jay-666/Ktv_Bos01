<%@page import="com.mysql.jdbc.Connection" 
		import="java.util.List" 
		import="java.util.ArrayList"
 		import="bean.Room"
		import="dao.DBConnection"
 		import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script >

$(function(){
	$("#tab td").click(function(){
		tid=$(this).find("p").html();  
		window.parent.showdata.location.href="http://127.0.0.1:8080/Ktv_Bos01/ShowData?id="+tid;
	});
});
</script>
	<style>
	#tab{
			text-align: center;
			border: 1px solid black;
		}
		td{
			border: 1px solid black;
			width: 80px;
		}
		
		
	</style>
</head>
<body>
	<% 
	
	DBConnection db=new DBConnection();
	List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
	String district=null;
	district=(String)request.getAttribute("district");
	if(district!=null){
		out.print(district+"-------");
		String sql0="select * from room where district=?";
		List<Object> params=new ArrayList<Object>();
		params.add(district);
		list=db.getList(sql0, params);
	}else{
		String sql="select id,situation from room";
		list=db.getList(sql, null);
		db.close();
	}
	%>
	<table id="tab">

	<%
	int maxtr=list.size()/6+6;
	for(int index=0;index<maxtr-1;index++){
		
		if(index==0 ){
			out.println("<tr>");
		}else if(index%6==0){
			out.println("</tr>");
			out.println("<tr>");
		}else if(index==maxtr-2){
			out.println("</tr>");
		}
			%>
			<td>
			<%
			if(index<list.size()){
				HashMap<String,Object> map=list.get(index);
				out.println("<p>"+map.get("id").toString()+"</p>");
			  	out.println(map.get("situation").toString());
			}
			  %>
			</td>
			<%


	}
	%>
	</table>

</body>
</html>