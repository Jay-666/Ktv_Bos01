package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

/**
 * Servlet implementation class Updata
 */
@WebServlet("/Updata")
public class Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String order_id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8"); 
		String room_id = new String(request.getParameter("room_id").getBytes("iso-8859-1"), "utf-8"); 
		String user_name = new String(request.getParameter("user_name").getBytes("iso-8859-1"), "utf-8"); 
		String tel=new String(request.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
//		System.out.println(room_id+user_name+tel);
		List<Object> params_order=new ArrayList<Object>();
		List<Object> params_room=new ArrayList<Object>();
		params_order.add(user_name);
		params_order.add(tel);
		params_room.add("≤ªø…”√");
		params_room.add(room_id);
		
//		System.out.println(params_order.size());
		String sql_order="insert into order_table (user_name,tel) values(?,?)";
		String sql_room="update room set situation=? where id=?";
		DBConnection db=new DBConnection();
		try {
			boolean flag=db.Updata(sql_order, params_order);
			if(flag){
				boolean flag0=db.Updata(sql_room, params_room);
			}
			response.sendRedirect("content.jsp");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
