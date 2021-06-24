package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

//import com.cmr.prj.jdbc.InventoryDatabaseOperations;
import com.cmr.prj.jdbc.SupplierDatabaseOperations;
//import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.util.SupplierRecord;
/**
 * Servlet implementation class RetrieveSupplier
 */
@WebServlet("/retrievesupplier")
public class RetrieveSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SupplierDatabaseOperations repo = new SupplierDatabaseOperations();
		java.util.List<SupplierRecord> Supplierlist = repo.getallrecords();
		System.out.println("Supplier List is......" + Supplierlist);
		
		
		request.setAttribute("SupplierList", Supplierlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplaySupplierList.jsp");
		rd.include(request, response);
	}

}
