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
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String taskName = request.getParameter("taskName");
        String categoryName = request.getParameter("categoryName");
        String dateStr = request.getParameter("date");
        String userName = request.getParameter("userName");
        String status = request.getParameter("status");
        String memo = request.getParameter("memo");

        TaskBean task = new TaskBean();

        task.setTaskName(taskName);
        task.setCategoryName(categoryName);

        if (dateStr != null && !dateStr.isEmpty()) {
            task.setDate(LocalDate.parse(dateStr));
        }

        task.setUserName(userName);
        task.setStatus(status);
        task.setMemo(memo);

        TaskDAO dao = new TaskDAO();

        try {

            int count = dao.insert(task);

            if (count > 0) {
                RequestDispatcher rd =
                        request.getRequestDispatcher("add-success.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd =
                        request.getRequestDispatcher("add-error.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace();

            RequestDispatcher rd =
                    request.getRequestDispatcher("add-error.jsp");
            rd.forward(request, response);
        }
    }
}