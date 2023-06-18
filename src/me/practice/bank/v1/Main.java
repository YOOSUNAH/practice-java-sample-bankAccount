package me.practice.bank.v1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Map<String, String>> accountList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌 생성 | 2.계좌 목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");
            String input = scanner.nextLine();
            Map<String, String> accountMap = null;
            if (input.equals("1")) {
                System.out.println("-------------");
                System.out.println("계좌 생성");
                System.out.println("-------------");
                System.out.print("계좌번호: ");
                String bankCountNumber = scanner.nextLine();
                System.out.print("계좌주:");
                String owner = scanner.nextLine();
                System.out.print("초기입금액:");
                String firstDeposit = scanner.nextLine();

                accountMap = new HashMap<>();
                accountMap.put("계좌번호", bankCountNumber);
                accountMap.put("계좌주", owner);
                accountMap.put("예금액", firstDeposit);

                accountList.add(accountMap);

                System.out.println("결과: 계좌가 생성되었습니다.");
            } else if (input.equals("2")) {
                System.out.println("-------------");
                System.out.println("계좌 목록");
                System.out.println("-------------");

                for (int i = 0; i < accountList.size(); i++) {
                    Map<String, String> account = accountList.get(i);
                    System.out.println(account.get("계좌번호") + "\t\t" + account.get("계좌주") + "\t\t" + account.get("예금액"));
                }

            } else if (input.equals("3")) {
                System.out.println("예금");
                System.out.println("-------------");
                System.out.print("계좌번호: ");
                String bankCountNumber = scanner.nextLine();
                System.out.print("예금액:");
                String deposit = scanner.nextLine();
                System.out.println("결과: 예금이 성공되었습니다.");

                for (int i = 0; i < accountList.size(); i++) {
                    Map<String, String> account = accountList.get(i);
                    String accountNumber = account.get("계좌번호");
                    if (bankCountNumber.equals(accountNumber)) {
                        String savedAccountAmount = account.get("예금액");
                        account.put("예금액", String.valueOf(Integer.parseInt(savedAccountAmount) + Integer.parseInt(deposit)));
                    }
                }

            } else if (input.equals("4")) {
                System.out.println("출금");
                System.out.println("-------------");
                System.out.print("계좌번호: ");
                String bankCountNumber = scanner.nextLine();
                System.out.print("출금액:");
                String withdraw = scanner.nextLine();
                System.out.println("결과: 출금이 성공되었습니다.");

                for (int i = 0; i < accountList.size(); i++) {
                    Map<String, String> account = accountList.get(i);
                    String accountNumber = account.get("계좌번호");
                    if (bankCountNumber.equals(accountNumber)) {
                        String savedAccountAmount = account.get("예금액");
                        account.put("예금액", String.valueOf(Integer.parseInt(savedAccountAmount) - Integer.parseInt(withdraw)));
                    }

                }

            } else if (input.equals("5")) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}