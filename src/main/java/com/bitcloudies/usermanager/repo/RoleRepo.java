package com.bitcloudies.usermanager.repo;

import com.bitcloudies.usermanager.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
