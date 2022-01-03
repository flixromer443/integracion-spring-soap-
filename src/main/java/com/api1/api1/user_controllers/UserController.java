package com.api1.api1.user_controllers;

import java.util.List;
import java.util.Optional;

import com.api1.api1.orm.User;
import com.api1.api1.repositories.IUserJpaRepositorty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api1/v1")
public class UserController {
    @Autowired
    private IUserJpaRepositorty IUserJpa;

    @GetMapping("/users")
    public List<User> findUsers() {
        return IUserJpa.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Optional<User> findUser(@PathVariable Integer id, Optional<User> user) {
        user= IUserJpa.findById(id);
        return user;
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return IUserJpa.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@RequestBody User user, @PathVariable Integer id) {
        User userbase = IUserJpa.getOne(id);
        userbase.setName(user.getName());
        userbase.setSurname(user.getSurname());
        return IUserJpa.save(userbase);
    }
    
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable Integer id) {
        IUserJpa.deleteById(id);
    }

}
