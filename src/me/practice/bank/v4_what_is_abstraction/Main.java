package me.practice.bank.v4_what_is_abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Map<String, String>> accountList = new ArrayList<>();
    private static AccountCreateService accountCreateService = new AccountCreateServiceImpl();
    private static AccountShowService accountShowService = new AccountShowService();
    private static AccountDepositService accountDepositService = new AccountDepositService();
    private static AccountWithdrawService accountWithdrawService = new AccountWithdrawService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌 생성 | 2.계좌 목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");

            String input = CommandInput.in();

            if (input.equals("1")) {
                showCommand("계좌 생성");
                accountCreateService.create(accountList);

            } else if (input.equals("2")) {
                showCommand("계좌 목록");
                accountShowService.list(accountList);

            } else if (input.equals("3")) {
                showCommand("예금");
                accountDepositService.deposit(accountList);

            } else if (input.equals("4")) {
                showCommand("출금");
                accountWithdrawService.withdraw(accountList);

            } else if (input.equals("5")) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    private static void showCommand(String command){
        System.out.println("-------------");
        System.out.println(command);
        System.out.println("-------------");
    }









}