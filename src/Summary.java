package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    public void grouping() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                System.out.println(addRow2());
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int chunkSize = sc.nextInt() ;

                List<String> list = new ArrayList(addRow2());

                AtomicInteger counter = new AtomicInteger();
                final Collection<List<String>> partitionedList =
                        list.stream().collect(Collectors.groupingBy(i -> counter.getAndIncrement() / chunkSize))
                                .values();
                for(List<String> subList : partitionedList) {
                    System.out.println(subList);
                }
            }
            case 3 -> {
                System.out.println("Enter number of days in a group: ");
                int groupNum = sc.nextInt();

                ArrayList<Data> newGroup = new ArrayList<>();

                //for (int i = 0; i < TOTAL DAYS; i++;)
                // group.add

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

            }
            case 2 -> {

            }
            case 3 -> {

            }
        }
    }
}
