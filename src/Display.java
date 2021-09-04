import java.util.*;

public class Display extends Data {
    public static void chart() {
        int ver = 24;
        int hor = 80;

        Character[][] chart = new Character[ver][hor];

        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                chart[i][j] = ' ';
            }
        }

        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                if (i == ver - 1) {
                    chart[i][j] = '_';
                }
                if (j == 0) {
                    chart[i][j] = '|';
                }
            }
        }

        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                if (j != hor - 1) {
                    System.out.print(chart[i][j]);
                } else {
                    System.out.println(chart[i][j]);
                }
            }
        }
    }

    public static void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a display option: ");
        System.out.println("1. Tabular");
        System.out.println("2. Chart");

        int option = sc.nextInt();

        switch(option) {
            case 1 -> {
                com.company.Tabular data = new com.company.Tabular();
                data.setShowVerticalLines(true);
                data.setHeaders("Range", "Value");
                data.addRow("", "");
                data.addRow("", "");
                data.addRow("", "");
                data.print();
            }
            case 2 -> {
                chart();
            }
        }
    }

    public static void main(String[] args) {
        display();
    }
}
