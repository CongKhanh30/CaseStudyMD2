package menu;

import check.Check;
import management.manager.CarManage;
import model.Cars;

import java.util.List;
import java.util.Scanner;

public class CarsMenu {
    private CarManage carManage = new CarManage();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void carsMenu() {
        int choice = -1;
        do {
            String str = "^.^ ^_^ Quản Lý Ô Tô ^_^ ^.^\n" +
                    "1. Thêm Ô Tô\n" +
                    "2. Sửa Thông Tin Ô Tô\n" +
                    "3. Xóa Ô Tô\n" +
                    "4. Tìm Kiếm Ô Tô\n" +
                    "5. Hiển Thị Ô Tô\n" +
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
        System.out.println("^_^ ^_^ Thêm Ô Tô ^_^ ^_^");
        String vehicleID;
        while (true) {
            String regex = "^car\\d+$";
            String str = "Nhâp Id Phương Tiện: ";
            vehicleID = check.checkRegex(str, regex);
            if (carManage.findIndexById(vehicleID) == -1) {
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
        String carName = input.nextLine();

        System.out.print("Tình Trạng Xe: ");
        String status = input.nextLine();

        System.out.print("Loại Xe: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Lượng Xe: ";
        System.out.print(str2);
        int numberOfCar = check.checkInputNumber(str2);

        String str3 = "Giá Xe: ";
        System.out.print(str3);
        long carPrice = check.checkInputNumber(str3);

        Cars cars = new Cars(vehicleID, automaker, yearOfProduction, carName, status, category, numberOfCar, carPrice);
        carManage.add(cars);

        System.out.println("-------------");
    }

    private void editMenu() {
        System.out.println("^_^ ^_^ Sửa Thông Tin Ô Tô ^_^ ^_^");
        String regex = "^car\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        if (carManage.findIndexById(vehicleID) == -1) {
            System.out.println("Id Bạn Nhập Không Tồn Tại. Mời Nhập Lại");
        } else {
            System.out.print("Nhập Hãng Xe: ");
            String automaker = input.nextLine();

            String str1 = "Năm Sản Xuất: ";
            System.out.print(str1);
            int yearOfProduction = check.checkInputNumber(str1);

            System.out.print("Nhập Tên Xe: ");
            String carName = input.nextLine();

            System.out.print("Tình Trạng Xe: ");
            String status = input.nextLine();

            System.out.print("Loại Xe: ");
            String category = input.nextLine();

            String str2 = "Nhập Số Lượng Xe: ";
            System.out.print(str2);
            int numberOfCar = check.checkInputNumber(str2);

            String str3 = "Giá Xe: ";
            System.out.print(str3);
            long carPrice = check.checkInputNumber(str3);

            Cars cars = new Cars(vehicleID, automaker, yearOfProduction, carName, status, category, numberOfCar, carPrice);
            carManage.edit(vehicleID, cars);

            System.out.println("------------");
        }
    }

    private void deleteMenu() {
        System.out.println("^_^ ^_^ Xóa Ô Tô ^_^ ^_^");
        String regex = "^car\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        carManage.delete(vehicleID);

        System.out.println("**************");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = "^_^ ^_^ Tìm Ô Tô ^_^ ^_^\n" +
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
        String regex = "^car\\d+$";
        String str = "Nhâp Id Phương Tiện: ";
        String vehicleID = check.checkRegex(str, regex);
        System.out.println("----------");
        int index = carManage.findIndexById(vehicleID);
        if (index != -1) {
            System.out.println(carManage.showAll().get(index).toString());

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
        List<Cars> list = carManage.findByName(carName);
        if (list.size() != 0) {
            for (Cars cars : list) {
                System.out.println(cars.toString());
                System.out.println("**********");
            }
        } else {
            System.out.println("Không Tìm Thấy Phương Tiện !!!");

            System.out.println("------------");
        }
    }

    private void showAllVehicle() {
        System.out.println("^_^ ^_^ Danh Sách Phương Tiện ^_^ ^_^");
        for (Cars cars : carManage.showAll()) {
            System.out.println(cars.toString());
            System.out.println("**********");
        }
        System.out.println("-------------");
    }
}