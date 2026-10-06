


package com.example.Java_Security_Basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
public class UserController {

  @GetMapping("/user/home")
  public String userHome() {
    return "Welcome to the User Home!";
  }
 

}
