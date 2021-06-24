package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmr.prj.jdbc.ItemsDatabaseOperations;
import com.cmr.prj.util.ItemsRecord;

import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;

/**
 * Servlet implementation class UpdateItems
 */
@WebServlet("/updateitems")
public class UpdateItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sid = Integer.parseInt(request.getParameter("itemid"));
		String sname =request.getParameter("itemname");
		int itemsleft = Integer.parseInt(request.getParameter("itemsleft"));
		
		
		// Store the data in a Pojo Class
		ItemsRecord stud = new ItemsRecord();
		stud.setItemid(sid);
		stud.setItemname(sname);
		stud.setItemsleft(itemsleft);
		
		System.out.println(sid);
		System.out.println(sname);
		
		// Send the above values to Repository Layer
		ItemsDatabaseOperations repo = new ItemsDatabaseOperations();
		int result = repo.updateitem(stud);
		
		response.setContentType("text/html");
		
		if(result>0) {
			PrintWriter pw = response.getWriter();
			pw.println(sid + " details are updated successfully.........");
			RequestDispatcher rd = request.getRequestDispatcher("retrieveitems");
			rd.include(request, response);
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("Updation Failed.............");
			RequestDispatcher rd = request.getRequestDispatcher("retrieveitems");
			rd.include(request, response);
		}
	}

}
