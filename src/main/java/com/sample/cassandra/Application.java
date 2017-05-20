package com.sample.cassandra;

import com.datastax.driver.core.utils.UUIDs;
import com.sample.cassandra.dao.IUserDao;
import com.sample.cassandra.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private IUserDao repository;

    @Override
    public void run(String... args) throws Exception {
        // Example data for first insert. It can be deleted as soon as things go well
        this.repository.save(new User(UUIDs.timeBased(), "Fatih", "Totrakanlı", 27));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
