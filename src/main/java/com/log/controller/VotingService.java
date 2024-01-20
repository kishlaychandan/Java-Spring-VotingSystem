package com.log.controller;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

@Service
public class VotingService {

    private Map<String, Integer> candidateVotes = new HashMap<>();

    public void enterCandidate(String name) {
        candidateVotes.put(name, 0);
    }

    public boolean castVote(String name) {
        if (candidateVotes.containsKey(name)) {
            int currentVotes = candidateVotes.get(name);
            candidateVotes.put(name, currentVotes + 1);
            return true;
        }
        return false; // Invalid candidate
    }

    public int countVote(String name) {
        return candidateVotes.getOrDefault(name, -1);
    }

    public Map<String, Integer> listVotes() {
        return Collections.unmodifiableMap(candidateVotes);
    }

    public String getWinner() {
        if (candidateVotes.isEmpty()) {
            return "No candidates available";
        }

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        assert maxEntry != null;
        return maxEntry.getKey();
    }
}
