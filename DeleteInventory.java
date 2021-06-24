package com.cmr.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cmr.prj.jdbc.InventoryDatabaseOperations;
/**
 * Servlet implementation class DeleteInventory
 */
@WebServlet("/deleteinventory")
public class DeleteInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Step 1: Read the Student Id from Request ---- Read from UI
				int sid = Integer.parseInt(request.getParameter("id"));
				
				
				// Step 2: Call the JDBC method to delete student
				InventoryDatabaseOperations repo = new InventoryDatabaseOperations();
				int res = repo.deleterecord(sid);
				
				response.setContentType("text/html");
				
				if(res>0) {
					PrintWriter pw = response.getWriter();
					pw.println(sid + " details are deleted successfully.........");
					RequestDispatcher rd = request.getRequestDispatcher("retrieveinventory");
					rd.include(request, response);
				} else {
					PrintWriter pw = response.getWriter();
					pw.println("Deletion Failed.............");
					RequestDispatcher rd = request.getRequestDispatcher("retrieveinventory");
					rd.include(request, response);
				}
				
				
				
	}

}
