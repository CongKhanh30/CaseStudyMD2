package readAndWriteFile;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RAWBill implements RAWFile<Bill> {
    private File file = new File("F:\\CodeGYM\\CaseStudyModule2\\src\\data\\Bill.csv");

    @Override
    public void writerFile(List<Bill> bills) throws IOException {
        String data = "";
        for (Bill bill : bills) {
            data += bill.getBillID() + "," +
                    bill.getCustomerId() + "," +
                    bill.getVehicleId() + "," +
                    bill.getDate() + "," +
                    bill.getTotal() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    @Override
    public List<Bill> readerFile() throws IOException {
        List<Bill> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Bill(data[0], data[1], data[2], data[3], Long.parseLong(data[4])));
        }
        return list;
    }
}