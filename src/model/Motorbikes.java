package model;

public class Motorbikes extends InfoVehicle {
    private String motorbikeName;
    private String status;
    private String category;
    private int numberOfMotorbike;
    private double motorbikePrice;

    public Motorbikes() {
    }

    public Motorbikes(String vehicleId, String automaker, int yearOfProduction, String motorbikeName, String status, String category, int numberOfMotorbike, double motorbikePrice) {
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

    public double getMotorbikePrice() {
        return motorbikePrice;
    }

    public void setMotorbikePrice(double motorbikePrice) {
        this.motorbikePrice = motorbikePrice;
    }
}
