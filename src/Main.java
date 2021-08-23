import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) {
        CSV read = new CSV("src\\covid-data.csv");
        read.readCSV();
    }
}

class CSV {
    String file_name;
    String line = "";
    int i = 0;  //For checking the total number of lines scanned

    public CSV(String file){
        file_name = file;
    }

    // Initializing the Scanner and the BufferedReader to null
    Scanner sc = null;
    BufferedReader reader = null;

    public void readCSV() {
        try {

            //Creating the new Scanner and BufferedReader
            reader = new BufferedReader(new FileReader(file_name)); // read file csv
            sc = new Scanner(reader);

            //While loop to scan through each line in the file and print them out
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);
                i++;  //incrementing the number of lines by 1 until the loop is done
            }

            //Printing out the total number of lines
            System.out.println("\nThe total number of lines printed is " + i);
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