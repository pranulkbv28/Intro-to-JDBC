package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IntroToJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/studentDB";
            String user = "pranaavbv";
            String password = "pranaavBV";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to db");

            Statement st = con.createStatement();

            String getAllStudentsQuery = "select * from students";

            ResultSet rs = st.executeQuery(getAllStudentsQuery);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            String insertStudentQuery = "insert into students values (?,?)";

            PreparedStatement prepSt = con.prepareStatement(insertStudentQuery);

            prepSt.setInt(1, 5);
            prepSt.setString(2, "AK");
            prepSt.addBatch();

            prepSt.setInt(1, 6);
            prepSt.setString(2, "Nidhi");
            prepSt.addBatch();

            int result[] = prepSt.executeBatch();

            System.out.println(result.length + " row(s) affected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
