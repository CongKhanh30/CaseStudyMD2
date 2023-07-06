package model;


public class Bill {
    private String billID;
    private String customerId;
    private String vehicleId;
    private String date;
    private Long total;

    public Bill() {
    }

    public Bill(String billID, String customerId, String vehicleId, String date, Long total) {
        this.billID = billID;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.date = date;
        this.total = total;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Mã Hóa Đơn: " + getBillID() + "\n" +
                "Id Khách Hàng: " + getCustomerId() + "\n" +
                "Id Phương Tiện: " + getVehicleId() + "\n" +
                "Ngày Mua: " + getDate() + "\n" +
                "Tổng Tiền: " + getTotal() + "VNĐ";
    }
}