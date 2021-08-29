import java.io.*;
import java.util.*;

public class Data {
    // Constructor
    public static String fileName = "src\\covid-data.csv";
    private String continent;
    private String country;
    private String startDate;
    private String endDate;
    private int rangeChoice;
    private int range;

    public Data(String continent, String country, String startDate, String endDate, int rangeChoice) {
        this.continent = continent;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rangeChoice = rangeChoice;
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setRangeChoice(int rangeChoice) {
        this.rangeChoice = rangeChoice;
    }

    public int getRangeChoice() {
        return this.rangeChoice;
    }
    

    // Read file csv
    // Method to read the entire csv file from the first row to the last row
    public ArrayList<String> getAllRows() {
        ArrayList<String> rows = new ArrayList<>();
        try {
            FileReader reader = new FileReader(fileName);
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
            FileReader reader = new FileReader(fileName);
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
            FileReader reader = new FileReader(fileName);
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

    // Display rows for first case: From start date to end date
    public ArrayList<String> addRow1() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int idx = getAllRows().indexOf(getStopRow());
        ArrayList<String> result = new ArrayList<>();
        for (int i = fromIndex; i <= idx; i++) {
            result.add(getAllRows().get(i));
            result.add("\n");
        }
        return result;
    }

    // Display rows for second case: A number of days or weeks from a particular date
    public ArrayList<String> addRow2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        ArrayList<String> result = new ArrayList<>();
        if(rangeChoice == 1) range *= 7;
        if (fromIndex + range > getAllRows().size()){
            System.out.println("Error");
        }
        else {
            if (checkRowInfo2()){
                System.out.println("Error");
            }
            else {
                for (int i = fromIndex; i <= fromIndex + range; i++) {
                    result.add(getAllRows().get(i));
                    result.add("\n");
                }
            }
        }
        return result;
    }

    // Display rows for third case: A number of days or weeks to a particular date
    public ArrayList<String> addRow3() {
        int toIndex = getAllRows().indexOf(getStopRow());
        ArrayList<String> result = new ArrayList<>();
        if (rangeChoice == 1) range *= 7;
        if (toIndex - range < 0){
            System.out.println("Error");
        } else {
            if (checkRowInfo3()) {
                System.out.println("Error");
            } else {
                for (int i = toIndex - range; i <= toIndex; i++) {
                    result.add(getAllRows().get(i));
                    result.add("\n");
                }
            }

        }
        return result;
    }

    //Checking if the ending row has a different country from the starting row
    //Checking second case
    public boolean checkRowInfo2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        String[] info_first_row = getAllRows().get(fromIndex).split(",");
        if (fromIndex + range >= getAllRows().size()){
            System.out.println(" ");
        } else{
            String[] info_last_row = getAllRows().get(fromIndex + range).split(",");
            for (int j = 0; j < info_first_row.length; j++) {
                for (int k = 0; k < info_last_row.length; k++) {
                    if (!info_first_row[1].equals(info_last_row[1]) || !info_first_row[2].equals(info_last_row[2])){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //Checking if the ending row has a different country from the starting row
    //Checking third case
    public boolean checkRowInfo3() {
        int idx = getAllRows().indexOf(getStopRow());
        String[] infoStopRow = getAllRows().get(idx).split(",");
        String[] infoFirstRow = getAllRows().get(Math.abs(idx - range)).split(",");
        for (int j = 0; j < infoStopRow.length; j++) {
            for (int k = 0; k < infoStopRow.length; k++){
                if (!infoFirstRow[1].equals(infoStopRow[1]) || !infoFirstRow[2].equals(infoStopRow[2])){
                    return true;
                }
            }
        }
        return false;
    }

    // Create input for first time range method
    public static Data create1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String startDate = sc.nextLine();
        System.out.print("Enter ending date: ");
        String endDate = sc.nextLine();
        return new Data(continent, country, startDate, endDate, 0);
    }

    // Create input for second time range method
    public static Data create2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter starting date: ");
        String startDate = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int rangeChoice = sc.nextInt();
        return new Data(continent, country, startDate, "", rangeChoice);
    }

    // Create input for third time range method
    public static Data create3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your continent (first letter MUST be capitalized): ");
        String continent = sc.nextLine();
        System.out.print("Enter your country (first letter MUST be capitalized): ");
        String country = sc.nextLine();
        System.out.print("Enter ending date: ");
        String endDate = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int rangeChoice = sc.nextInt();
        return new Data(continent, country, "", endDate, rangeChoice);
    }

    // Input time range for second and third cases
    public void inputRange() {
        Scanner sc = new Scanner(System.in);
        rangeChoice = getRangeChoice();
        if (rangeChoice == 1) {
            System.out.print("Please enter the number of weeks: ");
            range = sc.nextInt();
        } else if (rangeChoice == 2) {
            System.out.print("Please enter the number of days: ");
            range = sc.nextInt();
        }
        new Data(range);
    }

    // Display first case
    public void display1() {
        System.out.printf("Your continent is %s, your country is %s\nStarting from %s to %s\n", continent, country, startDate, endDate);
    }

    // Display second case
    public void display2() {
        if (checkRowInfo2()) {
            System.out.println(" ");
        }
        else {
            if (rangeChoice == 1) {
                int days = range * 7;
                if (range <= 0) {
                    System.out.println("Invalid number of weeks!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) from %s\n", continent, country, days/7, startDate);
                }
            } else if (rangeChoice == 2) {
                int days = range;
                if (days <= 0) {
                    System.out.println("Invalid number of days!");
                }
                System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) from %s\n", continent, country, days, startDate);
            }
        }

    }

    // Display third case
    public void display3() {
        if (checkRowInfo3()){
            System.out.println("Error");
        }
        else {
            if (rangeChoice == 1) {
                int days = range * 7;
                if (range <= 0) {
                    System.out.println("Invalid number of weeks!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d week(s) to %s\n", continent, country, days/7, endDate);
                }
            } else if (rangeChoice == 2) {
                int days = range;
                if (days <= 0) {
                    System.out.println("Invalid number of days!");
                } else {
                    System.out.printf("Your continent is %s, your country is %s\nShowing %d day(s) to %s\n", continent, country, days, endDate);
                }
            }
        }
    }
}
