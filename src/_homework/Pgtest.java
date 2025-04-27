package _homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pgtest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "745312";

		String query = "SELECT id, name, email FROM employee";
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("成功連接資料庫！");

			// 建立 PreparedStatement 並執行查詢
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			// 讀取資料
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");

				System.out.println("ID: " + id + ", 姓名: " + name + ", 電子郵件: " + email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
	}

}
