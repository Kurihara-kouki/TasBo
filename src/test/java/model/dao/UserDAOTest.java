package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class  UserDAOTest {

	@Test
	void test_login_成功() {

		//Arrange
		//DAO(テスト対象)のインスタンス化
		UserDAO dao = new UserDAO();

		//値の設定
		String userId = "admin";
		String password = "admin";
		String userName = "admin";
		UserBean bean = null;

		//Act
		//メソッド使用
		try {

			bean = dao.login(userId, password);

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//Assert
		assertNotNull(bean);
		assertEquals(userId, bean.getUserId());
		assertEquals(password, bean.getPassword());
		assertEquals(userName, bean.getUserName());

	}

	@Test
	void test_login_失敗() {

		//Arrange
		//DAO(テスト対象)のインスタンス化
		UserDAO dao = new UserDAO();

		//値の設定
		String userId = "";
		String password = "";
		UserBean bean = null;

		//Act
		//メソッド使用
		try {

			bean = dao.login(userId, password);

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//Assert
		assertNull(bean);

	}

}
