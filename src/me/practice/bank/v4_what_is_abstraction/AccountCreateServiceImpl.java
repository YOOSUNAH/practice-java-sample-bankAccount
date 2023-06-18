package me.practice.bank.v4_what_is_abstraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountCreateServiceImpl implements AccountCreateService {

    public void create(List<Map<String, String>> accountList) {
        System.out.print("계좌번호: ");
        String bankCountNumber = CommandInput.in();
        System.out.print("계좌주:");
        String owner = CommandInput.in();
        System.out.print("초기입금액:");
        String firstDeposit = CommandInput.in();

        accountList.add(createAccountMap(bankCountNumber, owner, firstDeposit));
        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    private static Map<String, String> createAccountMap(String bankCountNumber, String owner, String firstDeposit) {
        Map<String, String> accountMap = new HashMap<>();
        accountMap.put("계좌번호", bankCountNumber);
        accountMap.put("계좌주", owner);
        accountMap.put("예금액", firstDeposit);
        return accountMap;
    }
}
