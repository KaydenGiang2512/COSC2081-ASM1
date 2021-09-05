import java.io.*;
import java.util.*;

public class Data {
    // Initializing private variables for future usage
    protected static String fileName = "src\\covid-data.csv";
    protected String location;
    protected String startDate;
    protected String endDate;
    protected int rangeChoice;
    protected int range;

    //Setting up the constructors
    public Data(String location, String startDate, String endDate, int rangeChoice) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rangeChoice = rangeChoice;
    }

    //This Convert method allows the data to be used in the Summary class for groupings, metrics and results type
    public void Convert(Data obj) {
        this.location = obj.location;
        this.startDate = obj.startDate;
        this.endDate = obj.endDate;
        this.rangeChoice = obj.rangeChoice;
        this.range = obj.range;
    }

    public Data(int range) {
        this.range = range;
    }

    public Data() {
    }

    //The getters for each variable
    public String getLocation() {
        return this.location;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public int getRangeChoice() {
        return this.rangeChoice;
    }

    // Reading the csv file
    // Method to read the entire CSV file from the first row to the last row
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

    //Method to get the first row of the CSV file based on user input
    public String getStartRow() {
        try {
            FileReader reader = new FileReader(fileName);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[2].equals(getLocation()) && values[3].equals(getStartDate())) {
                        return row;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    //Method to get the last row of the CSV file based on user input
    public String getStopRow() {
        try {
            FileReader reader = new FileReader(fileName);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                String row = sc.nextLine();
                String[] values = row.split(",");
                for (int i = 0; i < values.length; i++) {
                    if (values[2].equals(getLocation()) && values[3].equals(getEndDate())) {
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
        int toIndex = getAllRows().indexOf(getStopRow());
        ArrayList<String> result = new ArrayList<>();
        for (int i = fromIndex; i <= toIndex; i++) {
            result.add(getAllRows().get(i));
            result.add("\n");
        }
        return result;
    }

    // Display rows for second case: A number of days or weeks from a particular date
    public ArrayList<String> addRow2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        ArrayList<String> result = new ArrayList<>();
        if (fromIndex + range >= getAllRows().size()) {
            System.out.println("Error");
        } else {
            if (checkRowInfo2()) {
                System.out.println("Time range not found");
            } else {
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
        if (toIndex - range < 0) {
            System.out.println("Error");
        } else {
            if (checkRowInfo3()) {
                System.out.println("Time range not found");
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
    //Checking second time range case
    public boolean checkRowInfo2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        String[] infoFirstRow = getAllRows().get(fromIndex).split(",");
        int toIndex = fromIndex + range;
        if (toIndex >= getAllRows().size()) { // checking if the end index is out of the file csv length
            return true;
        } else {
            String[] infoLastRow = getAllRows().get(fromIndex + range).split(",");
            for (int j = 0; j < infoFirstRow.length; j++) {
                for (int k = 0; k < infoLastRow.length; k++) {
                    if (!infoFirstRow[2].equals(infoLastRow[2])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Checking if the ending row has a different country from the starting row
    //Checking third time range case
    public boolean checkRowInfo3() {
        int toIndex = getAllRows().indexOf(getStopRow());
        String[] infoLastRow = getAllRows().get(toIndex).split(",");
        int fromIndex = toIndex - range;
        if (fromIndex < 0) { // checking if the stop index is negative
            return true;
        } else {
            String[] infoFirstRow = getAllRows().get(toIndex - range).split(",");
            for (int j = 0; j < infoLastRow.length; j++) {
                for (int k = 0; k < infoFirstRow.length; k++) {
                    if (!infoFirstRow[2].equals(infoLastRow[2])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Create input for the first time range case
    public static Data create1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your location (first letter MUST be capitalized): ");
        String location = sc.nextLine();
        System.out.print("Enter starting date: ");
        String startDate = sc.nextLine();
        System.out.print("Enter ending date: ");
        String endDate = sc.nextLine();
        return new Data(location, startDate, endDate, 0);
    }

    // Create input for the second time range case
    public static Data create2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your location (first letter MUST be capitalized): ");
        String location = sc.nextLine();
        System.out.print("Enter starting date: ");
        String startDate = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int rangeChoice = sc.nextInt();
        return new Data(location, startDate, "", rangeChoice);
    }

    // Create input for the third time range case
    public static Data create3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your location (first letter MUST be capitalized): ");
        String location = sc.nextLine();
        System.out.print("Enter ending date: ");
        String endDate = sc.nextLine();
        System.out.print("Choose display in weeks (1) or display in days (2): ");
        int rangeChoice = sc.nextInt();
        return new Data(location, "", endDate, rangeChoice);
    }

    // Input range for second and third cases (a number of weeks/days)
    public void inputRange() {
        Scanner sc = new Scanner(System.in);
        rangeChoice = getRangeChoice();
        if (rangeChoice == 1) {
            System.out.print("Please enter the number of weeks: ");
            range = sc.nextInt();
            range *= 7;
        } else if (rangeChoice == 2) {
            System.out.print("Please enter the number of days: ");
            range = sc.nextInt();
        }
        new Data(range);
    }

    // Display the first time range case
    public void display1() {
        System.out.printf("Your location is %s\nStarting from %s to %s\n", location, startDate, endDate);
    }

    // Display the second time range case
    public void display2() {
        if (rangeChoice == 1) {
            int weeks = range;
            if (range <= 0) {
                System.out.println("Invalid number of weeks!");
            }
            else if (checkRowInfo2()) {
                System.out.println("Time range not found!");
            } else {
                System.out.printf("Your location is %s\nShowing %d week(s) from %s\n", location, weeks / 7, startDate);
            }
        }
        else if (rangeChoice == 2) {
            int days = range;
            if (days <= 0) {
                System.out.println("Invalid number of days!");
            }
            else if (checkRowInfo2()) {
                System.out.println("Time range not found!");
            } else {
                System.out.printf("Your location is %s\nShowing %d day(s) from %s\n", location, days, startDate);
            }
        }
    }

    // Display the third time range case
    public void display3() {
        if (rangeChoice == 1) {
            int weeks = range;
            if (range <= 0) {
                System.out.println("Invalid number of weeks!");
            }
            else if (checkRowInfo3()) {
                System.out.println("Time range not found!");
            } else {
                System.out.printf("Your location is %s\nShowing %d week(s) to %s\n", location, weeks / 7, endDate);
            }
        }
        else if (rangeChoice == 2) {
            int days = range;
            if (days <= 0) {
                System.out.println("Invalid number of days!");
            }
            else if (checkRowInfo3()) {
                System.out.println("Time range not found!");
            } else {
                System.out.printf("Your location is %s\nShowing %d day(s) to %s\n", location, days, endDate);
            }
        }
    }
}