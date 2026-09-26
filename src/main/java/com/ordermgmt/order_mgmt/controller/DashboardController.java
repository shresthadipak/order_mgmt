package com.ordermgmt.order_mgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("pageTitle", "Dashboard");
        return "dashboard";
    }

}
