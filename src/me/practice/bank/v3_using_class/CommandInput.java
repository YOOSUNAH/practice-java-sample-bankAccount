package me.practice.bank.v3_using_class;

import java.util.Scanner;

public class CommandInput {
    private static Scanner scanner = new Scanner(System.in);

    static String in() {
        return scanner.nextLine();
    }

}
