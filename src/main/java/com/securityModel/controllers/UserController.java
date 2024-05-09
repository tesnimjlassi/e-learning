package com.securityModel.controllers;

import com.securityModel.models.User;
import com.securityModel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public User createuser(@RequestBody User user){
        return userService.createuser(user);
    }

    @GetMapping("/all")
    public List<User> userList(){
        return userService.allUsers();
    }

    @GetMapping("/getone/{id}")
    public User userById(@PathVariable Long id){
        return userService.userById(id);
    }

    @PutMapping("/update/{id}")
    public User updateuser(@PathVariable Long id,@RequestBody User user){
        return  userService.updateuser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteuser(@PathVariable long id) {
        User p = userService.userById(id);

        HashMap message = new HashMap();
        if (p != null) {
            try {

                userService.deleteUser(id);
                message.put("Etat", "user deleted");
                return message;
            } catch (Exception e) {
                message.put("Etat", "Error" + e.getMessage());
                return message;
            }
        } else {
            message.put("Etat", "user not found");
            return message;

        }
    }
}
