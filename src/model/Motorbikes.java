package model;

public class Motorbikes extends InfoVehicle {
    private String motorbikeName;
    private String status;
    private String category;
    private int numberOfMotorbike;
    private Long motorbikePrice;

    public Motorbikes() {
    }

    public Motorbikes(String vehicleId, String automaker, int yearOfProduction, String motorbikeName, String status, String category, int numberOfMotorbike, Long motorbikePrice) {
        super(vehicleId, automaker, yearOfProduction);
        this.motorbikeName = motorbikeName;
        this.status = status;
        this.category = category;
        this.numberOfMotorbike = numberOfMotorbike;
        this.motorbikePrice = motorbikePrice;
    }

    public String getMotorbikeName() {
        return motorbikeName;
    }

    public void setMotorbikeName(String motorbikeName) {
        this.motorbikeName = motorbikeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberOfMotorbike() {
        return numberOfMotorbike;
    }

    public void setNumberOfMotorbike(int numberOfMotorbike) {
        this.numberOfMotorbike = numberOfMotorbike;
    }

    public Long getMotorbikePrice() {
        return motorbikePrice;
    }

    public void setMotorbikePrice(Long motorbikePrice) {
        this.motorbikePrice = motorbikePrice;
    }

    @Override
    public String toString() {
        return "ID phương tiện: " + super.getVehicleId() + "\n" +
                "Hãng Xe: " + super.getAutomaker() + "\n" +
                "Tên Phương Tiện: " + this.getMotorbikeName() + "\n" +
                "Trạng Thái Xe: " + this.getStatus() + "\n" +
                "Loại Xe: " + this.getCategory() + "\n" +
                "Năm Sản Xuất: " + super.getYearOfProduction() + "\n" +
                "Số Lượng: " + this.getNumberOfMotorbike() + "\n" +
                "Giá: " + this.getMotorbikePrice()+"VNĐ";
    }
}
