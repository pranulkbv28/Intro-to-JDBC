package jdbcdao.dao;

public class Student {
    private int rollno;
    private String sname;

    public Student() {

    }

    public Student(int rollno, String sname) {
        this.rollno = rollno;
        this.sname = sname;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

}
