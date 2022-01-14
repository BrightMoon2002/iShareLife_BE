package com.example.isharelife.controller.authController;

import com.example.isharelife.dto.request.ChangeAvatar;
import com.example.isharelife.dto.request.SignInForm;
import com.example.isharelife.dto.request.SignUpForm;
import com.example.isharelife.dto.response.JwtResponse;
import com.example.isharelife.dto.response.ResponseMessage;
import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.account.Role;
import com.example.isharelife.model.account.RoleName;
import com.example.isharelife.security.jwt.JwtProvider;
import com.example.isharelife.security.userprincipal.AccountDetailService;
import com.example.isharelife.security.userprincipal.AccountPrinciple;
import com.example.isharelife.service.impl.AccountServiceImpl;
import com.example.isharelife.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private RoleServiceImpl roleService;
    //mã háo mật khẩu
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountDetailService accountDetailService;

    // đã có bean bên config
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (accountService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("The username existed! Please try again!"), HttpStatus.OK);
        }

        if (accountService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("The email existed! Please try again!"), HttpStatus.OK);
        }
        if(signUpForm.getAvatar() == null || signUpForm.getAvatar().trim().isEmpty()){
            signUpForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/chinhbeo-18d3b.appspot.com/o/avatar.png?alt=media&token=3511cf81-8df2-4483-82a8-17becfd03211");
        }
        //user được tạo ra cho vào database được mã hoá password bằng cái passwordEncoder
        Account account = new Account(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getAvatar());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow( ()-> new RuntimeException("Role not found")
                    );
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow( ()-> new RuntimeException("Role not found")
                    );
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow( ()-> new RuntimeException("Role not found")
                    );
                    roles.add(userRole);
            }
        });
        account.setRoles(roles);
        //save vào database
        accountService.save(account);
        return new ResponseEntity<>(new ResponseMessage("Create user success!"), HttpStatus.OK);
    }

    // hàm login

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(),
                        signInForm.getPassword())
        );
        //kho chứa cho authentication
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(accountPrinciple.getId(), token, accountPrinciple.getName(), accountPrinciple.getAvatar(),  accountPrinciple.getUsername(), accountPrinciple.getAuthorities()));
    }
    @GetMapping
    public ResponseEntity<?> showAllAccount() {
        Iterable<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/account-details")
    public ResponseEntity<?> findAccountById() {
        Account account = accountDetailService.getCurrentUser();
        if (account == null) {
            return new ResponseEntity<>(new ResponseMessage("no_account"), HttpStatus.OK);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/change-avatar")
    public ResponseEntity<?> updateAvatar(@RequestBody ChangeAvatar changeAvatar){
        Account account = accountDetailService.getCurrentUser();
        System.out.println(account.getUsername());
        System.out.println(account.getName());
        System.out.println(account.getAvatar());
        System.out.println(account.getId());
        if(account.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponseMessage("Please login!"), HttpStatus.OK);
        }
        account.setAvatar(changeAvatar.getAvatar());
        accountService.save(account);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PutMapping("/change-info")
    public ResponseEntity<?> updateInfo(@RequestBody Account account) {
        Account accountCurrent = accountDetailService.getCurrentUser();
    if (accountCurrent.getUsername().equals("Anonymous")) {
        return new ResponseEntity<>(new ResponseMessage("Please login!"), HttpStatus.OK);
    }
    accountCurrent.setName(account.getName());
    accountCurrent.setEmail(account.getEmail());
    accountCurrent.setPassword(account.getPassword());
    accountCurrent.setUsername(account.getUsername());
    accountCurrent.setAddress(account.getAddress());
    accountCurrent.setPhone(account.getPhone());
    accountCurrent.setHobbies(account.getHobbies());
    accountService.save(accountCurrent);
    return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showAccountByIdOther(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findAccountById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(new ResponseMessage("no_account"), HttpStatus.OK);
        }
        return new ResponseEntity<>(accountOptional.get(), HttpStatus.OK);
    }
}
