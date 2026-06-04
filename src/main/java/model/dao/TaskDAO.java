package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.TaskBean;

public class TaskDAO {

	public int insert(TaskBean task) {

	    int count = 0;

	    String sql =
	        "INSERT INTO task(task_name, category_name, date, user_name, status, memo) "
	      + "VALUES(?, ?, ?, ?, ?, ?)";

	    try (
	        Connection con = ConnectionManager.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql)
	    ) {

	        pstmt.setString(1, task.getTaskName());
	        pstmt.setString(2, task.getCategoryName());
	        pstmt.setString(3, task.getDate());
	        pstmt.setString(4, task.getUserName());
	        pstmt.setString(5, task.getStatus());
	        pstmt.setString(6, task.getMemo());

	        count = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
}