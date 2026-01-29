package jdbcdao;

import jdbcdao.dao.Student;
import jdbcdao.dao.StudentDAO;

public class IntroToJDBCDAO {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student stud1 = new Student();
        stud1 = dao.getStudent(2);

        if (stud1 == null) {
            System.out.println("Rollno is invalid");
        } else {
            System.out.println(stud1.getSname());
        }

        Student stud2 = new Student(7, "Tushar");
        Student studArr[] = { stud2 };
        dao.addStudent(studArr);
    }
}
