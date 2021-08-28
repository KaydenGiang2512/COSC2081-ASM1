import java.io.*;
import java.util.*;

public class Data {
    // Constructor
    public static String file_name = "src\\covid-data.csv";
    private String continent;
    private String country;
    private String start_date;
    private String end_date;
    private int range_choice;
    private int range;

    public Data(String continent, String country, String start_date, String end_date, int range_choice) {
        this.continent = continent;
        this.country = country;
        this.start_date = start_date;
        this.end_date = end_date;
        this.range_choice = range_choice;
    }

    public Data(int range) {
        this.range = range;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getStartDate() {
        return this.start_date;
    }

    public void setEndDate(String end_date) {
        this.end_date = end_date;
    }

    public String getEndDate() {
        return this.end_date;
    }

    public void setRangeChoice(int range_choice) {
        this.range_choice = range_choice;
    }

    public int getRangeChoice() {
        return this.range_choice;
    }

    public void setRange(int range) {
        if (range < 0) return;
        this.range = range;
    }

    public int getRange() {
        return this.range;
    }

    // read file csv
    public ArrayList<String> getAllRows() {
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

    public String getStartRow() {
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[1].equals(getContinent()) && values[2].equals(getCountry()) && values[3].equals(getStartDate())) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getStopRow() {
        try {
            FileReader reader = new FileReader(file_name);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[1].equals(getContinent()) && values[2].equals(getCountry()) && values[3].equals(getEndDate())) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<String> addRow1() {
        int from_idx = getAllRows().indexOf(getStartRow());
        int idx = getAllRows().indexOf(getStopRow());
        ArrayList<String> result = new ArrayList<>();
        for (int i = from_idx; i <= idx; i++) {
            result.add(getAllRows().get(i));
            result.add("\n");
        }
        return result;
    }

    public ArrayList<String> addRow2() {
        int from_idx = getAllRows().indexOf(getStartRow());
        ArrayList<String> result = new ArrayList<>();
        if (from_idx + range > getAllRows().size()){
            System.out.println("");
        }
        else {
            if (checkRowInfo2()){
                System.out.println("Error");
            }
            else {
                for (int i = from_idx; i <= from_idx + range; i++) {
                    result.add(getAllRows().get(i));
                    result.add("\n");
                }
            }
        }

        return result;
    }

    public ArrayList<String> addRow3() {
        int to_idx = getAllRows().indexOf(getStopRow());
        ArrayList<String> result = new ArrayList<>();
        if (range_choice == 1) range *= 7;
        if (to_idx - range < 0){
            System.out.println("Error");
        } else {
            if (checkRowInfo3()) {
                System.out.println("Error");
            } else {
                for (int i = to_idx - range; i <= to_idx; i++) {
                    result.add(getAllRows().get(i));
                    result.add("\n");
                }
            }

        }
        return result;
    }

    //Checking if the ending row has a different country from the starting row

    public boolean checkRowInfo2() {
        int from_idx = getAllRows().indexOf(getStartRow());
        String[] info_first_row = getAllRows().get(from_idx).split(",");
        if (range_choice == 1) range*=7;
        String[] info_last_row = getAllRows().get(from_idx + range).split(",");
        for (int j = 0; j < info_first_row.length; j++) {
            for (int k = 0; k < info_last_row.length; k++) {
                if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkRowInfo3() {
        int idx = getAllRows().indexOf(getStopRow());
        String[] info_stop_row = getAllRows().get(idx).split(",");
        if (range_choice == 1) range *= 7;
        String[] info_first_row = getAllRows().get(Math.abs(idx - range) ).split(",");
        for (int j = 0; j < info_stop_row.length; j++) {
            for (int k = 0; k < info_first_row.length; k++){
                if (!info_first_row[1].equals(info_stop_row[1]) || !info_first_row[2].equals(info_stop_row[2])){
                    return true;
                }
            }
        }
        return false;
    }

    public static Data create1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Enter ending date: ");
        String end_date = sc.nextLine();
        return new Data(continent, country, start_date, end_date, 0);
    }


    public static Data create2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String start_date = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int range_choice = sc.nextInt();
        return new Data(continent, country, start_date, "", range_choice);
    }


    public static Data create3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter ending date: ");
        String end_date = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int range_choice = sc.nextInt();
        return new Data(continent, country, "", end_date, range_choice);
    }

    public void inputRange() {
        Scanner sc = new Scanner(System.in);
        range_choice = getRangeChoice();
        if (range_choice == 1) {
            System.out.print("Please enter the number of weeks: ");
            range = sc.nextInt();
        } else if (range_choice == 2) {
            System.out.print("Please enter the number of days: ");
            range = sc.nextInt();
        }
        new Data(range);
    }

    public void display1() {
//        if (checkRowInfo()) return;
        System.out.printf("Your continent is %s, your country is %s\nStarting from %s to %s\n", continent, country, start_date, end_date);
    }

    public void display2() {
        if (checkRowInfo2()) {
            System.out.println("");
        }
        else {
            if (range_choice == 1) {
                if (range <= 0) {
                    System.out.println("Invalid number of weeks!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) from %s\n", continent, country, range/7, start_date);
                }
            } else if (range_choice == 2) {
                int days = range;
                if (days <= 0) {
                    System.out.println("Invalid number of days!");
                }
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s\n", continent, country, days, start_date);
            }
        }

    }

    public void display3() {
        if (checkRowInfo3()){
            return;
        }
        else {
            if (range_choice == 1) {
                if (range <= 0) {
                    System.out.println("Invalid number of weeks!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) to %s\n", continent, country, range/7, end_date);
                }
            } else if (range_choice == 2) {
                int days = range;
                if (days <= 0) {
                    System.out.println("Invalid number of days!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s\n", continent, country, days, end_date);
                }
            }
        }

    }
}
