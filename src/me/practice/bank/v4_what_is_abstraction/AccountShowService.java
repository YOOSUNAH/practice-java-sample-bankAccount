package me.practice.bank.v4_what_is_abstraction;

import java.util.List;
import java.util.Map;

public class AccountShowService {

    public void list(List<Map<String, String>> accountList) {
        for (int i = 0; i < accountList.size(); i++) {
            Map<String, String> account = accountList.get(i);
            System.out.println(
                account.get("계좌번호") + "\t\t" +
                account.get("계좌주") + "\t\t" +
                account.get("예금액")
            );
        }
    }
}
