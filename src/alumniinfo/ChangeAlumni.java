package alumniinfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeAlumni
 */
@WebServlet("/ChangeAlumni")
public class ChangeAlumni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAlumni() {
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
		String aname = request.getParameter("aname");
		String ainfo = request.getParameter("ainfo");
		String aurl = request.getParameter("aurl");
		String aid = request.getParameter("aid");

		AlumniDAO ad = new AlumniDAO();
		int temp = ad.editAlumni(aid, aname, ainfo, aurl);
		if (temp == 1) {
			response.sendRedirect("ChangeAlumni.jsp");
		}
	}

}
