package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/task-add-servlet")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	//POSTリクエストを受け取る
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");

		//フォームの値を取得
		String taskName = request.getParameter("taskName");
		String categoryName = request.getParameter("categoryName");
		String dateStr = request.getParameter("date");
		String userName = request.getParameter("userName");
		String status = request.getParameter("status");
		String memo = request.getParameter("memo");

		//TaskBeanを作成
		TaskBean task = new TaskBean();
		
		//Beanに値をセット
		task.setTaskName(taskName);
		task.setCategoryName(categoryName);

		//日付を変換してセット
		if (dateStr != null && !dateStr.isEmpty()) {
			task.setDate(LocalDate.parse(dateStr));
		}

		//残りの項目をセット
		task.setUserName(userName);
		task.setStatus(status);
		task.setMemo(memo);

		//DAOを生成
		TaskDAO dao = new TaskDAO();

		try {

			//DBへ登録
			int count = dao.insert(task);

			//登録に成功したらadd-success.jspへ遷移
			if (count > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("add-success.jsp");
				rd.forward(request, response);
				
			//登録に失敗したらadd-error.jspへ遷移
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("add-error.jsp");
				rd.forward(request, response);
			}

			//DB接続失敗やSQLエラーなどが発生した場合の例外処理
		} catch (Exception e) {

			//エラー内容をコンソールに出力
			e.printStackTrace();
			//エラーが面へ遷移
			RequestDispatcher rd = request.getRequestDispatcher("add-error.jsp");
			rd.forward(request, response);
		}
	}
}