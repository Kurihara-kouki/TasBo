package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.TaskBean;

public class TaskDAO {

	public int insert(TaskBean task) throws Exception {

		//SQL文の作成
	    String sql =
	        "INSERT INTO t_task " +
	        "(task_name, category_id, limit_date, user_id, status_code, memo) " +
	        "VALUES (?, ?, ?, ?, ?, ?)";

	    try (
	    	//DB接続とPreparedStatement生成
	        Connection con = ConnectionManager.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(sql)) {

	    	//タスク名をセット
	        pstmt.setString(1, task.getTaskName());

	        //カテゴリIDをセット
	        pstmt.setInt(2, 111);

	        //期限日をセット
	        if (task.getDate() != null) {
	            pstmt.setDate(3, java.sql.Date.valueOf(task.getDate()));
	        } else {
	            pstmt.setNull(3, java.sql.Types.DATE);
	        }

	        //ユーザーIDをセット
	        pstmt.setString(4, "1");
	        //ステータスコードをセット
	        pstmt.setString(5, "1");

	        //メモをセット
	        pstmt.setString(6, task.getMemo());

	        //SQL実行
	        return pstmt.executeUpdate();
	    }
	
	}
}