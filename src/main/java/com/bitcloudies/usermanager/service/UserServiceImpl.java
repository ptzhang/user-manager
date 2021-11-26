package com.bitcloudies.usermanager.service;

import com.bitcloudies.usermanager.domain.Role;
import com.bitcloudies.usermanager.domain.User;
import com.bitcloudies.usermanager.repo.RoleRepo;
import com.bitcloudies.usermanager.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("save user to db");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save role to db");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        log.info("add role to user");
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("retrieve user");
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("retrieve all user");
        return userRepo.findAll();
    }
}
