package model;

public class Customer {
    private String customerId;
    private String fullName;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String customerId, String fullName, String phone, String address) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID Khách Hàng: " + this.getCustomerId() + "\n" +
                "Họ Và Tên: " + this.getFullName() + "\n" +
                "Số Điện Thoại: " + this.getPhone() + "\n" +
                "Địa Chỉ: " + this.getAddress();
    }
}