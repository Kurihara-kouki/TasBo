package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
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

}
