package jdbcdao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    Connection con = null;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/studentDB";
            String user = "pranaavbv";
            String password = "pranaavBV";

            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Student getStudent(int rollno) {
        Student stud = new Student();

        String getStudentQuery = "select * from students where rollno=" + rollno;

        try {
            connect();
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

    public void addStudent(Student stud) {
        int rollno = stud.getRollno();
        String sname = stud.getSname();
        // String insertStudentQuery = "insert into students values ("+rollno+",
        // '"+sname+"')";
        String insertStudentQuery = "insert into students values (?,?)";
        int count = 0;

        try {
            connect();

            PreparedStatement prepSt = con.prepareStatement(insertStudentQuery);
            prepSt.setInt(1, rollno);
            prepSt.setString(2, sname);

            count = prepSt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        if (count == 1) {
            System.out.println("Student record added successfully");
        } else {
            System.out.println("Error in added student record");
        }
    }
}
