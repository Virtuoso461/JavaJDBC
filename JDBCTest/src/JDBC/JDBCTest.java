package JDBC;
import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("驱动设置错误");
        }try {
            Connection con = DriverManager.getConnection(url, "root", "13579");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT stuNum, stuName, stuAge FROM student");

            while (rs.next()) {
                String stuNum = rs.getString("stuNum");
                String stuName = rs.getString("stuName");
                int stuAge = rs.getInt("stuAge");
                System.out.println(stuNum+"\t"+stuName+"\t"+stuAge);

            }
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
