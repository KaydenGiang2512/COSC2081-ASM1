import java.util.*;

public class Display extends Data {
    public static void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n****************************************************");
        System.out.println("There are 2 display options: ");
        System.out.println("1. Tabular");
        System.out.println("2. Chart");
        System.out.print("Please select an option 1-2: ");
        int displayOption = sc.nextInt();

        switch(displayOption) {
            case 1 -> Tabular.tabular();
            case 2 -> {
                System.out.println("To be completed");
                Chart.chart();
            }
            default -> {
                boolean isInvalid = true;
                while (isInvalid) {
                    System.out.print("Invalid selection! Please select an option 1-2: ");
                    displayOption = sc.nextInt();

                    switch (displayOption) {
                        case 1 -> {
                            Tabular.tabular();
                            isInvalid = false;
                        }
                        case 2 -> {
                            System.out.println("To be completed");
                            Chart.chart();
                            isInvalid = false;
                        }
                    }
                }
            }
        }
    }
}
