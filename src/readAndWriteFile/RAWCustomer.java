package readAndWriteFile;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RAWCustomer implements RAWFile<Customer> {
    private File file = new File("F:\\CodeGYM\\CaseStudyModule2\\src\\data\\Customer.csv");

    @Override
    public void writerFile(List<Customer> customers) throws IOException {
        String data = "";
        for (Customer customer : customers) {
            data += customer.getCustomerId() + "," +
                    customer.getFullName() + "," +
                    customer.getPhone() + "," +
                    customer.getAddress() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    @Override
    public List<Customer> readerFile() throws IOException {
        List<Customer> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Customer(data[0], data[1], data[2], data[3]));
        }
        bufferedReader.close();
        return list;
    }
}
