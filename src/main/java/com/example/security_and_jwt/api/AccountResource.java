package com.example.security_and_jwt.api;

import com.example.security_and_jwt.domain.Account;
import com.example.security_and_jwt.domain.Role;
import com.example.security_and_jwt.service.AccountService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountResource {
    private final AccountService accountService;

    @GetMapping("/users")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok().body(accountService.getAccounts());
    }

    @PostMapping("/user/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.saveAccount(account));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> roleToUser(@RequestBody RoleToUserForm form){
        accountService.addRoleToAccount(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}