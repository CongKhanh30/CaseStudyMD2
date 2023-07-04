package entity;

import java.time.LocalDate;


public abstract class Employee {
    private static int employeeCount = 0;
    protected int id;
    protected String fullName;
    protected LocalDate birthday;
    protected String phone;
    protected String email;

    protected int employeeType;
    public Employee(){}

    public Employee(int id, String fullName, LocalDate birthday, String phone, String email, int employeeType) {
        this.id = ++ employeeCount;
        this.fullName = fullName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
    }

    public abstract void showInfo();

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }
}
