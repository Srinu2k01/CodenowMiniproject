package com.cmr.prj;

import java.io.IOException;
import java.io.PrintWriter;
import com.cmr.prj.jdbc.LoginRepository;
import com.cmr.prj.util.InventoryRecord;
import com.cmr.prj.util.LoginRecord;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Read the Credentials from UI --- Read the data from Request Object
				String userName = request.getParameter("uname");
				String passwdFromUI = request.getParameter("passwd");
				
				// Step 2: Fetch the password of the above user from DB
				LoginRepository repo = new LoginRepository();
				String passwordFromDB =  repo.getPassword(userName);
				
				// validate the credentials and redirect to the respective page
				//System.out.println(passwordFromDB);
				PrintWriter pw = response.getWriter();
				
				if(passwordFromDB.length()==0) {
					// recieved an empty string from repository.
					// beacuse  user name is not available in DB
				    pw.println("<h1> Invalid User Name");
				    RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request,response);
				    
				} else  
					if(passwdFromUI.equals(passwordFromDB)) {
						LoginRecord stud = new LoginRecord();
						
						RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
						request.setAttribute("LoginRecord", stud);
						rd.include(request,response);
					} else {
						// Password is not matching
						pw.println("<h1> Invalid Password</h1>");
						RequestDispatcher rd = request.getRequestDispatcher("login.html");
						rd.include(request,response);
						
					}
					
		
		// TODO Auto-generated method stub
	}

}
