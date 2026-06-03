package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TaskDAO {

    public int insert(String taskName,
                      String categoryName,
                      String date,
                      String userName,
                      String status,
                      String memo) {

        int count = 0;

        String sql =
            "INSERT INTO task(task_name, category_name, date, user_name, status, memo) "
            + "VALUES(?, ?, ?, ?, ?, ?)";

        try (
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)
        ) {

            pstmt.setString(1, taskName);
            pstmt.setString(2, categoryName);
            pstmt.setString(3, date);
            pstmt.setString(4, userName);
            pstmt.setString(5, status);
            pstmt.setString(6, memo);

            count = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}