package com.gonuclei.controller;

import com.gonuclei.bos.NewsLetterBo;
import com.gonuclei.bos.UserBo;
import com.gonuclei.dto.UserDto;
import com.gonuclei.exception.NewsLetterNotFound;
import com.gonuclei.exception.UserNotFoundException;
import com.gonuclei.service.impl.NewsLetterService;
import com.gonuclei.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    /**
     * Gets subscription.
     *
     * @param id the id
     * @return the subscription
     * @throws UserNotFoundException the user not found exception
     */
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable long id) {
        try {
            return userService.getUser(id);
        } catch (UserNotFoundException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    /**
     * Add subscription.
     *
     * @param user the user
     */
    @PostMapping("/users")
    public void addUser(@RequestBody UserDto user){
        //TODO: Add exceptions of user already exists
        userService.addUser(user);
    }

    /**
     * Modify subscription.
     *
     * @param id   the id
     * @param user the user
     * @throws UserNotFoundException the user not found exception
     */
    @PutMapping("/users/{id}")
    public void modifyUser(@PathVariable Integer id, @RequestBody UserDto user) throws UserNotFoundException {
        //TODO:Add validations
        userService.modifyUser(user);
    }

//    /**
//     * Remove all subscription.
//     */
//    @DeleteMapping("/users")
//    public void removeAllSubscription(){
//        //userService.removeAllSubscription();
//    }
//
//    /**
//     * Remove subscription.
//     *
//     * @param id the id
//     * @throws UserNotFoundException the user not found exception
//     */
//    @DeleteMapping("/users/{id}")
//    public void removeSubscription(@PathVariable Integer id) throws UserNotFoundException {
//        //userService.removeSubscription(id);
//    }
}
