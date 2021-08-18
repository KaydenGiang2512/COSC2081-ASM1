import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class asm1 {
    public static void main(String[] args) {
        CSV read = new CSV("src\\covid-data.csv");
        read.readCSV();
    }

}



class CSV{
    String file_name;
    String line = "";
    public CSV(String file){
        file_name = file;
    }
    public void readCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file_name)); // read file csv

            while ((line = reader.readLine()) != null){
//                System.out.println(line);
                String[] column = line.split(",");
                System.out.println(column[2]); // print first column
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//class data extends CSV{
//    String  country;
//    String continent;
//    String date;
//    public data(String nation, String cont, String time){
//        country = nation;
//        continent = cont;
//        date = time;
//    }
//    public void organize_data(){
//        int count = 0;
//
//    }
//
//}