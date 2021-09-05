import java.util.*;

public class Summary extends Data {
    //Get the index column for case 1
    public static String[] getColumn1(Data data, int columnIndex) {
        String[] columns;
        ArrayList<String> rows = data.addRow1();
        String[] values = new String[rows.size()];
        for (int i = 0; i < rows.size(); i += 2) {
            columns = rows.get(i).split(",");
            values[i] = columnIndex < columns.length ? columns[columnIndex] : "0";
        }
        return values;
    }

    //Get the index column for case 2
    public static String[] getColumn2(Data data, int columnIndex) {
        String[] columns;
        ArrayList<String> rows = data.addRow2();
        String[] values = new String[rows.size()];
        for (int i = 0; i < rows.size(); i += 2) {
            columns = rows.get(i).split(",");
            values[i] = columnIndex < columns.length ? columns[columnIndex] : "0";
        }
        return values;
    }

    //Get the index column for case 1
    public static String[] getColumn3(Data data, int columnIndex) {
        String[] columns;
        ArrayList<String> rows = data.addRow3();
        String[] values = new String[rows.size()];
        for (int i = 0; i < rows.size(); i += 2) {
            columns = rows.get(i).split(",");
            values[i] = columnIndex < columns.length ? columns[columnIndex] : "0";
        }
        return values;
    }

    public void noGrouping1(Data data) {
        String[] temp = getColumn1(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric1(data);
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
            array.add(stringList.get(i));
            array.add(methodList.get(i));
            System.out.println(array);
            array = new ArrayList<>();
        }
    }

    public void noGrouping2(Data data) {
        String[] temp = getColumn2(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric2(data);
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
            array.add(stringList.get(i));
            array.add(methodList.get(i));
            System.out.println(array);
            array = new ArrayList<>();
        }
    }

    public void noGrouping3(Data data) {
        String[] temp = getColumn3(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric3(data);
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
            array.add(stringList.get(i));
            array.add(methodList.get(i));
            System.out.println(array);
            array = new ArrayList<>();
        }
    }

