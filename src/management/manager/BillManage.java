package management.manager;

import model.Bill;
import readAndWriteFile.RAWBill;

import java.io.IOException;
import java.util.List;

public class BillManage {
    private List<Bill> billList = null;
    private RAWBill rawBill = new RAWBill();

    public BillManage() {
        try {
            this.billList = this.rawBill.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Bill bill) {
        try {
            this.billList.add(bill);
            this.rawBill.writerFile(billList);
            System.out.println("Thêm Thành Công !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < this.billList.size(); i++) {
            if (id.equals(this.billList.get(i).getBillID())) {
                return i;
            }
        }
        return -1;
    }

    public List<Bill> showAll() {
        try {
            return this.rawBill.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}