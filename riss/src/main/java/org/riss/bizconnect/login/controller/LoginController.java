package org.riss.bizconnect.login.controller;

import org.riss.bizconnect.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login.do")
    public String login(@RequestParam("userId") String userId, 
                        @RequestParam("userPwd") String userPwd, 
                        @RequestParam("comcode") String comCode, 
                        Model model) {
        // Logic for authentication
        boolean isValidUser = userService.validateUser(userId, userPwd, comCode);

        if (isValidUser) {
            return "redirect:/main.do"; // Redirect to the main page after successful login
        } else {
            model.addAttribute("error", "Invalid login credentials.");
            return "common/loginPage";  // Show login page with error
        }
    }
}
