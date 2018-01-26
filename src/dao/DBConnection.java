package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.Room;

import com.mysql.jdbc.Connection;

public class DBConnection {
	Connection conn=null;
	ResultSet resultSet=null;
	PreparedStatement pstmt=null;
	public  Connection getConnection() throws ClassNotFoundException, SQLException{
	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ktv_db?useUnicode=true&amp;characterEncoding=UTF-8 ","root" , "root");
			return conn;
	}
	
	public boolean Updata(String sql,List<Object> params) throws SQLException, ClassNotFoundException{
		boolean flag=false;
		int result=-1;
		conn=getConnection();
		pstmt=conn.prepareStatement(sql);
		 int index=1;
		 System.out.println("------------");
		 if(params!=null && !params.isEmpty()){
			 for (int i = 0; i < params.size(); i++){
				 System.out.println(index+"  "+params.get(i));
				 pstmt.setObject(index++, params.get(i));
				 
			 }
			
		 }
		result=pstmt.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
	}
	
	
	public List<HashMap<String,Object>> getList(String sql,List<Object> params) throws ClassNotFoundException, SQLException {
		 
		 List<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		 conn=getConnection();
		 pstmt = conn.prepareStatement(sql);
		 int index=1;
		 if(params!=null && !params.isEmpty()){
			 for (int i = 0; i < params.size(); i++){
				 pstmt.setObject(index++, params.get(i));
			 }
			
		 }
		 resultSet =  pstmt.executeQuery();
		 ResultSetMetaData metaData = resultSet.getMetaData();
		 int cols_len = metaData.getColumnCount();
		 while(resultSet.next()){
			 HashMap<String,Object> map=new HashMap<String,Object>();
			 for(int i=0;i<cols_len;i++){
				 String cols_name=metaData.getColumnName(i+1);
				 Object cols_value=resultSet.getObject(cols_name);
				 if(cols_value==null){
					 cols_value="";
				 }
				 map.put(cols_name, cols_value);
			 }
			 
			 list.add(map);
		 }
		 
		 
		 return list;
	}
	public void close(){
		try {
			if(resultSet!=null)
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
