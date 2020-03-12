
package com.org.demo.api.repositories;

import com.org.demo.api.models.Poll;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{

    List<Poll> findByState(int state);

    Poll findById(int pollCode);

}
