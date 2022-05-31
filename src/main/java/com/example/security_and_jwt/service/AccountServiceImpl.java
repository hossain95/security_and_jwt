package com.example.security_and_jwt.service;

import com.example.security_and_jwt.domain.Account;
import com.example.security_and_jwt.domain.Role;
import com.example.security_and_jwt.repo.AccountRepo;
import com.example.security_and_jwt.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

//    public AccountServiceImpl(AccountRepo accountRepo, RoleRepo roleRepo) {
//        this.accountRepo = accountRepo;
//        this.roleRepo = roleRepo;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        if (account == null){
            log.error("user not found in the database");
        }
        else{
            log.info("user found in the database {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), authorities);
    }

    @Override
    public Account saveAccount(Account account) {
        log.info("saving new user {} to the database", account.getName());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAccount(String username, String roleName) {
        log.info("adding role {} to user {} to the database", username, roleName);
        Account account = accountRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        account.getRoles().add(role);
    }

    @Override
    public Account getAccount(String username) {
        log.info("get username {}", username);
        return accountRepo.findByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        log.info("account list");
        return accountRepo.findAll();
    }


}
