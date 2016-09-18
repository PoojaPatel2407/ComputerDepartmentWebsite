package discussionboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteContent
 */
@WebServlet("/DeleteTopic")
public class DeleteTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTopic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String parentid = request.getParameter("pid");

		DiscussionBoardDetail dbd = new DiscussionBoardDetail();

		try {
			int temp = dbd.deleteContent(id, parentid);
			if (temp == 1) {
				response.sendRedirect("DiscussionBoard.jsp");
			} else {
				response.sendRedirect("DiscussionBoard.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
