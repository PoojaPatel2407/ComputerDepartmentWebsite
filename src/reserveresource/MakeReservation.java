package reserveresource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MakeReservation
 */
@WebServlet("/MakeReservation")
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeReservation() {
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
		String rdate = request.getParameter("rdate");
		String rtime = request.getParameter("rtime");
		String netid = request.getParameter("netid");
		
		ResourceDAO rd = new ResourceDAO();
		ArrayList<String> rtimes = new ArrayList<>();
		try {
			rtimes = rd.getTime(rname, rdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rtimes.add(rtime);
		
		try {
			if(rd.reserve(netid, rname, rdate, rtime) == 1) {
				response.sendRedirect("MakeReservation.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
