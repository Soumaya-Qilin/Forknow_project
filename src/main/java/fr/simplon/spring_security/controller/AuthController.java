package fr.simplon.spring_security.controller;


import fr.simplon.spring_security.dto.ShopDto;

import fr.simplon.spring_security.model.Shop;
import fr.simplon.spring_security.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import fr.simplon.spring_security.dto.RegisterDto;
import fr.simplon.spring_security.model.User;
import fr.simplon.spring_security.service.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    private final UserService userService;

    private final ShopService shopService;

    @Autowired
    public AuthController(UserService userService, ShopService shopService) {
        this.userService = userService;
        this.shopService= shopService;
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        Optional<User> user = userService.from(authentication);
        if(user.isPresent()){
            model.addAttribute("currentUser", user.get());
        }
        return "forknow-index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/forknow-register-restaurant")
    public String registerRestaurant(Model model) {
        ShopDto shop = new ShopDto();
        model.addAttribute("shop", shop);
        return "forknow-register-restaurant";
    }

    @PostMapping("/register-restaurant/save")
    public String registerShop(@Valid @ModelAttribute ShopDto shopMapping) {
        shopService.saveShop(shopMapping);
        return "redirect:/restaurants";
    }

    @GetMapping("/login")
    public String login(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/restaurants")
    public String getRestaurants(Model model) {
        List<Shop> shops = shopService.findAllShops();
        model.addAttribute("shops", shops);
        return "forknow-restaurants-list";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute RegisterDto userMapping) {
        System.out.println("Ok");
        if(!userMapping.getPassword().equals(userMapping.getPasswordConfirm())){
            return "redirect:/register?error";
        }
        userService.saveUser(userMapping);
        return "redirect:/login?success=userRegistred";
    }
}