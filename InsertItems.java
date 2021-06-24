package com.cmr.prj;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmr.prj.jdbc.ItemsDatabaseOperations;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class InsertItems
 */
@WebServlet("/insertitems")
public class InsertItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int itemid = Integer.parseInt(request.getParameter("item id"));
		String itemname = request.getParameter("item name");
		int itemsleft = Integer.parseInt(request.getParameter("items left"));
		
		ItemsDatabaseOperations repo=new ItemsDatabaseOperations();
		int result =repo.insertrecord(itemid,itemname,itemsleft);
		PrintWriter pw = response.getWriter();
		
		if(result>0) {
			pw.println("<h1> Record Inserted Successfully</h1>");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.include(request, response);
		} else {
				
			pw.println("<h1> Insertion Failed </h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("insertitems.html");
			rd.include(request, response);
		}
	}
	
	
	}


