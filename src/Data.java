import java.io.*;
import java.util.*;

public class Data {
    public static String file_name = "src\\covid-data.csv";
    String continent;
    String country;
    String start_date;
    //    String end_date;
    int range;

    public Data(String continent, String country, String start_date, int range) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
//        this.end_date = end_date;
        this.range = range;
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
            System.out.println("You entered an invalid continent/country/date! Please try again!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String get_stop_date(){
        int idx = get_all_rows().indexOf(get_start_row());
        String[] last_row = get_all_rows().get(idx + range).split(",");
        String stop_date = "";
        for (int i = 0; i < last_row.length; i++){
            stop_date = last_row[3];
        }
        return stop_date;
    }


    public ArrayList<String> add_row() {
        int from_idx = get_all_rows().indexOf(get_start_row());
        ArrayList<String> result = new ArrayList<>();
        if (check_row_info()){
            result.add("Error");
        } else {
            for(int i = from_idx; i <= from_idx+range;i++){
                result.add(get_all_rows().get(i));
                result.add("\n");
            }
        }

        return result;
    }

    //    check if the stop row is different country from start row
    private boolean check_row_info(){
        int from_idx = get_all_rows().indexOf(get_start_row());
        String[] info_first_row = get_all_rows().get(from_idx).split(",");
        String[] info_last_row = get_all_rows().get(from_idx+range).split(",");
        for (int j = 0; j < info_first_row.length; j++){
            for (int k = 0; k < info_last_row.length; k++){
                if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])) return true;
            }
        }

        return false;
    }

    public static Data create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent: ");
        String continent = sc.nextLine();
        System.out.print("Enter your country: ");
        String country = sc.nextLine();
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter range: ");
        int range = sc.nextInt();
        return new Data(continent,country,date,range);
    }

    public void display_1() {
        if (check_row_info()) return;
        System.out.printf("\nYour continent is %s, Your country is %s, starting from %s to %s \n\n", continent,country,start_date,get_stop_date());
    }

//    public static Data create_2() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your continent: ");
//        String continent = sc.nextLine();
//        System.out.print("Enter your country: ");
//        String country = sc.nextLine();
//        System.out.print("Enter starting date: ");
//        String start_date = sc.nextLine();
//        System.out.print("Enter ending date: ");
//        String stop_date = sc.nextLine();
//        System.out.print("Display in number of weeks (Press 1) or number of days (Press 2): ");
//        int choice = sc.nextInt();
//        return new Data(continent, country, start_date, stop_date, choice);
//    }

    public void display_2(){
        if (check_row_info()) return;
        int days = range;
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose weeks (1) or days to display (2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s, showing %d week(s) from %s \n\n", continent,country,days/7,start_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s, showing %d week(s) %d day(s) from %s \n\n", continent, country, days/7, days % 7,start_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s, showing %d day(s) from %s \n\n", continent,country,(days % 7),start_date);
            }
        }
        else if (choice == 2) {
            System.out.printf("Your continent is %s, your country is %s, showing %d day(s) from %s \n\n", continent,country,days,start_date);
        } else {
            System.out.println("Error");
        }
    }

//    public static Data create_3() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter your continent: ");
//        String continent = sc.nextLine();
//        System.out.print("Enter your country: ");
//        String country = sc.nextLine();
//        System.out.print("Enter starting date: ");
//        String start_date = sc.nextLine();
//        System.out.print("Enter ending date: ");
//        String stop_date = sc.nextLine();
//        System.out.print("Display in number of weeks (Press 1) or number of days (Press 2): ");
//        int choice = sc.nextInt();
//        return new Data(continent, country, start_date, stop_date, choice);
//    }

    public void display_3() {
        if (check_row_info()) return;
        int days = range  ;
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose weeks (1) or days to display (2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s, showing %d week(s) to %s \n\n", continent, country, days/7, get_stop_date());
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s, showing %d day(s) to %s \n\n", continent, country, days,get_stop_date());
            } else {
                System.out.printf("Your continent is %s, your country is %s, showing %d day(s) to %s \n\n", continent, country,(days % 7), get_stop_date());
            }
        }
        else if (choice == 2) {
            System.out.printf("Your continent is %s, your country is %s, showing %d day(s) to %s \n\n", continent, country, (days), get_stop_date());
        } else {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        Data d1 = new Data("Asia","Afghanistan","6/18/2021", 7);
        System.out.println(d1.add_row());
        d1.display_1();
        d1.display_2();
        d1.display_3();
    }
}