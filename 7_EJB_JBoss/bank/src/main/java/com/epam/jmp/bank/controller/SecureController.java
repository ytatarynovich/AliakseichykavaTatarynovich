package com.epam.jmp.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.epam.jmp.bank.springwebjaas.UserPrincipal;
 
@Controller
@RequestMapping("/private")
public class SecureController {
 
    @RequestMapping(value="/admin/index")
    //public String getOrder(ModelMap model, java.security.Principal principal) {
    public String getAdmin(ModelMap model) {
 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JaasGrantedAuthority jaasGrantedAuthority = (JaasGrantedAuthority)(auth.getAuthorities().toArray()[0]);
 
        UserPrincipal userPrincipal = (UserPrincipal)jaasGrantedAuthority.getPrincipal();
        userPrincipal.setRole(jaasGrantedAuthority.getAuthority());
 
        model.addAttribute("userPrincipal", userPrincipal);
        return "private/admin/index";
    }
 
    /*@RequestMapping(value="/customer/index")
    //public String getOrder(ModelMap model, java.security.Principal principal) {
    public String getCustomer(ModelMap model) {
 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JaasGrantedAuthority jaasGrantedAuthority = (JaasGrantedAuthority)(auth.getAuthorities().toArray()[0]);
 
        UserPrincipal userPrincipal = (UserPrincipal)jaasGrantedAuthority.getPrincipal();
        userPrincipal.setRole(jaasGrantedAuthority.getAuthority());
 
        model.addAttribute("userPrincipal", userPrincipal);
        return "private/customer/index";
    }*/
}
