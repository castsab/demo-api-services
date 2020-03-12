package com.org.demo.api.services;

import com.org.demo.api.models.Poll;
import com.org.demo.api.repositories.PollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public boolean savePoll(long documentNumber, String email, String comments, long markCode) {
        Poll poll = new Poll();
        poll.setDocumentNumber(documentNumber);
        poll.setEmail(email);
        poll.setComments(comments);
        poll.setMarkPc(markCode);
        poll.setState(1);
        Calendar cal = Calendar.getInstance();
        poll.setAnswerDate(new Timestamp(cal.getTimeInMillis()));
        pollRepository.save(poll);
        return true;
    }

    public List<Poll> polls() {
        return pollRepository.findByState(1);
    }

    public boolean updatePollByState(long pollCode) {
        Poll poll = pollRepository.findById((int) pollCode);
        poll.setState(0);
        pollRepository.save(poll);
        return true;
    }

    
}
