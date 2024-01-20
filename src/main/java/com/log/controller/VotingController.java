package com.log.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/entercandidate")
    public ResponseEntity<String> enterCandidate(@RequestParam String name) {
        votingService.enterCandidate(name);
        return ResponseEntity.ok("Candidate entered successfully");
    }

    @PostMapping("/castvote")
    public ResponseEntity<String> castVote(@RequestParam String name) {
        boolean voteCasted = votingService.castVote(name);
        if (voteCasted) {
            return ResponseEntity.ok("Vote cast successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid candidate");
        }
    }

    @GetMapping("/countvote")
    public ResponseEntity<Integer> countVote(@RequestParam String name) {
        int voteCount = votingService.countVote(name);
        if (voteCount >= 0) {
            return ResponseEntity.ok(voteCount);
        } else {
            return ResponseEntity.badRequest().body(-1); // Invalid candidate
        }
    }

    @GetMapping("/listvote")
    public ResponseEntity<Map<String, Integer>> listVotes() {
        Map<String, Integer> votes = votingService.listVotes();
        return ResponseEntity.ok(votes);
    }

    @GetMapping("/getwinner")
    public ResponseEntity<String> getWinner() {
        String winner = votingService.getWinner();
        return ResponseEntity.ok(winner);
    }
}

