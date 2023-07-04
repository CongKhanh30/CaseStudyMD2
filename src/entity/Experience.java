package entity;

import java.time.LocalDate;

public class Experience extends Employee {
    private int expInYear;
    private String skill;

    public Experience(){}

    public Experience(int expInYear, String skill) {
        this.expInYear = expInYear;
        this.skill = skill;
    }

    public Experience(int id, String fullName, LocalDate birthday, String phone, String email, int employeeType, int expInYear, String skill) {
        super(id, fullName, birthday, phone, email, employeeType);
        this.expInYear = expInYear;
        this.skill = skill;
    }

    @Override
    public void showInfo() {

    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Nhân viên lâu năm: " +
                ", Id: " + id +
                ", Họ và tên: " + fullName + '\'' +
                ", Ngày sinh: " + birthday +
                ", Số điện thoại: " + phone + '\'' +
                ", Email: " + email + '\'' +
                ", Năm kinh nghiệm: " + expInYear +
                ", Kỹ năng: " + skill + '\'';
    }
}
