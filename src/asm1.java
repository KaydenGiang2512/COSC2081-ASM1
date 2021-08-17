import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class asm1 {
    public static void main(String[] args) {
        String file = "src\\covid-data.csv";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file)); // read file csv

            while ((line = reader.readLine()) != null){
//                System.out.println(line);
                String[] values = line.split(",");
                System.out.println(values[0]); // print first column
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



