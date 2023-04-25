package com.neonatal.backend.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neonatal.backend.entities.User;

public class UserDAO {
	
    Map<Long, User> USERS_MAP = new HashMap<Long, User>();
    
    public long getMaxUserId() {
        long max = 0;
        for (long id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
    
    public User findAppUserByUserName(String username) {
        Collection<User> appUsers = USERS_MAP.values();
        for (User u : appUsers) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    public User findAppUserByEmail(String emailaddress) {
        Collection<User> appUsers = USERS_MAP.values();
        for (User u : appUsers) {
            if (u.getEmailaddress().equals(emailaddress)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();

        list.addAll(USERS_MAP.values());
        return list;
    }

    public User createUser(User form) {
        long userId = this.getMaxUserId() + 1;

        User user = new User( userId, form.getUsername(), form.getPassword(), form.getEmailaddress(),//
                form.getFirstname(), form.getLastname(), form.getRoleid());

        USERS_MAP.put(userId, user);
        /*
        String sql = "insert into users values(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
        */
        return user;
    }
    
    /*
    public User validateUser(Login login) {

        String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";

        List<User> users = jdbcTemplate.query(sql, new UserMapper());

        return users.size() > 0 ? users.get(0) : null;
        }
	*/
}
