package com.bitcloudies.usermanager.service;

import com.bitcloudies.usermanager.domain.Role;
import com.bitcloudies.usermanager.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
