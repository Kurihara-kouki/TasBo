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

import model.dao.CategoryDAO;
import model.dao.StatusDAO;
import model.dao.UserDAO;
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class TaskAlterServlet
 */
@WebServlet("/task-alter-servlet")
public class TaskAlterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskAlterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//リクエストのエンコーディング方式(ない場合文字化けする)
		request.setCharacterEncoding("UTF-8");
				
		CategoryDAO categoryDao = new CategoryDAO();
		StatusDAO statusDao = new StatusDAO();
		UserDAO userDao = new UserDAO();
				
		//セッション取得
		HttpSession session = request.getSession();
				
		session.setAttribute("taskId", request.getParameter("taskId"));
		List<TaskBean> taskList = (List<TaskBean>) session.getAttribute("taskList");
				
				
		List<CategoryBean> categoryList;
		List<StatusBean> statusList;
		List<UserBean> userList;
				
		try {
			categoryList = categoryDao.selectAll();
			statusList = statusDao.selectAll();
			userList = userDao.selectAll();
					
			for(TaskBean taskBean : taskList) {
				if(taskBean.getTaskId() == Integer.parseInt(request.getParameter("taskId"))) {
					session.setAttribute("taskBean", taskBean);
				}
			}
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("statusList", statusList);
			session.setAttribute("userList", userList);
					
			//転送準備
			RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
			//転送
			rd.forward(request, response);
					
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				//転送準備
				RequestDispatcher rd = request.getRequestDispatcher("task-alter-form.jsp");
				//転送
					rd.forward(request, response);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
