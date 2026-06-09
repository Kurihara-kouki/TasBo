package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {
	public List<TaskBean> selectAll() throws ClassNotFoundException, SQLException {
		
		//返すList作成
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t3.user_name,t4.status_name,t1.memo FROM t_task t1 JOIN m_category t2 ON t1.category_id = t2.category_id JOIN m_user t3 ON t1.user_id = t3.user_id JOIN m_status t4 ON t1.status_code = t4.status_code ORDER BY t1.task_id ASC";
		
		try (Connection con = ConnectionManager.getConnection();
			//Connectionクラスが持つcreateStatementメソッド
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql)){
			
			while(res.next()) {
				TaskBean taskBean = new TaskBean();
				
				taskBean.setTaskId(res.getInt("task_id"));
				taskBean.setTaskName(res.getString("task_name"));
				taskBean.setCategoryName(res.getString("category_name"));
				taskBean.setLimitDate(res.getDate("limit_date").toLocalDate());
				taskBean.setUserName(res.getString("user_name"));
				taskBean.setStatusName(res.getString("status_name"));
				taskBean.setMemo(res.getString("memo"));
				
				taskList.add(taskBean);
			}
			
		}
		return taskList;
	}
}
