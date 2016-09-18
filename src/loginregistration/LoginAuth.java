package loginregistration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginregistration.LoginCheck;

/**
 * Servlet implementation class LoginAuth
 */
@WebServlet("/LoginAuth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String netid = request.getParameter("netid");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		LoginCheck lc = new LoginCheck();
		String type = "null";

		try {
			type = lc.LoginDetailsCheck(netid, password, role);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (type.equals("null")) {
			request.setAttribute("error_l", "Invalid Details");
			RequestDispatcher dispatcher = request.getRequestDispatcher("flogin.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("netid", netid);
			session.setAttribute("type", type);
			response.sendRedirect("home.jsp");

		}
	}

}
