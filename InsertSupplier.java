package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import com.cmr.prj.jdbc.SupplierDatabaseOperations;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class InsertSupplier
 */
@WebServlet("/insertsupplier")
public class InsertSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int supplierid = Integer.parseInt(request.getParameter("id"));
		String suppliername = request.getParameter("supplier name");
		
		SupplierDatabaseOperations repo=new SupplierDatabaseOperations();
		int result =repo.insertrecord(supplierid,suppliername);
		PrintWriter pw = response.getWriter();
		
		if(result>0) {
			pw.println("<h1> Record Inserted Successfully</h1>");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.include(request, response);
		} else {
				
			pw.println("<h1> Insertion Failed </h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("insertsupplier.html");
			rd.include(request, response);
		}
	}

}
