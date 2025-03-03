package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.UserEntry;
import net.engineeringdigest.journalApp.service.UserService;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntry> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody UserEntry userEntry){
        userService.saveEntry(userEntry);
    }


    @PutMapping("/{userName}")
    public  ResponseEntity<?> updateUser(@RequestBody UserEntry newEntry,@PathVariable String userName){
        UserEntry UserInDb=userService.findByUsername(userName);
        if(UserInDb!=null){
            UserInDb.setUserName(newEntry.getUserName());
            UserInDb.setPassword(newEntry.getPassword());
            userService.saveEntry(UserInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
