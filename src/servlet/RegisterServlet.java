package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8"); 
		String password = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8"); 
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"); 
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8"); 
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		params.add(password);
		params.add(name);
		params.add(sex);
		String sql="insert into user values(?,?,?,?)";
		DBConnection db=new DBConnection();
		boolean flag=false;
		try {
			flag=db.Updata(sql, params);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		if(flag){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("register.jsp");
		}
		
	}

}
