package me.practice.bank.v4_what_is_abstraction;

import java.util.List;
import java.util.Map;

public interface AccountCreateService {

    void create(List<Map<String, String>> accountList);

}
