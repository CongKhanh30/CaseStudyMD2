package menu;

import check.Check;
import management.manager.CarManage;
import management.manager.MotorbikeManage;
import management.manager.CustomerManage;
import management.manager.BillManage;
import model.Bill;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BillMenu {
    private BillManage billManage = new BillManage();
    private CarManage carManage = new CarManage();
    private MotorbikeManage motorbikeManage = new MotorbikeManage();
    private CustomerManage customerManage = new CustomerManage();
    private Check check = new Check();

    public void billMenu() {
        int choice = -1;
        do {
            String str = "^.^ ^_^ Bán Sách ^.^ ^_^\n" +
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
            String regexCar = "^car\\d+$";
            String str = "Nhập Id Ô Tô Cần Mua: (Nhập car0 Để Thoát Nhập): ";
            carID = check.checkRegex(str, regexCar);
            if (!carID.equals("car0")) {
                detail += carID + " ";
            }
        } while (!carID.equals("car0"));

        do {
            String regexMotor = "^motor\\d+$";
            String str = "Nhập Id Xe Máy Cần Mua: (Nhập motor0 Để Thoát Nhập): ";
            motorbikeID = check.checkRegex(str, regexMotor);
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
            if (s.contains("b")) {
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
