package entity;

import java.time.LocalDate;

public class Intern extends Employee {

    private String majors;
    private int schoolYear;
    private String universityName;
     public Intern(){}

    public Intern(String majors, int schoolYear, String universityName) {
        this.majors = majors;
        this.schoolYear = schoolYear;
        this.universityName = universityName;
    }

    public Intern(int id, String fullName, LocalDate birthday, String phone, String email, int employeeType, String majors, int schoolYear, String universityName) {
        super(id, fullName, birthday, phone, email, employeeType);
        this.majors = majors;
        this.schoolYear = schoolYear;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {

    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern: " +
                ", ID: " + id +
                ", Họ và tên: " + fullName + '\'' +
                ", Ngày sinh: " + birthday +
                ", Số điện thoại: " + phone + '\'' +
                ", Email: " + email + '\'' +
                ", Chuyên ngành: " + majors + '\'' +
                ", Năm học: " + schoolYear +
                ", Đại học: " + universityName + '\'';
    }
}
