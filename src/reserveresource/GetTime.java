package reserveresource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetTime
 */
@WebServlet("/GetTime")
public class GetTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTime() {
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

		PrintWriter pw = response.getWriter();

		String rname = request.getParameter("rname");
		String rdate = request.getParameter("rdate");

		ResourceDAO rd = new ResourceDAO();
		ArrayList<String> rtime = new ArrayList<>();
		try {
			rtime = rd.getTime(rname, rdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<String> slots = new ArrayList<>();
		slots.add("7-9");
		slots.add("9-11");
		slots.add("11-1");
		slots.add("1-3");
		slots.add("3-5");
		slots.add("5-7");

		HttpSession session = request.getSession();

		for (int i = 1; i < 7; i++) {
			if (!rtime.contains(Integer.toString(i))) {
				pw.write("<form action='MakeReservation' method='Post'>");
				pw.write("<input type='hidden' value='" + i + "' name='rtime'>");
				pw.write("<input type='hidden' value='" + rname + "' name='rname'>");
				pw.write("<input type='hidden' value='" + session.getAttribute("netid") + "' name='netid'>");
				pw.write("<input type='hidden' value='" + rdate + "' name='rdate'>");
				pw.write("<p>" + slots.get(i - 1) + "</p>");
				pw.write("<input type='submit' value='Reserve' name='Reserve'>");
				pw.write("</form>");
			}
		}

	}
}
