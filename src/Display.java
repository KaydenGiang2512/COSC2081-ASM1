import java.util.*;

public class Display extends Data {

    public static void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a display option: ");
        System.out.println("1. Tabular");
        System.out.println("2. Chart");

        int option = sc.nextInt();

        switch(option) {
            case 1 -> Tabular.tabular();
            case 2 -> Chart.chart();
        }
    }
    public static void main(String[] args) {
        display();
    }
}
