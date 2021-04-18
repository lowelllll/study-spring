package controller;

import controller.validator.RegisterRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean isAgree,
            Model model
    ) {
        if (!isAgree) return "register/step1";
        model.addAttribute("data", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@ModelAttribute("data") RegisterRequest request, Errors errors) {
        new RegisterRequestValidator().validate(request, errors);
        if (errors.hasErrors()) {
            return "register/step2";
        }

        try {
            memberRegisterService.register(request);
            return "register/step3";
        } catch (DuplicateMemberException e) {
            errors.rejectValue("email", "duplicate");
            return "register/step2";
        }
    }
}
