package model;

public class InfoVehicle {
    private String vehicleId;
    private String automaker;
    private int yearOfProduction;

    public InfoVehicle() {
    }

    public InfoVehicle(String vehicleId, String automaker, int yearOfProduction) {
        this.vehicleId = vehicleId;
        this.automaker = automaker;
        this.yearOfProduction = yearOfProduction;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getAutomaker() {
        return automaker;
    }

    public void setAutomaker(String automaker) {
        this.automaker = automaker;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}