import java.util.*;

public class Main {
    public static void main(String[] args) {
        // While loop to keep the program running forever, unless the user wants to end the program by selecting 0
        while (true) {
            // Welcome screen with a simple design prompting the user to choose their desirable time range selection method
            System.out.println("\n******************************************************");
            System.out.println("Welcome to Group 15's COVID Pandemic Analysis program!");
            System.out.println("******************************************************\n");
            System.out.println("There are 3 different methods to select your time range:");
            System.out.println("1. A pair of start date & end date inclusively (e.g., 1/1/2021 and 8/1/2021)");
            System.out.println("2. A number of days or weeks from a particular date " +
                    "(e.g., 2 days from 1/20/2021 means there are 3 days 1/20/2021, 1/21/2021, and 1/22/2021)");
            System.out.println("3. A number of days or weeks to a particular date " +
                    "(e.g., 1 week to 1/8/2021 means there are 8 days from 1/1/2021 to 1/8/2021)");
            System.out.println("0. The user wants to stop the program from running\n");
            //Initialize a new scanner to receive input from the user
            Scanner sc = new Scanner(System.in);
            System.out.print("Please select an option 1-3: ");
            String time_range = sc.nextLine();

            //Creating a switch case to handle different user input possibilities
            switch (time_range) {
                case "0" -> {
                    boolean isRunning = false;
                    System.out.print("Do you want to run this program again? 1 (yes), 2 (no): ");
                    int option = sc.nextInt();
                    while (!isRunning) {
                        if (option == 1) {
                            isRunning = true;
                        }
                        else if (option == 2) {
                            System.out.println("Exiting program...");
                            System.exit(0);
                        } else {
                            System.out.print("Invalid selection! Please select between 1 (yes), 2 (no): ");
                            option = sc.nextInt();
                            if (option == 1) {
                                isRunning = true;
                            }
                            else if (option == 2) {
                                System.exit(0);
                            }
                        }
                    }
                }
                case "1" -> {
                    Data d1 = Data.create_1();
                    System.out.println("****************************************************");
                    d1.display_1();
                    System.out.println("****************************************************\n");
                    System.out.println(d1.add_row());
                }
                case "2" -> {
                    Data d2 = Data.create_2_3();
                    System.out.println("*******************************************************************");
                    d2.display_2();
                    System.out.println(d2.add_row());
                }
                case "3" -> {
                    Data d3 = Data.create_2_3();
                    System.out.println("*******************************************************************");
                    d3.display_3();
                    System.out.println(d3.add_row());
                }
                default -> {
                    while (true) {
                        System.out.println("************************************************");
                        System.out.print("Invalid selection! Please select an option 1-3: ");
                        time_range = sc.nextLine();

                        switch (time_range) {
                            case "1" -> {
                                Data d1 = Data.create_1();
                                System.out.println("****************************************************");
                                d1.display_1();
                                System.out.println("****************************************************\n");
                                System.out.println(d1.add_row());
                            }
                            case "2" -> {
                                Data d2 = Data.create_2_3();
                                System.out.println("*******************************************************************");
                                d2.display_2();
                                System.out.println(d2.add_row());
                            }
                            case "3" -> {
                                Data d3 = Data.create_2_3();
                                System.out.println("*******************************************************************");
                                d3.display_3();
                                System.out.println(d3.add_row());
                            }
                        }
                    }
                }
            }
        }
    }
}