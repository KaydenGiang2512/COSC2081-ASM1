package database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Data{
    public static String file_name = "src\\covid-data.csv";
    String continent;
    String country;
    String date;
    String stop_date;
    public Data(String continent, String country, String date, String stop_date){
        this.continent = continent;
        this.country = country;
        this.date = date;
        this.stop_date = stop_date;
    }

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
//    public String[] get_column(int column_idx) {
//        String[] list_date = new String[get_all_rows().size()];
//        list_date = get_all_rows().toArray(list_date);
//        String[] values = new String[list_date.length];
//        for (int i = 0; i < values.length; i++) {
//            values[i] = (list_date[i].split(",")[column_idx]);
//        }
//        return values;
//    }

//    public ArrayList<String> convert_String_to_date(){
//        ArrayList<String> date_result = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        for (int i = 0; i < get_column(3).length;i++){
//            try {
//                Date time = sdf.parse(get_column(3)[i]);
//                get_column(3)[i] = sdf.format(time);
//                date_result.add(get_column(3)[i]);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        return date_result;
//    }


    public String get_start_row(){
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[1].equals(continent) && values[2].equals(country) && values[3].equals(date)) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Undefined");
        }
        return "";

    }

    public String get_stop_row(){
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()){
                String row = sc.nextLine();
                String[] values = row.split(",");
                for(int i = 0; i < values.length; i++){
                    if (values[1].equals(continent) && values[2].equals(country) && values[3].equals(stop_date)) return row;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";

    }

    public ArrayList<String> add_row_1(){
        int from_idx = get_all_rows().indexOf(get_start_row());
        int idx = get_all_rows().indexOf(get_stop_row());
        ArrayList<String> result = new ArrayList<>();
        for(int i = from_idx; i <= idx;i++){
            result.add(get_all_rows().get(i));
            result.add("\n");
        }
        return result;
    }

    public static Data create_1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Continent: ");
        String continent = sc.nextLine();
        System.out.print("Country: ");
        String country = sc.nextLine();
        System.out.print("From Date: ");
        String start = sc.nextLine();
        System.out.print("To day: ");
        String stop = sc.nextLine();
        return new Data(continent,country,start,stop);
    }

    public void display(){
        System.out.printf("Continent: %s, Country: %s, From %s to %s \n", continent,country,date,stop_date);
    }
    public static void main(String[] args) {
        Data d1 = create_1();
        d1.display();
        System.out.println(d1.add_row_1());
        }
}
