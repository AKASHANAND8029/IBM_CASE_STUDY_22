package com.example.loginregistration.controller;


import com.example.loginregistration.model.User;
import com.example.loginregistration.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {


    private final RegistrationServiceImpl registrationService;

    @Autowired
    public RegistrationController(RegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        if(tempEmailId != null && !"".equals(tempEmailId))
        {
            User userObj = registrationService.findByEmail(tempEmailId);
            if(userObj != null)
            {
                throw new Exception("User with " +tempEmailId+ " already exists");
            }
        }
        User user1= null;
        user1 = registrationService.saveUser(user);
        return user1;

    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmail();
        String tempPass = user.getPassword();
        User userObj = null;
        if(tempEmailId !=null && tempPass != null )
        {
            userObj =registrationService.findByEmailAndPassword(tempEmailId,tempPass);
        }
        if(userObj == null) {
            throw new Exception("Wrong Credentials!");
        }
        return userObj;
    }
}
