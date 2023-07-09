package menu;

import check.Check;
import consoleColor.ConsoleColor;


public class MainMenu {
    private Check check = new Check();
    private CarsMenu carsMenu = new CarsMenu();
    private MotorbikesMenu motorbikesMenu = new MotorbikesMenu();
    private CustomerMenu customerMenu = new CustomerMenu();
    private BillMenu billMenu = new BillMenu();

    public void mainMenu() {
        int choice = -1;
        do {
            String str = ConsoleColor.BLACK + ConsoleColor.GREEN_BACKGROUND + "^.^ ^_^ CÔNG KHANH AUTO ^.^ ^_^" + ConsoleColor.RESET + "\n" +
                    "1. Quản Lý Auto\n" +
                    "2. Quản Lý Khách Hàng\n" +
                    "3. Hóa Đơn\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    this.vehicleMenu();
                    break;
                case 2:
                    customerMenu.customerMenu();
                    break;
                case 3:
                    billMenu.billMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
            }
        } while (choice != 0);
    }

    private void vehicleMenu() {
        int choice = -1;
        do {
            String str = ConsoleColor.BLACK + ConsoleColor.GREEN_BACKGROUND + "===== Quản Lý Auto =====" + ConsoleColor.RESET + "\n" +
                    "1. Quản Lý Ô Tô\n" +
                    "2. Quản Lý Xe Máy\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    carsMenu.carsMenu();
                    break;
                case 2:
                    motorbikesMenu.motorbikesMenu();
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
}
