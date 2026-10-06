



package com.example.Java_Security_Basics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
public class DemoController {

  @GetMapping("/secured")
  public String securedEndpoint() {
    return "This is a secure endpoint accessible only by authenticated users.";
  }

  @GetMapping("/public")
  public String publicEndpoint() {
    return "This is a public endpoint accessible by anyone.";
  }
  
  
  

}
