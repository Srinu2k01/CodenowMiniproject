package com.cmr.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmr.prj.jdbc.ItemsDatabaseOperations;

/**
 * Servlet implementation class DeleteItems
 */
@WebServlet("/deleteitems")
public class DeleteItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sid = Integer.parseInt(request.getParameter("itemid"));
		
		
		// Step 2: Call the JDBC method to delete student
		ItemsDatabaseOperations repo = new ItemsDatabaseOperations();
		int res = repo.deleterecord(sid);
		
		response.setContentType("text/html");
		
		if(res>0)
		{
			PrintWriter pw = response.getWriter();
			pw.println(sid + " details are deleted successfully.........");
			RequestDispatcher rd = request.getRequestDispatcher("retrieveitems");
			rd.include(request, response);
		} 
		else 
		{
			PrintWriter pw = response.getWriter();
			pw.println("Deletion Failed.............");
			RequestDispatcher rd = request.getRequestDispatcher("retrieveitems");
			rd.include(request, response);
		}
	}

}
