package in.techyari.example.controller;

import in.techyari.example.dao.UserDAOImpl;
import in.techyari.example.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String error;
                String status = request.getParameter("status_bar");
		String login = request.getParameter("login");
		String password= request.getParameter("password");
		HttpSession session = request.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
	   
		User user = userDAOImpl.getUserByLogin(login,password);
		
		
		if(user.getFullname() == null){
			error = "Invalid username or password";
			System.out.println("Could not log you in please check your login & password");
			session.setAttribute("error", error);
			response.sendRedirect("index.jsp");
                   
		}else{
			session.setAttribute("user",user);
			System.out.println(session.getAttribute("user"));
			error = "none";
                        if(user.getStatus()==1){
			response.sendRedirect("welcome.jsp");}
                        else if(user.getStatus()==2){
                            response.sendRedirect("flightAddNew.jsp");
                        }else{
                         response.sendRedirect("noImpl.jsp");
                        }
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("logout".equalsIgnoreCase(request.getParameter("query"))){
			
			   HttpSession session = request.getSession();
			   session.removeAttribute("user");
			   session.invalidate();
			   response.sendRedirect("index.jsp");
			}
	}

}
