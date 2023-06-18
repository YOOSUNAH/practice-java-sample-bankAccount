package me.practice.bank.v4_what_is_abstraction;

import java.util.List;
import java.util.Map;

public class AccountQueryService {

    Map<String, String> findMappedAccount(
            List<Map<String, String>> accountList,
            String bankCountNumber
    ) {
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
