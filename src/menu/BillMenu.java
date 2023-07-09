package menu;

import check.Check;
import consoleColor.ConsoleColor;
import readAndWriteFile.RAWMotorbike;
import readAndWriteFile.RAWCar;
import management.manager.CarManage;
import management.manager.MotorbikeManage;
import management.manager.CustomerManage;
import management.manager.BillManage;
import model.Bill;
import model.Cars;
import model.Motorbikes;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillMenu {
    private BillManage billManage = new BillManage();
    private CarManage carManage = new CarManage();
    private MotorbikeManage motorbikeManage = new MotorbikeManage();
    private CustomerManage customerManage = new CustomerManage();
    private RAWCar rawCar = new RAWCar();
    private RAWMotorbike rawMotorbike = new RAWMotorbike();
    private Check check = new Check();

    public void billMenu() {
        int choice = -1;
        do {
            String str = ConsoleColor.BLACK + ConsoleColor.GREEN_BACKGROUND + "^.^ ^_^ HÓA ĐƠN BÁN PHƯƠNG TIỆN ^.^ ^_^" + ConsoleColor.RESET + "\n" +
                    "1. Thêm Hóa Đơn\n" +
                    "2. Hiển Thị Hóa Đơn\n" +
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
                    showAllBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != -0);
    }

    private void addMenu() {
        System.out.println("^.^ ^_^ Thêm Hóa Đơn ^.^ ^_^");
        String billId;
        while (true) {
            String regex = "^bi\\d+$";
            String str = "Nhâp Id Hóa Đơn: ";
            billId = check.checkRegex(str, regex);
            if (billManage.findIndexById(billId) == -1) {
                break;
            }
            System.out.println("Id Hóa Đơn Đã Tồn Tại.");
        }

        String customerId;
        while (true) {
            String regex = "^cus\\d+$";
            String str = "Nhập Id Khách Hàng: ";
            customerId = check.checkRegex(str, regex);
            if (customerManage.findIndexById(customerId) != -1) {
                break;
            }
            System.out.println("Không Có Id Khách Hàng !!!");
        }

        String detail = "";
        String carID;
        String motorbikeID;
        do {
            while (true) {
                String regexCar = "^car\\d+$";
                String str = "Nhập Id Ô Tô Cần Mua (Nhập car0 Để Thoát Nhập): ";
                carID = check.checkRegex(str, regexCar);
                if (carID.equals("car0")) {
                    break;
                } else if (carManage.findIndexById(carID) != -1) {
                    List<Cars> list = carManage.showAll();
                    if (list.get(carManage.findIndexById(carID)).getNumberOfCar() > 0) {
                        list.get(carManage.findIndexById(carID)).setNumberOfCar(
                                list.get(carManage.findIndexById(carID)).getNumberOfCar() - 1
                        );
                        try {
                            rawCar.writerFile(list);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    } else {
                        System.out.println("Số Lượng Xe Đã Hết. Mời Bạn Chọn Xe Khác ^_^");
                        continue;
                    }
                }
                System.out.println("Không Có Id Phương Tiện Này");
            }
            if (!carID.equals("car0")) {
                detail += carID + " ";
            }
        } while (!carID.equals("car0"));

        do {
            while (true) {
                String regexMotor = "^motor\\d+$";
                String str = "Nhập Id Xe Máy Cần Mua: (Nhập motor0 Để Thoát Nhập): ";
                motorbikeID = check.checkRegex(str, regexMotor);
                if (motorbikeID.equals("motor0")) {
                    break;
                } else if (motorbikeManage.findIndexById(motorbikeID) != -1) {
                    List<Motorbikes> list = motorbikeManage.showAll();
                    if (list.get(motorbikeManage.findIndexById(motorbikeID)).getNumberOfMotorbike() > 0) {
                        list.get(motorbikeManage.findIndexById(motorbikeID)).setNumberOfMotorbike(
                                list.get(motorbikeManage.findIndexById(motorbikeID)).getNumberOfMotorbike() - 1
                        );
                        try {
                            rawMotorbike.writerFile(list);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    } else {
                        System.out.println("Số Lượng Xe Đã Hết. Mời Bạn Chọn Xe Khác ^_^");
                        continue;
                    }
                }
                System.out.println("Không Có Id Phương Tiện Này");
            }
            if (!motorbikeID.equals("motor0")) {
                detail += motorbikeID + " ";
            }
        } while (!motorbikeID.equals("motor0"));

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        long total = 0;
        String[] data = detail.split(" ");
        for (String s : data) {
            if (s.contains("car")) {
                total += carManage.showAll().get(carManage.findIndexById(s)).getCarPrice();
            } else {
                total += motorbikeManage.showAll().get(motorbikeManage.findIndexById(s)).getMotorbikePrice();
            }
        }

        Bill bill = new Bill(billId, customerId, detail, formattedDate, total);
        billManage.add(bill);

        System.out.println("=============");
    }

    private void showAllBill() {
        System.out.println("***** Danh Sách Hóa Đơn *****");
        for (Bill bill : billManage.showAll()) {
            System.out.println(bill.toString());
            System.out.println("**********");
        }
        System.out.println("------------");
    }
}
