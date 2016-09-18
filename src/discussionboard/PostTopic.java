package discussionboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PostContent
 */
@WebServlet("/PostTopic")
public class PostTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostTopic() {
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

		HttpSession session = request.getSession();

		String netid = (String) session.getAttribute("netid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String parentid = request.getParameter("pid");
		String datetime = request.getParameter("date");
		String id = datetime.replace(" ", "").replace("-", "").replace("/", "").replace(":", "");

		DiscussionBoardDetail dbd = new DiscussionBoardDetail();

		try {
			int temp = dbd.postContent(id, netid, title, content, parentid, datetime);
			if(temp == 1) {
				response.sendRedirect("DiscussionBoard.jsp");
			}
			else {
				response.sendRedirect("DiscussionBoard.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

}
