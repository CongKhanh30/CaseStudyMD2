package readAndWriteFile;

import model.Motorbikes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RAWMotorbike implements RAWFile<Motorbikes> {

    private File file = new File("F:\\CodeGYM\\CaseStudyModule2\\src\\data\\Motorbikes.csv");

    @Override
    public void writerFile(List<Motorbikes> motorbikes) throws IOException {
        String data = "";
        for (Motorbikes motorbikes1 : motorbikes) {
            data += motorbikes1.getVehicleId() + "," +
                    motorbikes1.getAutomaker() + "," +
                    motorbikes1.getYearOfProduction() + "," +
                    motorbikes1.getMotorbikeName() + "," +
                    motorbikes1.getStatus() + "," +
                    motorbikes1.getCategory() + "," +
                    motorbikes1.getNumberOfMotorbike() + "," +
                    motorbikes1.getRentCost() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();

    }

    @Override
    public List<Motorbikes> readerFile() throws IOException {
        List<Motorbikes> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Motorbikes(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7])));
        }
        bufferedReader.close();
        return list;
    }
}
