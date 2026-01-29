package jdbcdao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public Student getStudent(int rollno) {
        Student stud = new Student();

        String getStudentQuery = "select * from students where rollno=" + rollno;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/studentDB";
            String user = "pranaavbv";
            String password = "pranaavBV";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(getStudentQuery);

            if (rs.next()) {
                stud.setRollno(rs.getInt("rollno"));
                stud.setSname(rs.getString("sname"));
            } else {
                System.out.println("No Student found for the roll number: " + rollno);

                throw new Exception("No Student found for the roll number: " + rollno);
            }

            return stud;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }
}
