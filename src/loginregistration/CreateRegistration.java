package loginregistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginregistration.DAO;
import loginregistration.DoRegistration;

/**
 * Servlet implementation class CreateRegistration
 */
@WebServlet("/CreateRegistration")
public class CreateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String netid = request.getParameter("netid");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String major = request.getParameter("major");
		String year = "null";
		String program = "null";
		if (role.equals("student")) {
			year = request.getParameter("year");
			program = request.getParameter("program");
		}

		DAO dao = new DAO();

		if (!dao.AvailNetID(netid, role)) {
			DoRegistration fr = new DoRegistration();
			try {
				int temp = fr.insertRecord(netid, password, role, fname, lname, year, program, major);
				if (temp == 1) {
					response.sendRedirect("flogin.jsp");
				} else {
					response.sendRedirect("Register.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Register.jsp");
		}
	}
}
