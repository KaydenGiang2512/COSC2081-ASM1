package database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class readCSV {
    public String file_name = "src\\covid-data.csv";
    public ArrayList<String> get_all_rows() {
        ArrayList<String> rows = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                if (row.isEmpty()) continue;
                rows.add(row);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rows;
    }

}
