package menu;

import check.Check;
import management.manager.CustomerManage;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private CustomerManage customerManage = new CustomerManage();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void customerMenu() {
        int choice = -1;
        do {
            String str = "^.^ ^_^ Quản Lý Khách Hàng ^_^ ^.^\n" +
                    "1. Thêm Khách Hàng\n" +
                    "2. Sửa Khách Hàng\n" +
                    "3. Xóa Khách Hàng\n" +
                    "4. Tìm Kiếm Khách Hàng\n" +
                    "5. Hiển Thị Khách Hàng\n" +
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
                    showAllCustomer();
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
        System.out.println("^_^ ^_^ Thêm Khách Hàng ^_^ ^_^");
        String customerId;
        while (true) {
            String regex = "^cus\\d+$";
            String str = "Nhập Id Khách Hàng: ";
            customerId = check.checkRegex(str, regex);
            if (customerManage.findIndexById(customerId) == -1) {
                break;
            }
            System.out.println("Id Khách Hàng Đã Tồn Tại. Mời Nhập ID Khác.");
        }

        System.out.print("Nhập Tên Khách Hàng: ");
        String fullName = input.nextLine();

        System.out.print("Nhập Số Điện Thoại: ");
        String phone = input.nextLine();

        System.out.print("Nhập Địa Chỉ: ");
        String address = input.nextLine();

        Customer customer = new Customer(customerId, fullName, phone, address);
        customerManage.add(customer);

        System.out.println("===============");
    }

    private void editMenu() {
        System.out.println("^_^ ^_^ Sửa Khách Hàng ^_^ ^_^");
        String regex = "^cus\\d+$";
        String str = "Nhập Id Khách Hàng: ";
        String customerId = check.checkRegex(str, regex);
        if (customerManage.findIndexById(customerId) == -1) {
            System.out.println("Không Có Id Muốn Sửa");
        } else {
            System.out.print("Nhập Tên Khách Hàng: ");
            String fullName = input.nextLine();

            System.out.print("Nhập Số Điện Thoại: ");
            String phone = input.nextLine();

            System.out.print("Nhập Địa Chỉ: ");
            String address = input.nextLine();

            Customer customer = new Customer(customerId, fullName, phone, address);
            customerManage.edit(customerId, customer);

            System.out.println("===============");
        }
    }

    private void deleteMenu() {
        System.out.println("^_^ ^_^ Xóa Khách Hàng ^_^ ^_^");
        String regex = "^cus\\d+$";
        String str = "Nhập Id Khách Hàng: ";
        String customerId = check.checkRegex(str, regex);
        customerManage.delete(customerId);

        System.out.println("===============");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = "^_^ ^_^ Tìm Khách Hàng ^_^ ^_^\n" +
                    "1. Tìm Khách Hàng Theo Id\n" +
                    "2. Tìm Khách Hàng Theo Tên\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("--------------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("--------------");

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
        System.out.println("^_^ ^_^ Tìm Khách Hàng Theo Id ^_^ ^_^");
        String regex = "^cus\\d+$";
        String str = "Nhâp Id Khách Hàng: ";
        String customerId = check.checkRegex(str, regex);
        System.out.println("----------");
        int index = customerManage.findIndexById(customerId);
        if (index != -1) {
            System.out.println(customerManage.showAll().get(index).toString());

            System.out.println("//////////");
        } else {
            System.out.println("Không Tìm Thấy Khách Hàng !!!");

            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println("^_^ ^_^ Tìm Khách Hàng Theo Tên ^_^ ^_^");
        System.out.print("Nhập Tên Khách Hàng: ");
        String name = input.nextLine();
        System.out.println("----------");
        List<Customer> list = customerManage.findByName(name);
        if (list.size() != 0) {
            for (Customer customer : list) {
                System.out.println(customer.toString());
                System.out.println("**********");
            }
        } else {
            System.out.println("Không Tìm Thấy Khách Hàng !!!");

            System.out.println("//////////");
        }
    }

    private void showAllCustomer() {
        System.out.println("***** Danh Sách Khách Hàng *****");
        for (Customer customer : customerManage.showAll()) {
            System.out.println(customer.toString());
            System.out.println("**********");
        }
        System.out.println("//////////");
    }

}