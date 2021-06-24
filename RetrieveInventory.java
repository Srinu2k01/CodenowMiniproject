package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.cmr.prj.jdbc.InventoryDatabaseOperations;
import com.cmr.prj.util.InventoryRecord;
/**
 * Servlet implementation class RetrieveInventory
 */
@WebServlet("/retrieveinventory")
public class RetrieveInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		
		InventoryDatabaseOperations repo = new InventoryDatabaseOperations();
		java.util.List<InventoryRecord> Inventorylist = repo.getallrecords();
		System.out.println("Inventory List is......" + Inventorylist);
		
		
		request.setAttribute("InventoryList", Inventorylist);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayInventoryList.jsp");
		rd.include(request, response);

}
}
