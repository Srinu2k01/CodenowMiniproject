package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;

//import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.util.SupplierRecord;
//import com.cmr.prj.jdbc.InventoryDatabaseOperations;
import com.cmr.prj.jdbc.SupplierDatabaseOperations;
/**
 * Servlet implementation class UpdateSupplier
 */
@WebServlet("/updatesupplier")
public class UpdateSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sid = Integer.parseInt(request.getParameter("supplierid"));
		String sname =request.getParameter("suppliername");
		
		
		
		// Store the data in a Pojo Class
		SupplierRecord stud = new SupplierRecord();
		stud.setSupplierid(sid);
		stud.setSuppliername(sname);
		
		System.out.println(sid);
		System.out.println(sname);
		
		// Send the above values to Repository Layer
		SupplierDatabaseOperations repo = new SupplierDatabaseOperations();
		int result = repo.updatesupplier(stud);
		
		response.setContentType("text/html");
		
		if(result>0) {
			PrintWriter pw = response.getWriter();
			pw.println(sid + " details are updated successfully.........");
			RequestDispatcher rd = request.getRequestDispatcher("retrievesupplier");
			rd.include(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("Updation Failed.............");
			RequestDispatcher rd = request.getRequestDispatcher("retrievesupplier");
			rd.include(request, response);
		}
	}

}
