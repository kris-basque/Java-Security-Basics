


package com.example.Java_Security_Basics;

import org.apache.catalina.connector.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class SecurityConfig {

  @Bean 
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    http.authorizeHttpRequests((requests) -> requests
                  // Dando acesso para o endpoint PUBLIC
                  .requestMatchers("/public").permitAll()
                  .requestMatchers("/admin/*").hasRole("ADMIN")
                  .requestMatchers("/user/*").hasRole("USER")
                  .anyRequest()
                  .authenticated()).formLogin(Customizer.withDefaults())
                  .httpBasic(Customizer.withDefaults());
    
    return http.build();

  }

  @Bean 
  public UserDetailsService inMemoryUserDetailMenager() {

    UserDetails user1 = User.withUsername("Kris").password("{noop}Basque")
                    .roles("USER").build();

    UserDetails user2 = User.withUsername("admin").password("{noop}admin123")
                    .roles("ADMIN").build();

    return new InMemoryUserDetailsManager(user1, user2);

  }

}
