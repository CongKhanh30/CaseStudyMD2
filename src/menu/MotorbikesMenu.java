package menu;

import check.Check;
import management.manager.MotorbikeManage;
import model.Motorbikes;

import java.util.List;
import java.util.Scanner;

public class MotorbikesMenu {
    private MotorbikeManage motorbikeManage = new MotorbikeManage();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void motorbikesMenu() {
        int choice = -1;
        do {
            String str = "^.^ ^_^ Quản Lý Xe Máy ^_^ ^.^\n" +
                    "1. Thêm Xe Máy\n" +
                    "2. Sửa Thông Tin Xe Máy\n" +
                    "3. Xóa Xe Máy\n" +
                    "4. Tìm Kiếm Xe Máy\n" +
                    "5. Hiển Thị Xe Máy\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    editMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    findMenu();
                    break;
                case 5:
                    showAllVehicle();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 0);
    }

    private void addMenu() {
        System.out.println("^_^ ^_^ Thêm Xe Máy ^_^ ^_^");
        String vehicleID;
        while (true) {
            String regex = "^motor\\d+$";
            String str = "Nhâp Id Phương Tiện: ";
            vehicleID = check.checkRegex(str, regex);
            if (motorbikeManage.findIndexById(vehicleID) == -1) {
                break;
            }
            System.out.println("Id Ô Tô Đã Tồn Tại !");
        }

        System.out.print("Nhập Hãng Xe: ");
        String automaker = input.nextLine();

        String str1 = "Năm Sản Xuất: ";
        System.out.print(str1);
        int yearOfProduction = check.checkInputNumber(str1);

        System.out.print("Nhập Tên Xe: ");
        String motorbikeName = input.nextLine();

        System.out.print("Tình Trạng Xe: ");
        String status = input.nextLine();

        System.out.print("Loại Xe: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Lượng Xe: ";
        System.out.print(str2);
        int numberOfMotorbike = check.checkInputNumber(str2);

        String str3 = "Giá Xe: ";
        System.out.print(str3);
        long motorbikePrice = check.checkInputNumber(str3);

        Motorbikes motorbikes = new Motorbikes(vehicleID, automaker, yearOfProduction, motorbikeName, status, category, numberOfMotorbike, motorbikePrice);
        motorbikeManage.add(motorbikes);

        System.out.println("-------------");
    }

    private void editMenu() {
        System.out.println("^_^ ^_^ Sửa Thông Tin Xe Máy ^_^ ^_^");
        String regex = "^motor\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        if (motorbikeManage.findIndexById(vehicleID) == -1) {
            System.out.println("Id Bạn Nhập Không Tồn Tại. Mời Nhập Lại");
        } else {
            System.out.print("Nhập Hãng Xe: ");
            String automaker = input.nextLine();

            String str1 = "Năm Sản Xuất: ";
            System.out.print(str1);
            int yearOfProduction = check.checkInputNumber(str1);

            System.out.print("Nhập Tên Xe: ");
            String motorbikeName = input.nextLine();

            System.out.print("Tình Trạng Xe: ");
            String status = input.nextLine();

            System.out.print("Loại Xe: ");
            String category = input.nextLine();

            String str2 = "Nhập Số Lượng Xe: ";
            System.out.print(str2);
            int numberOfMotorbike = check.checkInputNumber(str2);

            String str3 = "Giá Xe: ";
            System.out.print(str3);
            long motorbikePrice = check.checkInputNumber(str3);

            Motorbikes motorbikes = new Motorbikes(vehicleID, automaker, yearOfProduction, motorbikeName, status, category, numberOfMotorbike, motorbikePrice);
            motorbikeManage.edit(vehicleID, motorbikes);

            System.out.println("------------");
        }
    }

    private void deleteMenu() {
        System.out.println("^_^ ^_^ Xóa Xe Máy ^_^ ^_^");
        String regex = "^motor\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        motorbikeManage.delete(vehicleID);

        System.out.println("**************");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = "^_^ ^_^ Tìm Xe Máy ^_^ ^_^\n" +
                    "1. Tìm Phương Tiện Theo Id\n" +
                    "2. Tìm Phương Tiện Theo Tên\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    findById();
                    break;
                case 2:
                    findByName();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 0);
    }

    private void findById() {
        System.out.println("^_^ ^_^ Tìm Phương Tiện Theo Id ^_^ ^_^");
        String regex = "^motor\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        System.out.println("----------");
        int index = motorbikeManage.findIndexById(vehicleID);
        if (index != -1) {
            System.out.println(motorbikeManage.showAll().get(index).toString());

            System.out.println("-----------");
        } else {
            System.out.println("Không Tìm Thấy Phương Tiện !!!");

            System.out.println("------------");
        }
    }

    private void findByName() {
        System.out.println("^_^ ^_^ Tìm Phương Tiện Theo Tên ^_^ ^_^");
        System.out.print("Nhập Tên Phương Tiện: ");
        String carName = input.nextLine();
        System.out.println("----------");
        List<Motorbikes> list = motorbikeManage.findByName(carName);
        if (list.size() != 0) {
            for (Motorbikes motorbikes : list) {
                System.out.println(motorbikes.toString());
                System.out.println("**********");
            }
        } else {
            System.out.println("Không Tìm Thấy Phương Tiện !!!");

            System.out.println("------------");
        }
    }

    private void showAllVehicle() {
        System.out.println("^_^ ^_^ Danh Sách Phương Tiện ^_^ ^_^");
        for (Motorbikes motorbikes : motorbikeManage.showAll()) {
            System.out.println(motorbikes.toString());
            System.out.println("**********");
        }
        System.out.println("-------------");
    }
}