package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String convert = "";
        Scanner scan = new Scanner(System.in);
        Calc c = new Calc();

        while (true) {
            System.out.println("Введите формулу -> ");
            c.compile(scan.nextLine().toCharArray());
            convert = Integer.toHexString(c.hex);
            System.out.println(convert);
        }
    }
}