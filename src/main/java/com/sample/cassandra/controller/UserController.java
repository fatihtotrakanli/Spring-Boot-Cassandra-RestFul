package com.sample.cassandra.controller;

import com.datastax.driver.core.utils.UUIDs;
import com.sample.cassandra.dao.IUserDao;
import com.sample.cassandra.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private IUserDao repository;

    @RequestMapping
    public List<User> getAll() {
        logger.info("User list is checking from cassandra");
        return (List<User>) this.repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        user.setId(UUIDs.timeBased());
        logger.info("User save process has started.");
        return this.repository.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody User user) {
        logger.info("User delete process has started.");
        this.repository.delete(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User edit(@RequestBody User user) {
        User findUser = this.repository.findById(user.getId());
        if (findUser != null) {
            logger.info("User update process has started.");
            return this.repository.save(user);
        } else throw new RuntimeException("User not found");
    }
}
