package readAndWriteFile;

import model.Cars;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RAWCar implements RAWFile<Cars> {

    private File file = new File("F:\\CodeGYM\\CaseStudyModule2\\src\\data\\Cars.csv");

    @Override
    public void writerFile(List<Cars> cars) throws IOException {
        String data = "";
        for (Cars cars1 : cars) {
            data += cars1.getVehicleId() + "," +
                    cars1.getAutomaker() + "," +
                    cars1.getYearOfProduction() + "," +
                    cars1.getCarName() + "," +
                    cars1.getStatus() + "," +
                    cars1.getCategory() + "," +
                    cars1.getNumberOfCar() + "," +
                    cars1.getCarPrice() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();

    }

    @Override
    public List<Cars> readerFile() throws IOException {
        List<Cars> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Cars(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5], Integer.parseInt(data[6]), Long.parseLong(data[7])));
        }
        bufferedReader.close();
        return list;
    }
}
