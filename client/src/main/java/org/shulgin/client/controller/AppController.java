package org.shulgin.client.controller;

import org.shulgin.client.entity.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class AppController {
    private static final String URL = "http://tomcat:8080/user_api/api/users";
    private static final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String showAllUsers(Model model) {
        ResponseEntity<User[]> response = restTemplate.getForEntity(URL, User[].class);
        User[] users = response.getBody();
        model.addAttribute("users", users);
        return "allusers";
    }

    @GetMapping("/form")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userform";
    }

    @PostMapping("/form")
    public String sendForm(@ModelAttribute("user") User user) {
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(URL, HttpMethod.POST, request, User.class);
        User userResp = response.getBody();
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        String deleteURL = URL + "/" + id;
        restTemplate.delete(deleteURL);
        return "redirect:/";
    }
}
