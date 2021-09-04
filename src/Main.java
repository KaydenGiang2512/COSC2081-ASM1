package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Implementing a while loop to keep the program running forever, unless the user wants to terminate the program by selecting 0
        while (true) {
            // Welcome screen with a simple design consisting of a prompt for the user to enter their desired time range display method
            System.out.println("\n******************************************************");
            System.out.println("Welcome to Group 15's COVID Pandemic Analysis program!");
            System.out.println("******************************************************\n");
            System.out.println("There are 3 different methods to select your time range:");
            System.out.println("1. A pair of start date & end date inclusively (e.g., 1/1/2021 and 8/1/2021)");
            System.out.println("2. A number of days or weeks from a particular date " +
                    "(e.g., 2 days from 1/20/2021 means there are 3 days 1/20/2021, 1/21/2021, and 1/22/2021)");
            System.out.println("3. A number of days or weeks to a particular date " +
                    "(e.g., 1 week to 1/8/2021 means there are 8 days from 1/1/2021 to 1/8/2021)");
            System.out.println("0. If you want this program to stop running, please select this option!\n");
            //Initialize a new scanner to receive input from the user (a number 1-3 representing the corresponding method)
            Scanner sc = new Scanner(System.in);
            System.out.print("Please select an option 1-3: ");
            String time_range = sc.nextLine();


            //Creating an advanced switch case to handle the different user input possibilities
            switch (time_range) {
                // option 0: This option allows the user to stop the program
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
                // option 1: This option shows the time range as a pair of start date and end date
                case "1" -> {
                    Data d1 = Data.create1();
                    Summary s1 = new Summary();
                    s1.Convert(d1);
                    System.out.println("****************************************************");
                    s1.display1();
                    System.out.println("****************************************************\n");
                    s1.grouping1(s1);
                    Display.display();
                }
                // option 2: This option shows the time range as a number of weeks/days from a particular date
                case "2" -> {
                    Data d2 = Data.create2();
                    Summary s2 = new Summary();
                    s2.Convert(d2);
                    System.out.println("*******************************************************************");
                    s2.inputRange();
                    System.out.println("*******************************************************************");
                    s2.display2();
                    System.out.println("*******************************************************************\n");
                    s2.grouping2(s2);
                    Display.display();
                }
                // option 3: This option shows the time range as a number of weeks/days to a particular date
                case "3" -> {
                    Data d3 = Data.create3();
                    Summary s3 = new Summary();
                    s3.Convert(d3);
                    System.out.println("*******************************************************************");
                    s3.inputRange();
                    System.out.println("*******************************************************************");
                    s3.display3();
                    System.out.println("*******************************************************************\n");
                    s3.grouping3(s3);
                    Display.display();
                }
                // default case: This option handles all the instances where a user enters an invalid option (not 0 or 1-3)
                default -> {
                    // Setting a boolean variable to track the default option
                    boolean isInvalid = true;
                    // This while loop ensures that the program is still looping forever when the default case is invoked
                    while (isInvalid) {
                        System.out.println("************************************************");
                        System.out.print("Invalid selection! Please select an option 1-3: ");
                        time_range = sc.nextLine();

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
                                Data d1 = Data.create1();
                                Summary s1 = new Summary();
                                s1.Convert(d1);
                                System.out.println("****************************************************");
                                s1.display1();
                                System.out.println("****************************************************\n");
                                s1.grouping1(s1);
                                Display.display();
                                isInvalid = false;
                            }
                            case "2" -> {
                                Data d2 = Data.create2();
                                Summary s2 = new Summary();
                                s2.Convert(d2);
                                System.out.println("*******************************************************************");
                                s2.inputRange();
                                System.out.println("*******************************************************************");
                                s2.display2();
                                System.out.println("*******************************************************************\n");
                                s2.grouping2(s2);
                                Display.display();
                                isInvalid = false;
                            }
                            case "3" -> {
                                Data d3 = Data.create3();
                                Summary s3 = new Summary();
                                s3.Convert(d3);
                                System.out.println("*******************************************************************");
                                s3.inputRange();
                                System.out.println("*******************************************************************");
                                s3.display3();
                                System.out.println("*******************************************************************\n");
                                s3.grouping3(s3);
                                Display.display();
                                isInvalid = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
