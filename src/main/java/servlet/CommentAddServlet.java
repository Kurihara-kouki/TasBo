package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentDAO;
import model.entity.CommentBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class CommentAddServlet
 */
@WebServlet("/comment-add-servlet")
public class CommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッション取得
		HttpSession session = request.getSession();

		//セッションスコープにユーザ情報がセットされていない場合
		if (session.getAttribute("user") == null) {

			//user情報がなければログイン画面へ遷移
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			//転送
			rd.forward(request, response);

			//ログイン済みの場合はそのまま登録フォームへ遷移
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("comment-add.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();

			UserBean user = (UserBean) session.getAttribute("user");
			TaskBean task = (TaskBean) session.getAttribute("task");

			int taskId = task.getTaskId();
			String comment = request.getParameter("comment");

			// 入力チェック
			if (comment == null || comment.trim().isEmpty()) {
				request.setAttribute("error", "コメントを入力してください。");
				RequestDispatcher rd = request.getRequestDispatcher("comment-list.jsp");
				rd.forward(request, response);
				return;
			}
			//文字数チェック
			if (comment.length() > 100) {
				request.setAttribute("error", "コメントは100文字以内で入力してください。");
				RequestDispatcher rd = request.getRequestDispatcher("comment-list.jsp");
				rd.forward(request, response);
				return;
			}

			//削除チェック
			CommentBean bean = new CommentBean();
			bean.setTaskId(taskId);
			bean.setUserId(user.getUserId());
			bean.setComment(comment);

			CommentDAO dao = new CommentDAO();

			try {

				dao.insert(bean);

			} catch (NullPointerException | SQLException e) {

				request.setAttribute("error", "対象のタスクは既に削除されています。");

				RequestDispatcher rd = request.getRequestDispatcher("comment-list.jsp");
				rd.forward(request, response);
				return;
			}

			// 最新コメント取得
			List<CommentBean> commentList = dao.select(taskId);
			session.setAttribute("commentList", commentList);

			// コメント一覧へ
			response.sendRedirect("comment-list-servlet?taskId=" + taskId);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
