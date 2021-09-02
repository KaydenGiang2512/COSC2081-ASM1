package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Summary extends Data{

    private int newCases;
    private int newDeaths;
    private int newVaccinated;

    public Summary(String newCases, String newDeaths, String newVaccinated) {
        //if newCases equals to none else convert newCases into Integer.
        this.newCases = newCases.equals("") ? 0 : Integer.parseInt(newCases);
        //if newDeaths equals to none else convert newDeaths into Integer.
        this.newDeaths = newDeaths.equals("") ? 0 : Integer.parseInt(newDeaths);
        //if newVaccinated equals to none else convert newVaccinated into Integer.
        this.newVaccinated = newVaccinated.equals("") ? 0 : Integer.parseInt(newVaccinated);
    }

    //The getters and setters for each variable

    public int getNewCases() {
        return newCases;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getNewVaccinations() {
        return newVaccinated;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public void setNewVaccinated(int newVaccinations) {
        this.newVaccinated = newVaccinated;
    }

    public void grouping1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                for (int i = 0; i < addRow1().size(); i = i + 2)
                {
                    System.out.println(addRow1().get(i));
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow1().size() / 2;
                int daysPerGroup = size / numGroup;
                int temp = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;
                int group = 1;

                ArrayList<String> list = new ArrayList<>();

                for (int i = 0; i < addRow1().size(); i += 2)
                {
                    list.add(addRow1().get(i));
                    if (moreDays > 0) {
                        daysPerGroup = temp + 1;
                    } else {
                        daysPerGroup = temp;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
            case 3 -> {
                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();
                int group = 1;

                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < addRow1().size(); i += 2) {
                    list.add(addRow1().get(i));

                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
        }
    }

    public void grouping2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                for (int i = 0; i < addRow2().size(); i = i + 2)
                {
                    System.out.println(addRow2().get(i));
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow2().size() / 2;
                int daysPerGroup = size / numGroup;
                int temp = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;
                int group = 1;

                ArrayList<String> list = new ArrayList<>();

                for (int i = 0; i < addRow2().size(); i += 2)
                {
                    list.add(addRow2().get(i));
                    if (moreDays > 0) {
                        daysPerGroup = temp + 1;
                    } else {
                        daysPerGroup = temp;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
            case 3 -> {
                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();
                int group = 1;

                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < addRow2().size(); i += 2) {
                    list.add(addRow2().get(i));

                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
        }
    }

    public void grouping3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                for (int i = 0; i < addRow3().size(); i = i + 2)
                {
                    System.out.println(addRow3().get(i));
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow3().size() / 2;
                int daysPerGroup = size / numGroup;
                int temp = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;
                int group = 1;

                ArrayList<String> list = new ArrayList<>();

                for (int i = 0; i < addRow3().size(); i += 2)
                {
                    list.add(addRow3().get(i));
                    if (moreDays > 0) {
                        daysPerGroup = temp + 1;
                    } else {
                        daysPerGroup = temp;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
            case 3 -> {
                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();
                int group = 1;

                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < addRow3().size(); i += 2) {
                    list.add(addRow2().get(i));

                    if (list.size() == daysPerGroup) {
                        System.out.println("Group " + group);
                        for (int j = 0; j < list.size();j++)
                        {
                            System.out.println(list.get(j));
                        }
                        list = new ArrayList<>();
                        System.out.println("\n");
                        group += 1;
                    }
                }
            }
        }
    }

    public void metric() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a metric: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");

        int metricOption = sc.nextInt();
        switch (metricOption) {
            case 1 -> {
                System.out.println("Hello World");
            }
            case 2 -> {
                System.out.println("Hello Guys");
            }
            case 3 -> {
                System.out.println("Hello");
            }
        }
    }
}
