# Voting Application

## Setup
1. Clone the repository.
2. Open the project in your preferred IDE.
3. Run the main application class.

## Endpoints
- **Enter Candidate:**
  - Endpoint: POST http://localhost:8080/entercandidate?name={candidateName}
  - Description: Adds a candidate with an initial vote count of 0.

- **Cast Vote:**
  - Endpoint: POST http://localhost:8080/castvote?name={candidateName}
  - Description: Increments the vote count for a candidate.

- **Count Vote:**
  - Endpoint: GET http://localhost:8080/countvote?name={candidateName}
  - Description: Retrieves the latest vote count for a candidate.

- **List Votes:**
  - Endpoint: GET http://localhost:8080/listvote
  - Description: Retrieves a list of all candidates and their vote counts.

- **Get Winner:**
  - Endpoint: GET http://localhost:8080/getwinner
  - Description: Retrieves the candidate with the highest vote count.

## Project Structure
- /src
  - /main
    - /java
      - com.log.controller
        - VotingController.java (Controller class)
        - VotingService.java (Service class)
  - /test
    - /java
      - com.log.controller
        - VotingServiceTest.java (Test class)
