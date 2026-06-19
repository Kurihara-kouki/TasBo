package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

class TaskDAOTest extends TaskDAO {

	@Test
	void test_selectAll_成功() {

		//DAO(テスト対象)のインスタンス化
		TaskDAO dao = new TaskDAO();

		//リストの宣言
		List<TaskBean> taskList = null;

		//メソッド使用
		try {
			taskList = dao.selectAll();

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//assert
		assertNotNull(taskList);
	}
	
	@Test
	void test_delete_成功() throws Exception {
		
		//DAO(テスト対象)のインスタンス化
		TaskDAO dao = new TaskDAO();
		
		//TaskBeanのインスタンス化
		TaskBean task = new TaskBean();
		
		//タスク名の宣言
		String taskName = "JUnitテスト用タスク登録" ;
		int categoryId = 1;
		String userId = "admin";
		String statusCode = "00";
		
		//タスクIDの宣言
		int taskId = 0;
		
		//結果用の変数を宣言
		int resultCount = 0;
		
		//テスト用の値をセット
		task.setTaskName(taskName);	
		task.setCategoryId(categoryId);
		task.setUserId(userId);
		task.setStatusCode(statusCode);
	
		//登録のメソッドを使用
		dao.insert(task);
		
		//SQL文の用意
		String sql = "select task_id from t_task where task_name = ?";

		//DB接続
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//プレースホルダに値をセット
			pstmt.setString(1, taskName);
			
			//実行
			ResultSet res = pstmt.executeQuery();
				
			//ループ開始
			if (res.next()) {
					
				//結果のタスクIDを変数にセット
				taskId = res.getInt("task_id");
			}			
		}
			
		//削除のメソッドを使用し結果を取得
		resultCount = dao.delete(taskId);
		
		assertEquals(1, resultCount);
		
	}
	
	   @Test
	    void test_insert_成功() throws Exception {

	        // DAOのインスタンス化
	        TaskDAO dao = new TaskDAO();
	        
	    	//タスク名の宣言
	      //タスク名の宣言
			String taskName = "JUnitテスト用タスク登録" ;
			int categoryId = 1;
			String userId = "1";
			String statusCode = "1";
			int taskId = 1;

	        // テストデータ作成
	        TaskBean task = new TaskBean();
	        task.setTaskName(taskName);
	        task.setCategoryId(categoryId);
	        task.setLimitDate(LocalDate.of(2026, 12, 31));
	        task.setUserId(userId);
	        task.setStatusCode(statusCode);
	        task.setMemo("テスト用データ");
	        
	        //TaskIdの宣言
	        task.setTaskId(taskId);

	        // 実行
	        int result = dao.insert(task);
	        
	        // 検証
	        assertEquals(1, result);
	

	      //SQL文の用意
			String sql = "select task_id from t_task where task_name = ?";

			//DB接続
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				//プレースホルダに値をセット
				pstmt.setString(1, taskName);
				
				//実行
				ResultSet res = pstmt.executeQuery();
					
				//ループ開始
				if (res.next()) {
						
					//結果のタスクIDを変数にセット
					taskId = res.getInt("task_id");
				}			
			}
				
			//削除のメソッドを使用し結果を取得
			dao.delete(taskId);

	        
	    }
}
