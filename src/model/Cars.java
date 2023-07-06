package model;

public class Cars extends InfoVehicle {
    private String carName;
    private String status;
    private String category;
    private int numberOfCar;
    private Long carPrice;

    public Cars() {
    }

    public Cars(String vehicleId, String automaker, int yearOfProduction, String carName, String status, String category, int numberOfCar, Long carPrice) {
        super(vehicleId, automaker, yearOfProduction);
        this.carName = carName;
        this.status = status;
        this.category = category;
        this.numberOfCar = numberOfCar;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public Long getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Long carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "ID phương tiện: " + super.getVehicleId() + "\n" +
                "Hãng Xe: " + super.getAutomaker() + "\n" +
                "Tên Phương Tiện: " + this.getCarName() + "\n" +
                "Trạng Thái Xe: " + this.getStatus() + "\n" +
                "Loại Xe: " + this.getCategory() + "\n" +
                "Năm Sản Xuất: " + super.getYearOfProduction() + "\n" +
                "Số Lượng: " + this.getNumberOfCar() + "\n" +
                "Giá: " + this.getCarPrice()+"VNĐ";
    }
}