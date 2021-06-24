package com.cmr.prj;

import java.io.IOException;
import java.io.PrintWriter;
import com.cmr.prj.jdbc.LoginRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Step 1: Read the Credentials from UI --- Read the data from Request Object
		String userName = request.getParameter("uname");
		String passwdFromUI = request.getParameter("passwd");
		
		// Step 2: Send the values to DB
		LoginRepository repo = new LoginRepository();
		int result = repo.registerUser(userName,passwdFromUI);
		
		PrintWriter pw = response.getWriter();
		
		if(result>0) {
			pw.println("<h1> Congratulations......Registered Successfully</h1>");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else {
				
			pw.println("<h1> Sorry......Registration Failed or username alraedy exists,try using different user name </h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
		
			
	}

}
