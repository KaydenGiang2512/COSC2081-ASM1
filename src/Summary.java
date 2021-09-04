package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Summary extends Data{

    private int newCases;
    private int newDeaths;
    private int newVaccinated;

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

    //Grouping methods for case 1
    public void grouping1(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                String[] temp = getColumn1(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric1(data);

                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2) {
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array = new ArrayList<String>();
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow1().size() / 2;
                int daysPerGroup = size / numGroup;
                int index = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;

                String[] temp = getColumn1(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric1(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        daysPerGroup = index + 1;
                    } else {
                        daysPerGroup = index;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
            case 3 -> {
                String[] temp = getColumn1(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                int listSize = stringList.size() / 2;

                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();

                //To make sure that the number of days input is divided my the size of data.
                while (listSize % daysPerGroup != 0) {
                    System.out.println("Cannot divide the groups equally.");
                    System.out.print("Please enter another number: ");
                    daysPerGroup = sc.nextInt();
                }

                int size = addRow1().size() / 2;
                int numGroup = size / daysPerGroup;
                int index = daysPerGroup;
                int moreDays = size - numGroup * daysPerGroup;

                List<String> methodList = data.metric1(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();
                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        numGroup = index + 1;
                    } else {
                        numGroup = index;
                    }
                    if (list.size() == numGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    //Grouping methods for case 2
    public void grouping2(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                String[] temp = getColumn2(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric2(data);

                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2) {
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array = new ArrayList<String>();
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow2().size() / 2;
                int daysPerGroup = size / numGroup;
                int index = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;

                String[] temp = getColumn2(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric2(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        daysPerGroup = index + 1;
                    } else {
                        daysPerGroup = index;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
            case 3 -> {
                String[] temp = getColumn2(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                int listSize = stringList.size() / 2;

                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();

                //To make sure that the number of days input is divided my the size of data.
                while (listSize % daysPerGroup != 0) {
                    System.out.println("Cannot divide the groups equally.");
                    System.out.print("Please enter another number: ");
                    daysPerGroup = sc.nextInt();
                }

                int size = addRow2().size() / 2;
                int numGroup = size / daysPerGroup;
                int index = daysPerGroup;
                int moreDays = size - numGroup * daysPerGroup;

                List<String> methodList = data.metric2(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();
                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        numGroup = index + 1;
                    } else {
                        numGroup = index;
                    }
                    if (list.size() == numGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    //Grouping methods for case 3
    public void grouping3(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a grouping method: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");

        int groupOption = sc.nextInt();
        switch (groupOption) {
            case 1 -> {
                String[] temp = getColumn3(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric3(data);

                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2) {
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array = new ArrayList<String>();
                }
            }
            case 2 -> {
                System.out.println("Enter number of groups: ");
                int numGroup = sc.nextInt() ;
                int size = addRow3().size() / 2;
                int daysPerGroup = size / numGroup;
                int index = daysPerGroup;
                int moreDays = size - daysPerGroup * numGroup;

                String[] temp = getColumn3(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                List<String> methodList = data.metric3(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();

                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        daysPerGroup = index + 1;
                    } else {
                        daysPerGroup = index;
                    }
                    if (list.size() == daysPerGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
            case 3 -> {
                String[] temp = getColumn3(data, 3);
                List<String> stringList = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
                int listSize = stringList.size() / 2;

                System.out.println("Enter number of days in a group: ");
                int daysPerGroup = sc.nextInt();

                //To make sure that the number of days input is divided my the size of data.
                while (listSize % daysPerGroup != 0) {
                    System.out.println("Cannot divide the groups equally.");
                    System.out.print("Please enter another number: ");
                    daysPerGroup = sc.nextInt();
                }

                int size = addRow3().size() / 2;
                int numGroup = size / daysPerGroup;
                int index = daysPerGroup;
                int moreDays = size - numGroup * daysPerGroup;

                List<String> methodList = data.metric3(data);

                ArrayList<String> list = new ArrayList<>();
                ArrayList<String> array = new ArrayList<String>();
                for (int i = 0; i < stringList.size(); i += 2)
                {
                    list.add(stringList.get(i));
                    array.add(stringList.get(i));
                    array.add(methodList.get(i));
                    System.out.println(array);
                    array.remove(0);
                    array.remove(0);
                    if (moreDays > 0) {
                        numGroup = index + 1;
                    } else {
                        numGroup = index;
                    }
                    if (list.size() == numGroup) {
                        System.out.println("-----------------");

                        for (int j = 0; j < array.size();j++)
                        {
                            list.get(j);
                        }
                        list = new ArrayList<>();
                        moreDays -= 1;
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    //Metric for case 1
    public List<String> metric1(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a metric: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        List<String> method = null;
        int metricOption = sc.nextInt();
        switch (metricOption) {
            case 1 -> {
                System.out.println("Positive Cases: ");
                String[] temp = getColumn1(data, 4);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList

            }
            case 2 -> {
                System.out.println("Deaths: ");
                String[] temp = getColumn1(data, 5);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("People Vaccinated: ");
                String[] temp = getColumn1(data, 6);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
        }
        return method;
    }

    //Metric for case 2
    public List<String> metric2(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a metric: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        List<String> method = null;
        int metricOption = sc.nextInt();
        switch (metricOption) {
            case 1 -> {
                System.out.println("Positive Cases: ");
                String[] temp = getColumn2(data, 4);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList

            }
            case 2 -> {
                System.out.println("Deaths: ");
                String[] temp = getColumn2(data, 5);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("People Vaccinated: ");
                String[] temp = getColumn2(data, 6);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
        }
        return method;
    }

    //Metric for case 3
    public List<String> metric3(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a metric: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        List<String> method = null;
        int metricOption = sc.nextInt();
        switch (metricOption) {
            case 1 -> {
                System.out.println("Positive Cases: ");
                String[] temp = getColumn3(data, 4);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList

            }
            case 2 -> {
                System.out.println("Deaths: ");
                String[] temp = getColumn3(data, 5);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("People Vaccinated: ");
                String[] temp = getColumn3(data, 6);
                method = new ArrayList<String>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
        }
        return method;
    }
}