    public void numberOfGroups1(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of groups: ");
        int numGroup = sc.nextInt() ;
        int size = addRow1().size() / 2;

        //Number of groups input validation
        while (numGroup > size || numGroup <= 0) {
            System.out.print("Please enter a valid number of groups: ");
            numGroup = sc.nextInt();
        }

        int daysPerGroup = size / numGroup;
        int index = daysPerGroup;
        int moreDays = size - daysPerGroup * numGroup;

        String[] temp = getColumn1(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric1(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    public void numberOfGroups2(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of groups: ");
        int numGroup = sc.nextInt() ;
        int size = addRow2().size() / 2;

        //Number of groups input validation
        while (numGroup > size || numGroup <= 0) {
            System.out.print("Please enter a valid number of groups: ");
            numGroup = sc.nextInt();
        }

        int daysPerGroup = size / numGroup;
        int index = daysPerGroup;
        int moreDays = size - daysPerGroup * numGroup;

        String[] temp = getColumn2(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric2(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    public void numberOfGroups3(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of groups: ");
        int numGroup = sc.nextInt() ;
        int size = addRow3().size() / 2;

        //Number of groups input validation
        while (numGroup > size || numGroup <= 0) {
            System.out.print("Please enter a valid number of groups: ");
            numGroup = sc.nextInt();
        }

        int daysPerGroup = size / numGroup;
        int index = daysPerGroup;
        int moreDays = size - daysPerGroup * numGroup;

        String[] temp = getColumn3(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        List<String> methodList = metric3(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    public void numberOfDaysPerGroup1(Data data) {
        String[] temp = getColumn1(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        int listSize = stringList.size() / 2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days in each group: ");
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

        List<String> methodList = metric1(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    public void numberOfDaysPerGroup2(Data data) {
        String[] temp = getColumn2(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        int listSize = stringList.size() / 2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days in each group: ");
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

        List<String> methodList = metric2(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    public void numberOfDaysPerGroup3(Data data) {
        String[] temp = getColumn3(data, 3);
        List<String> stringList = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
        int listSize = stringList.size() / 2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days in each group: ");
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

        List<String> methodList = metric3(data);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i += 2) {
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
                list = new ArrayList<>();
                moreDays -= 1;
                System.out.println("\n");
            }
        }
    }

    //Grouping methods for case 1
    public void grouping1(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 3 different grouping methods: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");
        System.out.print("\nPlease select an option 1-3: ");
        int groupOption = sc.nextInt();

        switch (groupOption) {
            case 1 -> noGrouping1(data);
            case 2 -> numberOfGroups1(data);
            case 3 -> numberOfDaysPerGroup1(data);
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    groupOption = sc.nextInt();

                    switch (groupOption) {
                        case 1 -> {
                            noGrouping1(data);
                            isInvalid = false;
                        }
                        case 2 -> {
                            numberOfGroups1(data);
                            isInvalid = false;
                        }
                        case 3 -> {
                            numberOfDaysPerGroup1(data);
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //Grouping methods for case 2
    public void grouping2(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 3 different grouping methods: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");
        System.out.print("\nPlease select an option 1-3: ");
        int groupOption = sc.nextInt();

        switch (groupOption) {
            case 1 -> noGrouping2(data);
            case 2 -> numberOfGroups2(data);
            case 3 -> numberOfDaysPerGroup2(data);
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    groupOption = sc.nextInt();

                    switch (groupOption) {
                        case 1 -> {
                            noGrouping2(data);
                            isInvalid = false;
                        }
                        case 2 -> {
                            numberOfGroups2(data);
                            isInvalid = false;
                        }
                        case 3 -> {
                            numberOfDaysPerGroup2(data);
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //Grouping methods for case 3
    public void grouping3(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 3 different grouping methods: ");
        System.out.println("1. No grouping");
        System.out.println("2. Number of groups");
        System.out.println("3. Number of days per group");
        System.out.print("\nPlease select an option 1-3: ");
        int groupOption = sc.nextInt();

        switch (groupOption) {
            case 1 -> noGrouping3(data);
            case 2 -> numberOfGroups3(data);
            case 3 -> numberOfDaysPerGroup3(data);
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    groupOption = sc.nextInt();

                    switch (groupOption) {
                        case 1 -> {
                            noGrouping3(data);
                            isInvalid = false;
                        }
                        case 2 -> {
                            numberOfGroups3(data);
                            isInvalid = false;
                        }
                        case 3 -> {
                            numberOfDaysPerGroup3(data);
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //Metric for case 1
    public List<String> metric1(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("There are 3 different metrics: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        System.out.print("\nPlease select an option 1-3: ");
        int metricOption = sc.nextInt();
        List<String> method = null;

        switch (metricOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("Positive Cases: \n");
                String[] temp = getColumn1(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 2 -> {
                System.out.println("****************************************************");
                System.out.println("Deaths: \n");
                String[] temp = getColumn1(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("****************************************************");
                System.out.println("People Vaccinated: \n");
                String[] temp = getColumn1(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("Positive Cases: \n");
                            String[] temp = getColumn1(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            System.out.println("Deaths: \n");
                            String[] temp = getColumn1(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            System.out.println("People Vaccinated: \n");
                            String[] temp = getColumn1(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                    }
                }
            }
        }
        return method;
    }

    //Metric for case 2
    public List<String> metric2(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("There are 3 different metrics: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        System.out.print("\nPlease select an option 1-3: ");
        int metricOption = sc.nextInt();
        List<String> method = null;

        switch (metricOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("Positive Cases: \n");
                String[] temp = getColumn2(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 2 -> {
                System.out.println("****************************************************");
                System.out.println("Deaths: \n");
                String[] temp = getColumn2(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("****************************************************");
                System.out.println("People Vaccinated: \n");
                String[] temp = getColumn2(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("Positive Cases: \n");
                            String[] temp = getColumn2(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            System.out.println("Deaths: \n");
                            String[] temp = getColumn2(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            System.out.println("People Vaccinated: \n");
                            String[] temp = getColumn2(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                    }
                }
            }
        }
        return method;
    }

    //Metric for case 3
    public List<String> metric3(Data data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("There are 3 different metrics: ");
        System.out.println("1. Positive Cases");
        System.out.println("2. Deaths");
        System.out.println("3. People Vaccinated");
        System.out.print("\nPlease select an option 1-3: ");
        int metricOption = sc.nextInt();
        List<String> method = null;

        switch (metricOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("Positive Cases: \n");
                String[] temp = getColumn3(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 2 -> {
                System.out.println("****************************************************");
                System.out.println("Deaths: \n");
                String[] temp = getColumn3(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            case 3 -> {
                System.out.println("****************************************************");
                System.out.println("People Vaccinated: \n");
                String[] temp = getColumn3(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("Positive Cases: \n");
                            String[] temp = getColumn3(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            System.out.println("Deaths: \n");
                            String[] temp = getColumn3(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            System.out.println("People Vaccinated: \n");
                            String[] temp = getColumn3(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            isInvalid = false;
                        }
                    }
                }
            }
        }
        return method;
    }
}