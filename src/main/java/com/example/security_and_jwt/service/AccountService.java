package com.example.security_and_jwt.service;

import com.example.security_and_jwt.domain.Account;
import com.example.security_and_jwt.domain.Role;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);
    Role saveRole(Role role);
    void addRoleToAccount(String username, String roleName);
    Account getAccount(String username);
    List<Account>getAccounts();
}
