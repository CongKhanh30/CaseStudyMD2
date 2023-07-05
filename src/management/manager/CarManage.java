package management.manager;

import readAndWriteFile.RAWCar;
import management.interfaceManagement.VehicleManager;
import model.Cars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CarManage implements VehicleManager<Cars> {
    private List<Cars> carsList = null;
    private RAWCar rawCar = new RAWCar();
    public CarManage(){
        try {
            this.carsList = this.rawCar.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Cars cars) {

    }

    @Override
    public void edit(String id, Cars cars) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public int findIndexById(String id) {
        return 0;
    }

    @Override
    public List<Cars> showAll() {
        return null;
    }

    @Override
    public List<Cars> findByName(String name) {
        return null;
    }
}
