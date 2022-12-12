package com.tutorial.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve",  LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim",  LocalDate.now().minusYears(20)));
    }

    // Get all users
    public List<User> findAll() {
        return users;
    }

    // Find a user
    public User findUser(int id) {
        Predicate<? super User> perdicate = user -> user.getId().equals(id);

        return users.stream().filter(perdicate).findFirst().get();
    }

    // Add a user
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);

        return user;
    }
}