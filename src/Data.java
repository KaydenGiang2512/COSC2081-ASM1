import java.io.*;
import java.util.*;

public class Data {
    public static String file_name = "src\\covid-data.csv";
    String continent;
    String country;
    String start_date;
    String end_date;
    int range;

    public Data(String continent, String country, String start_date, String end_date, int range) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
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
        if (from_idx > idx || check_row_info_1()){
            result.add("Error");
        } else {
            for(int i = from_idx; i <= idx;i++){
                result.add(get_all_rows().get(i));
                result.add("\n");
            }
        }

        return result;
    }

    private boolean check_row_info_1(){
        int from_idx = get_all_rows().indexOf(get_start_row());
        for (int i = from_idx; i <= from_idx+range; i++ ){
            String[] info_first_row = get_all_rows().get(from_idx).split(",");
            String[] info_last_row = get_all_rows().get(from_idx+range).split(",");
            for (int j = 0; j < info_first_row.length; j++){
                for (int k = 0; k < info_last_row.length; k++){
                    if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])) return true;
                }
            }
        }
        return false;
    }

    private boolean check_row_info_2(){
        int to_idx = get_all_rows().indexOf(get_stop_row());
        for (int i = to_idx - range; i <= range; i++ ){
            String[] info_first_row = get_all_rows().get(to_idx -range).split(",");
            String[] info_last_row = get_all_rows().get(range).split(",");
            for (int j = 0; j < info_first_row.length; j++){
                for (int k = 0; k < info_last_row.length; k++){
                    if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])) return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> add_row_2(){
        int from_idx = get_all_rows().indexOf(get_start_row());
        ArrayList<String> result_2 = new ArrayList<>();
        for (int i = from_idx; i <= from_idx + range; i++) {
            if (check_row_info_1()) {
                result_2.add("Error");
            } else {
                result_2.add(get_all_rows().get(i));
                result_2.add("\n");
            }
        }
        return result_2;
    }

    public ArrayList<String> add_row_3(){
        int to_idx = get_all_rows().indexOf(get_stop_row());
        ArrayList<String> result_3 = new ArrayList<>();

        for (int i = to_idx - range; i <= to_idx; i++){
            if (to_idx - range < 0 || check_row_info_2()){
                System.out.print("Error");
            }
            else {
                result_3.add(get_all_rows().get(i));
                result_3.add("\n");
            }
        }
        return result_3;
    }

    public static Data create_1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent: ");
        String continent = sc.nextLine();
        System.out.print("Enter your country: ");
        String country = sc.nextLine();
        System.out.print("Choose time range type: ");
        System.out.println("1. A pair of start date and end date ");
        System.out.println("2. A number of days or weeks from a particular date  ");
        System.out.println("3. A number of days or weeks to a particular date ");
        int choice = sc.nextInt();
        if (choice == 1){
            int range = 0;
            System.out.print("Enter starting date: ");
            String start = sc.nextLine();
            System.out.print("Enter ending date: ");
            String stop = sc.nextLine();
            return new Data(continent,country,start,stop, range);
        }
        else if (choice == 2){
            System.out.print("Enter starting date: ");
            String start = sc.nextLine();
            System.out.print("Enter range: ");
            int range = sc.nextInt();
            return new Data(continent,country,start, "" ,range);
        }
        else if (choice == 3){
            System.out.print("Enter starting date: ");
            String end_date = sc.nextLine();
            System.out.print("Enter range: ");
            int range = sc.nextInt();
            return new Data(continent,country,"",end_date,range);
        } else{
            System.out.println("Error");
        }
        return null;
    }

    public void display_1() {
        System.out.printf("\nYour continent is %s, Your country is %s, starting from %s to %s \n\n", continent,country,start_date,end_date);
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
        int days = add_row().size() / 2;
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
        int days = add_row().size()/2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose weeks (1) or days to display (2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            if (days >= 7 && days % 7 == 0) {
                System.out.printf("Your continent is %s, your country is %s, showing %d week(s) to %s \n\n", continent, country, days/7, end_date);
            }
            else if (days >= 7) {
                System.out.printf("Your continent is %s, your country is %s, showing %d week(s) %d day(s) to %s \n\n", continent, country, days/7, days % 7,end_date);
            } else {
                System.out.printf("Your continent is %s, your country is %s, showing %d day(s) to %s \n\n", continent, country,(days % 7), end_date);
            }
        }
        else if (choice == 2) {
            System.out.printf("Your continent is %s, your country is %s, showing %d day(s) to %s \n\n", continent, country, (days), end_date);
        } else {
            System.out.println("Error");
        }
    }
}