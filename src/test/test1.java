package test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import dao.DBConnection;

public class test1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		String sql="select id,situation from room";
		try {
			List<HashMap<String,Object>> list=(new DBConnection()).getList(sql, null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
