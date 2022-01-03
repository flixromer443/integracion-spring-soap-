package com.api1.api1.user_controllers;

import java.util.List;

import com.api1.api1.orm.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {
    public List<User> findUsers();

    public User findUser(@PathVariable Integer id, User user);

    public User update(@RequestBody User user, @PathVariable Integer id);

    public void delete(@PathVariable Integer id);
}
