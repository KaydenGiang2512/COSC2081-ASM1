import jdk.nashorn.internal.runtime.Undefined;

import java.io.*;
import java.util.*;

public class Data {
    // Constructor
    public static String file_name = "src\\covid-data.csv";
    private String continent;
    private String country;
    private String start_date;
    private String end_date;
    private int range;

    public Data(String continent, String country, String start_date, String end_date, int range) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
        this.range = range;
    }

    public void setContinent(String continent){
        this.continent = continent;
    }
    public String getContinent(){
        return this.continent;
    }

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }

    public void setStart_date(String start_date){
        this.start_date = start_date;
    }
    public String getStart_date(){
        return this.start_date;
    }

    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }

    public String getEnd_date(){
        return this.end_date;
    }

    public void setRange(int range){
        if (range < 0) return;
        this.range = range;
    }
    public int getRange(){
        return this.range;
    }

    // read file csv
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

    public String get_start_row() {
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[1].equals(getContinent()) && values[2].equals(getCountry()) && values[3].equals(getStart_date())) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String get_stop_row() {
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()){
                String row = sc.nextLine();
                String[] values = row.split(",");
                for(int i = 0; i < values.length; i++){
                    if (values[1].equals(getContinent()) && values[2].equals(getCountry()) && values[3].equals(getEnd_date())) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<String> add_row_1_2() {
        int from_idx = get_all_rows().indexOf(get_start_row());
        int idx = get_all_rows().indexOf(get_stop_row());
        ArrayList<String> result = new ArrayList<>();
        for(int i = from_idx; i <= idx;i++){
            result.add(get_all_rows().get(i));
            result.add("\n");
        }
        return result;
    }

    public ArrayList<String> add_row_3() {
        int to_idx = get_all_rows().indexOf(get_stop_row());
        ArrayList<String> result = new ArrayList<>();
        for(int i = to_idx-range; i <= to_idx;i++){
            result.add(get_all_rows().get(i));
            result.add("\n");
        }
        return result;
    }

//    private boolean check_input() {
//        for (int i = 0; i < get_all_rows().size(); i++){
//            String row = get_all_rows().get(i);
//            String[] values = row.split(",");
//            for (int j = 0 ; j < values.length; j++){
//                if(values[1].equals(getContinent()) && !values[2].equals(getCountry())) return true;
//                if(!values[1].equals(getContinent()) && !values[2].equals(getCountry())) return true;
//                if(values[1].equals(getContinent()) && !values[3].equals(getStart_date())) return true;
//                if(!values[1].equals(getContinent()) && !values[3].equals(getEnd_date())) return true;
//            }
//        }
//        return false;
//    }

    //Checking if the ending row has a different country from the starting row
    public boolean check_row_info() {
        int from_idx = get_all_rows().indexOf(get_start_row());
        String[] info_first_row = get_all_rows().get(from_idx).split(",");
        String[] info_last_row = get_all_rows().get(from_idx+getRange()).split(",");
        for (int j = 0; j < info_first_row.length; j++) {
            for (int k = 0; k < info_last_row.length; k++) {
                if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])) return true;
            }
        }
        return false;
    }

    public static Data create_1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter ending date: ");
        String end_date = sc.nextLine();
        return new Data(continent,country,start_date,end_date,0);
    }

    public void display_1() {
        if (check_row_info()) return;
        System.out.printf("Your continent is %s, your country is %s\nStarting from %s to %s\n", continent,country,start_date,end_date);
    }

    public static Data create_2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter range: ");
        int range = sc.nextInt();
        return new Data(continent, country, start_date, "", range);
    }

    public static Data create_3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter ending date: ");
        String end_date = sc.nextLine();
        System.out.print("Enter range: ");
        int range = sc.nextInt();
        return new Data(continent, country, "", end_date, range);
    }

    public void display_2(){
        if (check_row_info()) System.out.println("Error");
        int days = getRange();
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose weeks (1) or days to display (2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) from %s \n\n", continent,country,days/7,start_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) %d day(s) from %s \n\n", continent, country, days/7, days % 7,start_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s \n\n", continent,country,(days % 7),start_date);
            }
        }
        else if (choice == 2) {
            System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s \n\n", continent,country,days,start_date);
        }
    }

    public void display_3() {
        int days = getRange();
        if(days < 0) System.out.println("Undefined");
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose weeks (1) or days to display (2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) to %s \n\n", continent, country, days/7, end_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) %d day(s) to %s \n\n", continent, country, days/7, days % 7,end_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s \n\n", continent, country,(days % 7), end_date);
            }
        }
        else if (choice == 2) {
            System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s \n\n", continent, country, (days), end_date);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose display type: ");
        System.out.println("1. A pair of date: ");
        System.out.println("2. A number of days/weeks from date: ");
        System.out.println("3. A number of days/weeks to date: ");
        int choice = sc.nextInt();
        if (choice == 1){
            Data d2 = create_1();
            System.out.println(d2.add_row_1_2());
            d2.display_1();
        }
        else if (choice == 2){
            Data d3 = create_2();
            System.out.println(d3.add_row_1_2());
            d3.display_2();
        }
        else if (choice == 3){
            Data d4 = create_3();
            System.out.println(d4.add_row_3());
            d4.display_3();
        }

        else {
            System.out.println("Error");
        }
    }
}