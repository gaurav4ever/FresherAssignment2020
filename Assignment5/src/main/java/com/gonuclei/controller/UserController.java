package com.gonuclei.controller;

import com.gonuclei.bos.NewsLetterBo;
import com.gonuclei.bos.UserBo;
import com.gonuclei.dto.UserDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.service.impl.NewsLetterService;
import com.gonuclei.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
public class UserController {

    /**
     * Greet string.
     *
     * @return the string
     */
    @GetMapping("/status")
    public String greet() {
        return "Welcome to newsletter";
    }

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get subscriptions list.
     *
     * @return the list
     */
    @GetMapping("/users")
    public List<UserDto> getSubscriptions(){
        return null; //userService.getSubscriptions();
    }

    /**
     * Gets subscription.
     *
     * @param id the id
     * @return the subscription
     * @throws UserNotFoundException the user not found exception
     */
    @GetMapping("/users/{id}")
    public UserDto getSubscription(@PathVariable int id) throws UserNotFoundException {
        return null; //userService.getSubscription(id);
    }

    /**
     * Add subscription.
     *
     * @param user the user
     */
    @PostMapping("/users")
    public void addSubscription(@RequestBody UserDto user){
        //userService.addSubscription(user);
    }

    /**
     * Modify subscription.
     *
     * @param id   the id
     * @param user the user
     * @throws UserNotFoundException the user not found exception
     */
    @PutMapping("/users/{id}")
    public void modifySubscription(@PathVariable Integer id, @RequestBody UserDto user) throws UserNotFoundException {
        //userService.modifySubscription(user);
    }

    /**
     * Remove all subscription.
     */
    @DeleteMapping("/users")
    public void removeAllSubscription(){
        //userService.removeAllSubscription();
    }

    /**
     * Remove subscription.
     *
     * @param id the id
     * @throws UserNotFoundException the user not found exception
     */
    @DeleteMapping("/users/{id}")
    public void removeSubscription(@PathVariable Integer id) throws UserNotFoundException {
        //userService.removeSubscription(id);
    }
}
