package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import com.cmr.prj.jdbc.InventoryDatabaseOperations;

/**
 * Servlet implementation class InsertInventory
 */
@WebServlet("/insertinventory")
public class InsertInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
			int supplierid = Integer.parseInt(request.getParameter("supplier id"));
			int itemid = Integer.parseInt(request.getParameter("items id"));
			int itemsleft = Integer.parseInt(request.getParameter("items supplied"));
			
			InventoryDatabaseOperations repo= new InventoryDatabaseOperations();
			int result = repo.insertrecord(id,supplierid,itemid,itemsleft);
			
			PrintWriter pw = response.getWriter();
			
			if(result>0) {
				pw.println("<h1> Record Inserted Successfully</h1>");
				
				//request.setAttribute("userName", userName);
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.include(request, response);
			} else {
					
				pw.println("<h1> Insertion Failed </h1>");
				
				RequestDispatcher rd = request.getRequestDispatcher("insertinventory.html");
				rd.include(request, response);
			}
	
	}

}
