package com.example.learn.angular.user;

import com.example.learn.angular.user.model.User;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserService implements InitializingBean {

    private Long counter = 1L;
    private Map<Long, User> mapOfUsers = new HashMap<>();

    public User getUser(Long id) {
        return mapOfUsers.get(id);
    }

    public Collection<User> getAllUsers() {
        return mapOfUsers.values();
    }

    public User addUser(User user) {
        user.setId(this.counter);
        mapOfUsers.put(this.counter, user);
        this.counter += 1;
        return user;
    }

    public void removeUser(Long id) {
        this.mapOfUsers.remove(id);
    }

    public User updateUser(User user) {
        return this.mapOfUsers.put(user.getId(), user);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Lists.newArrayList(User.builder().userEmail("email1@em.com").username("User 1").build(),
                User.builder().userEmail("email2@em.com").username("User 2").build(),
                User.builder().userEmail("email3@em.com").username("User 3").build(),
                User.builder().userEmail("email4@em.com").username("User 4").build(),
                User.builder().userEmail("email5@em.com").username("User 5").build()).forEach(this::addUser);
        log.info("loading initial data : {}", this.mapOfUsers.toString());
    }
}
