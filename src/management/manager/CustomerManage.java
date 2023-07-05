package management.manager;

import readAndWriteFile.RAWCustomer;
import model.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManage {
    private List<Customer> customerList = null;
    private RAWCustomer rawCustomer = new RAWCustomer();

    public CustomerManage() {
        try {
            this.customerList = rawCustomer.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Customer customer) {
        try {
            this.customerList.add(customer);
            this.rawCustomer.writerFile(customerList);
            System.out.println("Thêm khách hàng thành công ^-^");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(String id, Customer customer) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.customerList.set(index, customer);
                this.rawCustomer.writerFile(customerList);
                System.out.println("Sửa thông tin khách hàng thành công ^.^");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID bạn nhập chưa tồn tại trên hệ thống. Mời nhập lại 0.0");
        }
    }

    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.customerList.remove(index);
                this.rawCustomer.writerFile(customerList);
                System.out.println("Xóa khách hàng thành công ^.^");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID bạn nhập chưa tồn tại trên hệ thống. Mời nhập lại 0.0");
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (id.equals(this.customerList.get(i).getCustomerId())) {
                return i;
            }
        }
        return -1;
    }

    public List<Customer> showAll() {
        try {
            return this.rawCustomer.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getFullName().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            }
        }
        return list;
    }
}