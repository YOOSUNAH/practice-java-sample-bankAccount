package me.practice.bank.v4_what_is_abstraction;

import java.util.List;
import java.util.Map;

public class AccountDepositService {

    private AccountQueryService accountQueryService = new AccountQueryService();

    public void deposit(List<Map<String, String>> accountList) {
        System.out.print("계좌번호: ");
        String bankCountNumber = CommandInput.in();
        System.out.print("예금액:");
        String depositAmount = CommandInput.in();
        System.out.println("결과: 예금이 성공되었습니다.");

        Map<String, String> account = accountQueryService.findMappedAccount(accountList, bankCountNumber);
        deposit(account, depositAmount);
    }

    private void deposit(Map<String, String> account, String depositAmount) {
        String savedAccountAmount = account.get("예금액");
        account.put("예금액", plus(savedAccountAmount, depositAmount));
    }

    private String plus(String savedAccountAmount, String depositAmount) {
        return String.valueOf(Integer.parseInt(savedAccountAmount) + Integer.parseInt(depositAmount));
    }

}
