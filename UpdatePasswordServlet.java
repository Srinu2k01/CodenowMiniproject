package com.cmr.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cmr.prj.jdbc.LoginRepository;
/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/updatepassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Step 1: Read the Input Values from Request Object 
				String userName = request.getParameter("uname");
				String oldPassword = request.getParameter("oldpasswd");
				String newPassword = request.getParameter("newpasswd");
				String confirmPassword = request.getParameter("confirmpasswd");
				
				PrintWriter pw = response.getWriter();
				// check whehter new password and confirm password are equal or not
				if(!newPassword.equals(confirmPassword)) {
					
					pw.println("<h1> New Password and Confirm Password are mismatch</h1>");
					
					RequestDispatcher rd = request.getRequestDispatcher("updatepassword.jsp");
					rd.include(request, response);
				} else {
					
					LoginRepository repo = new LoginRepository();
					int result = repo.updatePassword(userName,newPassword);
					
					if(result>0) {
						pw.println("<h1> New Password Updated successfully.........</h1>");
						request.setAttribute("userName", userName);
						RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
						rd.include(request, response);
						
					} else {
						
						pw.println("<h1> Password updation failed.........</h1>");
						request.setAttribute("userName", userName);
						RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
						rd.include(request, response);
						
					}
					
					
					
				}
				
			}
}
	


