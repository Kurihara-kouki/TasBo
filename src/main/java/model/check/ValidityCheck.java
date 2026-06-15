package model.check;

public class ValidityCheck {
	
	/**
	 * ユーザID、パスワードの長さをチェックするメソッド
	 * @param userId
	 * @param password
	 * @return
	 * @throws NullPointerException
	 */
	public static boolean userValidityCheck(String userId,String password) throws NullPointerException {

		if (userId.length() <= 24 && password.length() <= 32 && userId != "" && password != "") {

			return true;

		} else {

			return false;

		}

	}

}
