package reserveresource;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddResource
 */
@WebServlet("/AddResource")
public class AddResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResource() {
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

		String rname = request.getParameter("rname");
		String rtype = request.getParameter("rtype");
		String rinfo = request.getParameter("rinfo");

		ResourceDAO dao = new ResourceDAO();

		try {
			if (dao.findResource(rname) == 1) {
				if (dao.addResource(rname, rtype, rinfo) == 1) {
					response.sendRedirect("AddResource.jsp");
				}
			} else {
				request.setAttribute("error_r", "Resource already created");
				RequestDispatcher rd = request.getRequestDispatcher("AddResource.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
