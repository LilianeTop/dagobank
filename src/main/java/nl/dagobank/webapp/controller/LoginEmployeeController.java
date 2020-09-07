package nl.dagobank.webapp.controller;

import nl.dagobank.webapp.backingbeans.LoginForm;
import nl.dagobank.webapp.service.EmployeeService;
import nl.dagobank.webapp.service.LoginValidatorEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes( "user" )
public class LoginEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping( "werknemer" )
    public String loginEmployee( Model model ) {
        model.addAttribute( "loginform", new LoginForm() );
        return "loginEmployee";
    }

    @PostMapping( "werknemer" )
    public String loginAttemptEmployee( Model model, @ModelAttribute LoginForm loginForm ) {

        LoginValidatorEmployee lv = employeeService.validateCredentials( loginForm );
        model.addAttribute( "loginform", loginForm );
        System.out.println( lv.isLoginValidated() );

        return "loginEmployee";
    }

}
