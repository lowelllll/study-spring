package controller.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import spring.RegisterRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRequestValidator implements Validator {
    private static final String emailRegExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

    private Pattern pattern;

    public RegisterRequestValidator() {
        pattern = Pattern.compile(emailRegExp);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest request = (RegisterRequest) target;
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", "required");
        } else {
            Matcher matcher = pattern.matcher(request.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "bad");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");

        if (!request.getPassword().isEmpty()) {
            if (!request.isPasswordEqualToConfirmPassword()) {
                errors.rejectValue("confirmPassword", "nomatch");
            }
        }
    }
}
