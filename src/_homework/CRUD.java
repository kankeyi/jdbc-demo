package _homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "745312";

		String query = "SELECT id, name, email FROM employee";
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		boolean exit = false;

		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("成功連接資料庫！");

			System.out.println("請輸入一個字母 (C, R, U, D, E)：");

			Scanner scanner = new Scanner(System.in);

			String input = scanner.nextLine().trim().toUpperCase(); // 忽略大小寫

			while (!exit) {
				System.out.print("請輸入操作指令：");
				System.out.println("-----------------");
				String command = scanner.nextLine();

				switch (input) {
				case "C":
					optionC();
					break;
				case "R":
					optionR();
					break;
//	            case "U":
//	                optionU();
//	                break;
//	            case "D":
//	                optionD();
//	                break;
//	            case "E":
//	                optionE();
//	                break;
				default:
					System.out.println("無效輸入，請輸入 A、B、C、D 或 E。");

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
			} catch (Exception e) {
			}
		}
	}

	private static void optionC() throws SQLException {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "745312";
		Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入名字：");
		String name = scanner.nextLine();

		System.out.print("請輸入Email：");
		String email = scanner.nextLine();

		System.out.print("請輸入ID：");
		String user_id = scanner.nextLine();

		String sql = "INSERT INTO employee (name, email ,user_id) VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, user_id);
		
//		INSERT INTO public.employee
//		(id, "name", user_id, email, age, salary, description, created_by, created_date)
//		VALUES(0, '大壯', 'A123456789', 'a7654321@gmail.com', '25', 0, '大壯的資料', '我', '2025-04-13 00:00:00.000');
//		instant
//		setTimestep ()

		int rowsInserted = pstmt.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("成功新增一筆資料！");
		}
	}

	private static void optionR() throws SQLException {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "745312";
		Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		PreparedStatement statement = conn.prepareStatement("select * from employee");
		ResultSet resultSet = statement.executeQuery();
//		System.out.print("""
//				name | email | user_id
//				""");
		while (resultSet.next()) {
			System.out.print(resultSet.getString("name") + " | ");
			System.out.print(resultSet.getString("email") + " | ");
			System.out.println(resultSet.getString("user_id"));
		}
	}

}
