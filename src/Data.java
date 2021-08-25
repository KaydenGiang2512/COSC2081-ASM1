import java.io.*;
import java.util.*;

public class Data {
    public static String file_name = "src\\covid-data.csv";
    String continent;
    String country;
    String start_date;
    String end_date;
    int choice;

    public Data(String continent, String country, String start_date, String end_date) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Data(String continent, String country, String start_date, String end_date, int choice) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
        this.choice = choice;
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
        for(int i = from_idx; i <= idx;i++){
            result.add(get_all_rows().get(i));
            result.add("\n");
        }
        return result;
    }

    public static Data create_1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent: ");
        String continent = sc.nextLine();
        System.out.print("Enter your country: ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start = sc.nextLine();
        System.out.print("Enter ending date: ");
        String stop = sc.nextLine();
        return new Data(continent,country,start,stop);
    }

    public void display_1() {
        System.out.printf("\nYour continent is %s, Your country is %s, starting from %s to %s \n\n", continent,country,start_date,end_date);
    }

    public static Data create_2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent: ");
        String continent = sc.nextLine();
        System.out.print("Enter your country: ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter ending date: ");
        String stop_date = sc.nextLine();
        System.out.print("Display in number of weeks (Press 1) or number of days (Press 2): ");
        int choice = sc.nextInt();
        return new Data(continent, country, start_date, stop_date, choice);
    }

    public void display_2(){
        int days = add_row().size() / 2;

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

    public static Data create_3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent: ");
        String continent = sc.nextLine();
        System.out.print("Enter your country: ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter ending date: ");
        String stop_date = sc.nextLine();
        System.out.print("Display in number of weeks (Press 1) or number of days (Press 2): ");
        int choice = sc.nextInt();
        return new Data(continent, country, start_date, stop_date, choice);
    }

    public void display_3() {
        int days = add_row().size()/2;

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