package com.cmr.prj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.jdbc.InventoryDatabaseOperations;
/**
 * Servlet implementation class UpdateInventory
 */
@WebServlet("/updateinventory")
public class UpdateInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Step 1: Reading the data from Request Object --- reading the Inputs from UI
				int sid = Integer.parseInt(request.getParameter("id"));
				int sname =Integer.parseInt(request.getParameter("supplierid"));
				int cid = Integer.parseInt(request.getParameter("itemid"));
				int fid = Integer.parseInt(request.getParameter("itemssupplied"));
				
				
				// Store the data in a Pojo Class
				InventoryRecord stud = new InventoryRecord();
				stud.setId(sid);
				stud.setSupplierid(sname);
				stud.setItemid(cid);
				stud.setItemssupplied(fid);
				System.out.println(sid);
				System.out.println(sname);
				System.out.println(cid);
				System.out.println(fid);
				// Send the above values to Repository Layer
				InventoryDatabaseOperations repo = new InventoryDatabaseOperations();
				int result = repo.updateinventory(stud);
				
				response.setContentType("text/html");
				
				if(result>0) {
					PrintWriter pw = response.getWriter();
					pw.println(sid + " details are updated successfully.........");
					RequestDispatcher rd = request.getRequestDispatcher("retrieveinventory");
					rd.include(request, response);
				} else {
					PrintWriter pw = response.getWriter();
					pw.println("Updation Failed.............");
					RequestDispatcher rd = request.getRequestDispatcher("retrieveinventory");
					rd.include(request, response);
				}
				
				
	}

}
