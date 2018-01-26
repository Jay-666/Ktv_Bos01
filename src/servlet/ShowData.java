package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Filter.Chain;
import com.sun.org.apache.bcel.internal.classfile.Visitor;

import dao.DBConnection;

/**
 * Servlet implementation class ShowData
 */
@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8"); 
		String sql="select * from room where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		DBConnection db=new DBConnection();
		try {
			List<HashMap<String,Object>> list=db.getList(sql, params);
			System.out.println(list.get(0).get("id"));
			System.out.println(list.get(0).get("situation"));
			request.getSession().setAttribute("list", list);
			

			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			response.sendRedirect("showdata.jsp");
			db.close();
		}
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest req=(HttpServletRequest) request;
		Visitor visitor=(Visitor) req.getSession().getAttribute("visitor");
		String path=req.getContextPath()+"showdata.jsp";
		if(visitor==null){
			java.io.PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("script");
			out.println("window.open('"+path+"','showdata')");
			out.println("/script");
			out.println("/html");
		}
		chain.doFilter(request,response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
