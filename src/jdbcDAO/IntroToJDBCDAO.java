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

        Student stud2 = new Student(4, "Maams");
        Student studArr[] = { stud2 };
        dao.addStudent(studArr);

        if (dao.deleteStudent(7)) {
            System.out.println("Successfully deleted student record");
        } else {
            System.out.println("No student found to delete");
        }

        Student stud3 = new Student(3, "Viraj C");
        Student stud4 = new Student(4, "Nidhi");
        Student stud5 = new Student(6, "Maams");

        Student[] updateStudArr = { stud3, stud4, stud5 };

        if (dao.updateStudentName(updateStudArr)) {
            System.out.println("Successfully updated student record");
        } else {
            System.out.println("No updations");
        }
    }
}
