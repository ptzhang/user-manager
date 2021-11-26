package com.bitcloudies.usermanager.repo;

import com.bitcloudies.usermanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
