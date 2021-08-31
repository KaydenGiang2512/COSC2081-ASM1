package com.company;

public class Chart {
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

    public static void main (String[] args) {
        chart();
    }
}
