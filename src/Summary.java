package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Summary {
    public static Summary grouping() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        Group group = null;
        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                System.out.println("[Start Date: "  + "; End Data: " + "]");
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int groupNum = sc.nextInt();

                //method: find day per group = total days / groupNum
                //Temp = day per group
                // group with more days = total days - day per group * groupNum

                ArrayList<Data> newGroup = new ArrayList<>();

            }
            case 3 -> {
                System.out.println("Enter number of days in a group: ");
                int groupNum = sc.nextInt();

                ArrayList<Data> newGroup = new ArrayList<>();

                //for (int i = 0; i < TOTAL DAYS; i++;)
                // group.add

            }
        }
        return null;


    }
}

