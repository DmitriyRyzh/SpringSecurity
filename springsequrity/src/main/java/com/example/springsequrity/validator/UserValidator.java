package com.example.springsequrity.validator;


import com.example.springsequrity.entity.User;
import com.example.springsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("!!!! Validate !!!");
        User user =(User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");

        if(user.getUserName().length() < 4 || user.getUserName().length() > 32){
            errors.rejectValue("userName","Size.UserForm.userName");
        }

        if(userService.findByUserName(user.getUserName()) != null){
            errors.rejectValue("userName","Duplicate.UserForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if(user.getUserName().length() < 8 || user.getUserName().length() > 32){
            errors.rejectValue("password","Size.UserForm.password");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("ConfirmPassword","Different.UserForm.password");
        }

    }
}
