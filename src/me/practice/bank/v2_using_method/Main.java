package me.practice.bank.v2_using_method;

import java.util.*;

public class Main {

    private static List<Map<String, String>> accountList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌 생성 | 2.계좌 목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");

            String input = in();

            if (input.equals("1")) {
                showCommand("계좌 생성");

                System.out.print("계좌번호: ");
                String bankCountNumber = in();
                System.out.print("계좌주:");
                String owner = in();
                System.out.print("초기입금액:");
                String firstDeposit = in();

                accountList.add(
                        createAccountMap(bankCountNumber, owner, firstDeposit)
                );

                System.out.println("결과: 계좌가 생성되었습니다.");
            } else if (input.equals("2")) {
                showCommand("계좌 목록");

                for (int i = 0; i < accountList.size(); i++) {
                    Map<String, String> account = accountList.get(i);
                    System.out.println(account.get("계좌번호") + "\t\t" + account.get("계좌주") + "\t\t" + account.get("예금액"));
                }

            } else if (input.equals("3")) {
                showCommand("예금");

                System.out.print("계좌번호: ");
                String bankCountNumber = in();
                System.out.print("예금액:");
                String depositAmount = in();
                System.out.println("결과: 예금이 성공되었습니다.");

                Map<String, String> account = findMappedAccount(bankCountNumber);
                deposit(account, depositAmount);

            } else if (input.equals("4")) {
                showCommand("출금");

                System.out.print("계좌번호: ");
                String bankCountNumber = in();
                System.out.print("출금액:");
                String withdrawAmount = in();
                System.out.println("결과: 출금이 성공되었습니다.");

                Map<String, String> account = findMappedAccount(bankCountNumber);
                withdraw(account, withdrawAmount);
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

    private static Map<String, String> createAccountMap(String bankCountNumber, String owner, String firstDeposit) {
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("계좌번호", bankCountNumber);
        accountMap.put("계좌주", owner);
        accountMap.put("예금액", firstDeposit);
        return accountMap;
    }

    private static String in() {
        return scanner.nextLine();
    }

    private static void deposit(Map<String, String> account, String depositAmount) {
        String savedAccountAmount = account.get("예금액");
        account.put("예금액", plus(savedAccountAmount, depositAmount));
    }

    private static void withdraw(Map<String, String> account, String withdrawAmount) {
        String savedAccountAmount = account.get("예금액");
        account.put("예금액", minus(savedAccountAmount, withdrawAmount));
    }

    private static String plus(String savedAccountAmount, String depositAmount) {
        return String.valueOf(Integer.parseInt(savedAccountAmount) + Integer.parseInt(depositAmount));
    }

    private static String minus(String savedAccountAmount, String withdrawAmount) {
        return String.valueOf(Integer.parseInt(savedAccountAmount) - Integer.parseInt(withdrawAmount));
    }

    private static Map<String, String> findMappedAccount(String bankCountNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            Map<String, String> account = accountList.get(i);
            String accountNumber = account.get("계좌번호");
            if (bankCountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

}