package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.cmr.prj.jdbc.ItemsDatabaseOperations;
//import com.cmr.prj.jdbc.SupplierDatabaseOperations;
//import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.util.ItemsRecord;
//import com.cmr.prj.util.SupplierRecord;
/**
 * Servlet implementation class RetrieveItems
 */
@WebServlet("/retrieveitems")
public class RetrieveItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemsDatabaseOperations repo = new ItemsDatabaseOperations();
		java.util.List<ItemsRecord> Itemlist = repo.getallrecords();
		System.out.println("Item List is......" + Itemlist);
		
		
		request.setAttribute("ItemsList", Itemlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayItemsList.jsp");
		rd.include(request, response);
		
	}

}
