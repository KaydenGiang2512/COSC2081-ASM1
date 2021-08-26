import java.io.*;
import java.util.*;

public class Data {
    public static String file_name = "src\\covid-data.csv";
    String continent;
    String country;
    String start_date;
    String end_date;
    int range_choice;

    public Data(String continent, String country, String start_date, String end_date, int range_choice) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
        this.range_choice = range_choice;
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

    public String get_start_row() {
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[1].equals(continent) && values[2].equals(country) && values[3].equals(start_date)) {
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
                    if (values[1].equals(continent) && values[2].equals(country) && values[3].equals(end_date)) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<String> add_row() {
        int from_idx = get_all_rows().indexOf(get_start_row());
        int idx = get_all_rows().indexOf(get_stop_row());
        ArrayList<String> result = new ArrayList<>();
        for(int i = from_idx; i <= idx;i++){
            result.add(get_all_rows().get(i));
            result.add("\n");
        }
        return result;
    }

    public boolean check_input() {
        for (int i = 0; i < get_all_rows().size(); i++){
            String row = get_all_rows().get(i);
            String[] values = row.split(",");
            for (int j = 0 ; j < values.length; j++){
                if(values[1].equals(continent) && !values[2].equals(country)) return true;
                if(!values[1].equals(continent) && !values[2].equals(country)) return true;
                if(values[1].equals(continent) && !values[3].equals(start_date)) return true;
                if(!values[1].equals(continent) && !values[3].equals(start_date)) return true;
            }
        }
        return false;
    }

    //Checking if the ending row has a different country from the starting row
    public boolean check_row_info() {
        int from_idx = get_all_rows().indexOf(get_start_row());
        String[] info_first_row = get_all_rows().get(from_idx).split(",");
        String[] info_last_row = get_all_rows().get(from_idx+range_choice).split(",");
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

    public static Data create_2_3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter ending date: ");
        String end_date = sc.nextLine();
        System.out.print("Display in number of weeks (Press 1) or number of days (Press 2): ");
        int range_choice = sc.nextInt();
        return new Data(continent, country, start_date, end_date, range_choice);
    }

    public void display_2(){
        int days = add_row().size() / 2;

        if (range_choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) from %s \n\n", continent,country,days/7,start_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) %d day(s) from %s \n\n", continent, country, days/7, days % 7,start_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s \n\n", continent,country,(days % 7),start_date);
            }
        }
        else if (range_choice == 2) {
            System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s \n\n", continent,country,days,start_date);
        }
    }

    public void display_3() {
        int days = add_row().size()/2;

        if (range_choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) to %s \n\n", continent, country, days/7, end_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) %d day(s) to %s \n\n", continent, country, days/7, days % 7,end_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s \n\n", continent, country,(days % 7), end_date);
            }
        }
        else if (range_choice == 2) {
            System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s \n\n", continent, country, (days), end_date);
        }
    }
}