package me.practice.bank.v4_what_is_abstraction;

import java.util.Scanner;

public class CommandInput {
    private static Scanner scanner = new Scanner(System.in);

    static String in() {
        return scanner.nextLine();
    }

}
