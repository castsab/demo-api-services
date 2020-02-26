
package com.org.demo.api.repositories;

import com.org.demo.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

    boolean existsByUsername(String username);
    
}
