package jdbcdao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void addStudent(Student stud[]) {
        // int rollno = stud.getRollno();
        // String sname = stud.getSname();
        // String insertStudentQuery = "insert into students values ("+rollno+",
        // '"+sname+"')";
        String insertStudentQuery = "insert into students values (?,?)";
        int count = 0;

        try {
            connect();

            PreparedStatement prepSt = con.prepareStatement(insertStudentQuery);

            int i = 0;
            while (i < stud.length) {
                prepSt.setInt(1, stud[i].getRollno());
                prepSt.setString(2, stud[i].getSname());
                prepSt.addBatch();

                i++;
            }

            int result[] = prepSt.executeBatch();

            count = result.length;
        } catch (Exception e) {
            System.out.println(e);
        }

        if (count > 0) {
            System.out.println(count + " student record(s) added successfully");
        } else {
            System.out.println("Error in added student record(s)");
        }
    }

    public boolean deleteStudent(int rollno) {

        String sql = "DELETE FROM students WHERE rollno = ?";

        try {
            connect();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, rollno);
            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete student with rollno " + rollno, e);
        }
    }

    public boolean updateStudentName(Student[] students) {
        if (students == null || students.length == 0) {
            return false;
        }

        String sql = "UPDATE students SET sname=? WHERE rollno=?";

        try {
            connect();

            try (PreparedStatement pst = con.prepareStatement(sql)) {

                for (Student s : students) {
                    pst.setString(1, s.getSname());
                    pst.setInt(2, s.getRollno());
                    pst.addBatch();
                }

                int[] affectedRows = pst.executeBatch();

                int totalUpdated = 0;
                for (int count : affectedRows) {
                    if (count > 0) {
                        totalUpdated += count;
                    }
                }

                return totalUpdated > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update student(s)", e);
        }
    }
}
