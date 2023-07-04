package entity;

import java.time.LocalDate;

public class Fresher extends Employee {

    private LocalDate graduationDate;
    private String graduationRank;
    private String trainingPlaces;

    public Fresher(){}

    public Fresher(LocalDate graduationDate, String graduationRank, String trainingPlaces) {\
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.trainingPlaces = trainingPlaces;
    }

    public Fresher(int id, String fullName, LocalDate birthday, String phone, String email, int employeeType, LocalDate graduationDate, String graduationRank, String trainingPlaces) {
        super(id, fullName, birthday, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.trainingPlaces = trainingPlaces;
    }

    @Override
    public void showInfo() {

    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getTrainingPlaces() {
        return trainingPlaces;
    }

    public void setTrainingPlaces(String trainingPlaces) {
        this.trainingPlaces = trainingPlaces;
    }

    @Override
    public String toString() {
        return "Fresher: " +
                ", Id: " + id +
                ", Họ và tên: " + fullName + '\'' +
                ", Ngày sinh: " + birthday +
                ", Số điện thoại: " + phone + '\'' +
                ", Email: " + email + '\'' +
                ", Ngày tốt nghiệp: " + graduationDate +
                ", Tốt nghiệp loại: " + graduationRank + '\'' +
                ", Nơi đào tạo: " + trainingPlaces + '\'';
    }
}
