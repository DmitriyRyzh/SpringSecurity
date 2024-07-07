package com.example.springsequrity.controller;

import com.example.springsequrity.entity.User;
import com.example.springsequrity.service.SecurityService;
import com.example.springsequrity.service.UserService;
import com.example.springsequrity.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(userForm);
        securityService.autoLogin(userForm.getUserName(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@GetMapping
    public String login(Model model, String error, String logout){
        System.out.println("!!!LOGIN!!!");
        if(error!=null){
            model.addAttribute("error", "Неверное имя пользователя или пароль");
        }
        if(logout!=null){
            model.addAttribute("message", "Выполнен логаут");
        }
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }



}
