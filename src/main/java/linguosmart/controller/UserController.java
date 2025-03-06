package linguosmart.controller;


import linguosmart.domain.User;
import linguosmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/get-user")
    public Optional<User> queryUserAll(@RequestParam String name){

        return  userService.queryUserAll(name);
    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User name){

          userService.updateUser(name);
        return ResponseEntity.ok("Record is updated ");
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam String userId){

          userService.deleteUser(Long.valueOf(userId));
        return ResponseEntity.ok("Record is deleted ");
    }

    @GetMapping("/signup-user")
    public ResponseEntity<String> createUser(@RequestBody User userCreate){

          userService.createUser(userCreate);
        return ResponseEntity.ok("Record is created ");
    }
}
