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
                String[] temp = getColumn1(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newCases1(); //Calling the newCases1 method to calculate the results
            }
            case 2 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn1(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newDeaths1(); //Calling the newDeaths1 method to calculate the results
            }
            case 3 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn1(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newVaccinated1(); //Calling the newVaccinated1 method to calculate the results
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn1(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newCases1();
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn1(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newDeaths1();
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn1(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newVaccinated1();
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
                String[] temp = getColumn2(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newCases2(); //Calling the newCases2 method to calculate the results
            }
            case 2 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn2(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newDeaths2(); //Calling the newDeaths2 method to calculate the results
            }
            case 3 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn2(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newVaccinated2(); //Calling the newVaccinated2 method to calculate the results
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn2(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newCases2();
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn2(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newDeaths2();
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn2(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newVaccinated2();
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
                String[] temp = getColumn3(data, 4);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newCases3(); //Calling the newCases3 method to calculate the results
            }
            case 2 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn3(data, 5);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newDeaths3(); //Calling the newDeaths3 method to calculate the results
            }
            case 3 -> {
                System.out.println("****************************************************");
                String[] temp = getColumn3(data, 6);
                method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                newVaccinated3(); //Calling the newVaccinated3 method to calculate the results
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    metricOption = sc.nextInt();

                    switch (metricOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            String[] temp = getColumn3(data, 4);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newCases3();
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("****************************************************");
                            System.out.println("Deaths: \n");
                            String[] temp = getColumn3(data, 5);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newDeaths3();
                            isInvalid = false;
                        }
                        case 3 -> {
                            System.out.println("****************************************************");
                            System.out.println("People Vaccinated: \n");
                            String[] temp = getColumn3(data, 6);
                            method = new ArrayList<>(Arrays.asList(temp)); //Convert String[] into ArrayList
                            newVaccinated3();
                            isInvalid = false;
                        }
                    }
                }
            }
        }
        return method;
    }

    //These method prompts the user to choose between new total/up to result types for the new positive cases
    public void newCases1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Cases: " + newTotalCases1() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newCases2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Cases: " + newTotalCases2() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newCases3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Cases: " + newTotalCases3() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //These method prompts the user to choose between new total/up to result types for the new deaths
    public void newDeaths1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Deaths: " + newTotalDeaths1() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newDeaths2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Deaths: " + newTotalDeaths2() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newDeaths3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total Deaths: " + newTotalDeaths3() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //These method prompts the user to choose between new total/up to result types for the new vaccinated people
    public void newVaccinated1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total People Vaccinated: " + newTotalVaccinated1() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newVaccinated2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total People Vaccinated: " + newTotalVaccinated2() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    public void newVaccinated3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are 2 different results types: ");
        System.out.println("1. New Total");
        System.out.println("2. Up to");
        System.out.print("\nPlease select an option 1-2: ");
        int resultOption = sc.nextInt();

        switch (resultOption) {
            case 1 -> {
                System.out.println("****************************************************");
                System.out.println("New Total People Vaccinated: " + newTotalVaccinated3() + "\n");
            }
            case 2 -> System.out.println("To be completed");
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-3: ");
                    resultOption = sc.nextInt();

                    switch (resultOption) {
                        case 1 -> {
                            System.out.println("****************************************************");
                            System.out.println("New Total Cases: " + newTotalCases1() + "\n");
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }

    //This method retrieves data from the specified index of the csv file for the calculation methods to use
    public String[] getColumn(int columnIndex) {
        ArrayList<String> rows = getAllRows();
        String[] values = new String[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            String[] columns = rows.get(i).split(",");
            values[i] = columnIndex < columns.length ? columns[columnIndex] : "0";
            if (values[i].equals("")) {
                values[i] = "0";
            }
        }
        return values;
    }

    //These methods calculates the total number of positive cases by adding all the values of the specified index
    public int newTotalCases1() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = getAllRows().indexOf(getStopRow());
        int newTotalCases = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalCases += Integer.parseInt(getColumn(4)[i]);
        }
        return newTotalCases;
    }

    public int newTotalCases2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = fromIndex + range;
        int newTotalCases = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalCases += Integer.parseInt(getColumn(4)[i]);
        }
        return newTotalCases;
    }

    public int newTotalCases3() {
        int toIndex = getAllRows().indexOf(getStopRow());
        int fromIndex = toIndex - range;
        int newTotalCases = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalCases += Integer.parseInt(getColumn(4)[i]);
        }
        return newTotalCases;
    }

    //These methods calculates the total number of deaths by adding all the values of the specified index
    public int newTotalDeaths1() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = getAllRows().indexOf(getStopRow());
        int newTotalDeaths = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalDeaths += Integer.parseInt(getColumn(5)[i]);
        }
        return newTotalDeaths;
    }

    public int newTotalDeaths2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = fromIndex + range;
        int newTotalDeaths = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalDeaths += Integer.parseInt(getColumn(5)[i]);
        }
        return newTotalDeaths;
    }

    public int newTotalDeaths3() {
        int toIndex = getAllRows().indexOf(getStopRow());
        int fromIndex = toIndex - range;
        int newTotalDeaths = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalDeaths += Integer.parseInt(getColumn(5)[i]);
        }
        return newTotalDeaths;
    }

    //These methods calculates the total number of vaccinated people by adding all the values of the specified index
    public int newTotalVaccinated1() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = getAllRows().indexOf(getStopRow());
        int newTotalVaccinated = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalVaccinated += Integer.parseInt(getColumn(6)[i]);
        }
        return newTotalVaccinated;
    }

    public int newTotalVaccinated2() {
        int fromIndex = getAllRows().indexOf(getStartRow());
        int toIndex = fromIndex + range;
        int newTotalVaccinated = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalVaccinated += Integer.parseInt(getColumn(6)[i]);
        }
        return newTotalVaccinated;
    }

    public int newTotalVaccinated3() {
        int toIndex = getAllRows().indexOf(getStopRow());
        int fromIndex = toIndex - range;
        int newTotalVaccinated = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            newTotalVaccinated += Integer.parseInt(getColumn(6)[i]);
        }
        return newTotalVaccinated;
    }
}