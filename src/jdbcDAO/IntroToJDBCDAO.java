package jdbcdao;

import jdbcdao.dao.Student;
import jdbcdao.dao.StudentDAO;

public class IntroToJDBCDAO {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student stud = new Student();
        stud = dao.getStudent(2);

        if (stud == null) {
            System.out.println("Rollno is invalid");
        } else {
            System.out.println(stud.getSname());
        }
    }
}
