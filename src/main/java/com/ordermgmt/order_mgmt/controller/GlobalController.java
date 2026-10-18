package com.ordermgmt.order_mgmt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    @ModelAttribute
    public void authenticationInformation(Model model, Authentication authentication){
        if(authentication != null
            && authentication.isAuthenticated()
            && !authentication.getName().equals("anonymousUser")){
            model.addAttribute("username", authentication.getName());
        }
    }

}
