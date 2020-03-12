
package com.org.demo.api.repositories;

import com.org.demo.api.models.MarkPc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkPcRepository extends JpaRepository<MarkPc, Long>{

    
}
