package management.manager;

import readAndWriteFile.RAWMotorbike;
import management.iManagement.VehicleManager;
import model.Motorbikes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeManage implements VehicleManager<Motorbikes> {
    private List<Motorbikes> motorbikesList = null;
    private RAWMotorbike rawMotorbike = new RAWMotorbike();

    public MotorbikeManage() {
        try {
            this.motorbikesList = this.rawMotorbike.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Motorbikes motorbikes) {
        try {
            this.motorbikesList.add(motorbikes);
            this.rawMotorbike.writerFile(motorbikesList);
            System.out.println("Thêm phương tiện mới thành công ^_^");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Motorbikes motorbikes) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.motorbikesList.set(index, motorbikes);
                this.rawMotorbike.writerFile(motorbikesList);
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
                this.motorbikesList.remove(index);
                this.rawMotorbike.writerFile(motorbikesList);
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
        for (int i = 0; i < this.motorbikesList.size(); i++) {
            if (id.equals(this.motorbikesList.get(i).getVehicleId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Motorbikes> showAll() {
        try {
            return this.rawMotorbike.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Motorbikes> findByName(String name) {
        List<Motorbikes> list = new ArrayList<>();
        for (Motorbikes motorbikes : motorbikesList) {
            if (motorbikes.getMotorbikeName().toLowerCase().contains(name.toLowerCase())) {
                list.add(motorbikes);
            }
        }
        return list;
    }
}
