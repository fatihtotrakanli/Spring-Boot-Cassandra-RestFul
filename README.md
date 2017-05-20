## Spring Boot - Cassandra

Its sample project with Spring Boot and Cassandra and uses RestFul services

##### Easy Way to install Cassandra

[Cassandra Install](https://gist.github.com/hkhamm/a9a2b45dd749e5d3b3ae)

##### Cassandra Configuration
In application.properties, you can change 'keyspace' for your configuration.

In the application keyspace name uses 'myks'.

After Cassandra installation, create a new keyspace and create a new table in Cassandra with following commands.

```
CREATE KEYSPACE myks WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

CREATE TABLE myks.user (id TimeUUID PRIMARY KEY, name text, surname text, age int);
	CREATE INDEX usernameindex ON myks.user (name);
	CREATE INDEX usersurnameindex ON myks.user (surname);
	CREATE INDEX userageindex ON myks.user (age);
```

##### How To Run Project

The project is a spring boot project. For this reason, you can run the Application class by running it.

Application starts normally and inserts one data at user table.

```
http:127.0.0.1:8080/user
```


GET, POST, PUT, DELETE operations can be done with restful services.

## License

The MIT License (MIT) Copyright (c) 2017 Fatih Totrakanlı