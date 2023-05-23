package com.example.shipreservationsystem.resource.page;

import com.example.shipreservationsystem.repos.AdminUserRepo;
import com.example.shipreservationsystem.ro.Passwords;
import com.example.shipreservationsystem.ro.ResponseRO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/page/admin/")
public class AdminPageController {

    @Autowired
    AdminUserRepo adminRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/")
    public String updatePassword(Model model){
        model.addAttribute("passwords", new Passwords());
        return "ChangePassword";
    }





    @PostMapping(value = "/")
    public String changePassword(@ModelAttribute("passwords") Passwords passwords, BindingResult bindingResult) {

//        Passwords passwords = (Passwords)model.getAttribute("passwords");
        String oldPassword = passwords.getOldPassword();
        String oldPasswordFromDb = adminRepo.getPassword();

        if(passwordEncoder.matches(oldPassword, oldPasswordFromDb)){

            System.out.println("Password Matched");
            String encoded = passwordEncoder.encode(passwords.getNewPassword());
            adminRepo.changePassword(encoded);

        }else{
//            throw new RuntimeException("Current Password Mismatched .!");
            return "PasswordError";
        }


        return "redirect:/";

    }

}
