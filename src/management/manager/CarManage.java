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

    public CarManage() {
        try {
            this.carsList = this.rawCar.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Cars cars) {
        try {
            this.carsList.add(cars);
            this.rawCar.writerFile(carsList);
            System.out.println("Thêm phương tiện mới thành công ^_^");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Cars cars) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.carsList.set(index, cars);
                this.rawCar.writerFile(carsList);
                System.out.println("Sửa thông tin phương tiện thành công ^-^");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID bạn nhập chưa tồn tại trên hệ thống. Mời nhập lại 0.0");
        }
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.carsList.remove(index);
                this.rawCar.writerFile(carsList);
                System.out.println("Xóa phương tiện thành công ^^");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID bạn nhập chưa tồn tại trên hệ thống. Mời nhập lại 0.0");
        }

    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < this.carsList.size(); i++) {
            if (id.equals(this.carsList.get(i).getVehicleId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Cars> showAll() {
        try {
            return this.rawCar.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cars> findByName(String name) {
        List<Cars> list = new ArrayList<>();
        for (Cars cars : carsList) {
            if (cars.getCarName().toLowerCase().contains(name.toLowerCase())) {
                list.add(cars);
            }
        }
        return list;
    }

}
