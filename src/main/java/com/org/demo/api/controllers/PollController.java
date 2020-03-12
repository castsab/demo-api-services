package com.org.demo.api.controllers;

import com.org.demo.api.models.Poll;
import com.org.demo.api.services.PollService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/poll")
public class PollController {

  @Autowired
  private PollService pollService;

  @PostMapping("/savePoll")
  @ResponseBody
  public boolean savePoll(
      @RequestParam("documentNumber") long documentNumber,
      @RequestParam("email") String email,
      @RequestParam("comments") String comments,
      @RequestParam("markCode") long markCode) {
    return pollService.savePoll(documentNumber, email, comments, markCode);
  }
  
  @GetMapping("/polls")
  @ResponseBody
  public List<Poll> polls(){
      return pollService.polls();
  }
  
  @PostMapping("/updatePollByState")
  @ResponseBody
  public boolean updatePollByState(
          @RequestParam("pollCode") long pollCode){   
    return pollService.updatePollByState(pollCode);
  }

}
