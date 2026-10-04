package com.ordermgmt.order_mgmt.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard(Model model, HttpSession session){
        model.addAttribute("pageTitle", "Dashboard");
        return "dashboard";
    }

}
