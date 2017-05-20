package com.sample.cassandra.dao;


import com.sample.cassandra.entity.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface IUserDao extends CrudRepository<User, String> {

    @Query("Select * from user where name=?0")
    User findByName(String firstName);

    @Query("Select * from user where surname=?0")
    List<User> findBySurname(String lastName);

    @Query("Select * from user where age=?0")
    List<User> findByAge(int age);

    @Query("Select * from user where id=?0")
    User findById(UUID id);

}
