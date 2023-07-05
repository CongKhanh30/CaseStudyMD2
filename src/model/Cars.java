package model;

public class Cars extends InfoVehicle {
    private String carName;
    private String status;
    private String category;
    private int numberOfCar;
    private double carPrice;

    public Cars() {
    }

    public Cars(String vehicleId, String automaker, int yearOfProduction, String carName, String status, String category, int numberOfCar, double carPrice) {
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

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }
}