package me.practice.bank.v4_what_is_abstraction;

import java.util.List;
import java.util.Map;

public class AccountWithdrawService {
    private AccountQueryService accountQueryService = new AccountQueryService();

    public void withdraw(List<Map<String, String>> accountList) {
        System.out.print("계좌번호: ");
        String bankCountNumber = CommandInput.in();
        System.out.print("출금액:");
        String withdrawAmount = CommandInput.in();
        System.out.println("결과: 출금이 성공되었습니다.");

        Map<String, String> account = accountQueryService.findMappedAccount(accountList, bankCountNumber);
        withdraw(account, withdrawAmount);
    }


    private static void withdraw(Map<String, String> account, String dipositAmount) {
        String savedAccountAmount = account.get("출금액");
        account.put("출금액", minus(savedAccountAmount, dipositAmount));
    }

    private static String minus(String savedAccountAmount, String withdrawAmount) {
        return String.valueOf(Integer.parseInt(savedAccountAmount) - Integer.parseInt(withdrawAmount));
    }
}