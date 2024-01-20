package com.log.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class VotingServiceTest {

    private VotingService votingService = new VotingService();

    @Test
    void enterCandidate_ShouldAddCandidateWithZeroVotes() {
        votingService.enterCandidate("Candidate1");
        assertEquals(0, votingService.countVote("Candidate1"));
    }

    @Test
    void castVote_ShouldIncrementVoteCount() {
        votingService.enterCandidate("Candidate2");
        votingService.castVote("Candidate2");
        assertEquals(1, votingService.countVote("Candidate2"));
    }

    @Test
    void castVote_InvalidCandidate_ShouldReturnFalse() {
        assertFalse(votingService.castVote("InvalidCandidate"));
    }

    @Test
    void countVote_InvalidCandidate_ShouldReturnMinusOne() {
        assertEquals(-1, votingService.countVote("InvalidCandidate"));
    }

    @Test
    void listVotes_ShouldReturnAllCandidatesAndVotes() {
        votingService.enterCandidate("Candidate3");
        votingService.enterCandidate("Candidate4");

        Map<String, Integer> expectedVotes = new HashMap<>();
        expectedVotes.put("Candidate3", 0);
        expectedVotes.put("Candidate4", 0);

        assertEquals(expectedVotes, votingService.listVotes());
    }

    @Test
    void getWinner_NoCandidates_ShouldReturnNoCandidatesAvailable() {
        assertEquals("No candidates available", votingService.getWinner());
    }

    @Test
    void getWinner_ShouldReturnCandidateWithHighestVotes() {
        votingService.enterCandidate("Winner1");
        votingService.enterCandidate("Winner2");

        votingService.castVote("Winner1");
        votingService.castVote("Winner1");
        votingService.castVote("Winner2");

        assertEquals("Winner1", votingService.getWinner());
    }
}

