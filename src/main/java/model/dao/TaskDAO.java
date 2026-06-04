package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.TaskBean;

public class TaskDAO {

	public int insert(TaskBean task) throws Exception {

		
		//SQL文を作成
		String sql = "INSERT INTO t_task " +
				"(task_name, category_id, limit_date, user_id, status_code, memo) " +
				"VALUES (?, ?, ?, ?, ?, ?)";

		
		try (
				//DB接続とPreparedStatementの作成
				Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SQLのパラメータ設定
			pstmt.setString(1, task.getTaskName());
			pstmt.setInt(2, 1);

			if (task.getDate() != null) {
				pstmt.setDate(3,
						java.sql.Date.valueOf(task.getDate()));
			} else {
				pstmt.setDate(3, null);
			}

			pstmt.setInt(4, 1);
			pstmt.setInt(5, 1);
			pstmt.setString(6, task.getMemo());

			return pstmt.executeUpdate();
		}
	}
}