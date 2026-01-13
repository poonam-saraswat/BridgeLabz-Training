import java.util.*;

// Voter class (Encapsulation)
class Voter {
    private String voterId;
    private String name;

    public Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }
}

// Candidate class
class Candidate {
    private String candidateId;
    private String name;
    private int votes;

    public Candidate(String candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }

    @Override
    public String toString() {
        return "Candidate [ID=" + candidateId + ", Name=" + name + ", Votes=" + votes + "]";
    }
}

// Vote class
class Vote {
    private Voter voter;
    private Candidate candidate;

    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    public Voter getVoter() {
        return voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }
}

// Custom Exception
class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

// Abstract Election Service (Abstraction)
abstract class ElectionService {
    public abstract void registerVoter(Voter voter);
    public abstract void addCandidate(Candidate candidate);
    public abstract void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException;
    public abstract void declareResults();
}

// Concrete Implementation
class OnlineElectionService extends ElectionService {
    private Map<String, Voter> voters = new HashMap<>();
    private Map<String, Candidate> candidates = new HashMap<>();
    private Set<String> votedVoters = new HashSet<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.put(voter.getVoterId(), voter);
        System.out.println("✅ Registered voter: " + voter.getName());
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getCandidateId(), candidate);
        System.out.println("✅ Added candidate: " + candidate.getName());
    }

    @Override
    public void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException {
        if (votedVoters.contains(voter.getVoterId())) {
            throw new DuplicateVoteException("❌ Voter " + voter.getName() + " has already voted.");
        }
        candidate.addVote();
        votedVoters.add(voter.getVoterId());
        System.out.println("🗳️ Voter " + voter.getName() + " voted for " + candidate.getName());
    }

    @Override
    public void declareResults() {
        System.out.println("\n📊 Election Results:");
        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate);
        }

        // Find winner
        Candidate winner = null;
        for (Candidate candidate : candidates.values()) {
            if (winner == null || candidate.getVotes() > winner.getVotes()) {
                winner = candidate;
            }
        }
        if (winner != null) {
            System.out.println("\n🏆 Winner: " + winner.getName() + " with " + winner.getVotes() + " votes");
        }
    }
}

// Main class to test
public class OnlineVotingSystem {
    public static void main(String[] args) {
        ElectionService election = new OnlineElectionService();

        // Register voters
        Voter v1 = new Voter("V101", "Poonam");
        Voter v2 = new Voter("V102", "Rahul");
        Voter v3 = new Voter("V103", "Sneha");

        election.registerVoter(v1);
        election.registerVoter(v2);
        election.registerVoter(v3);

        // Add candidates
        Candidate c1 = new Candidate("C101", "Alice");
        Candidate c2 = new Candidate("C102", "Bob");

        election.addCandidate(c1);
        election.addCandidate(c2);

        // Cast votes
        try {
            election.castVote(v1, c1);
            election.castVote(v2, c2);
            election.castVote(v3, c1);

            // Duplicate vote attempt
            election.castVote(v1, c2);
        } catch (DuplicateVoteException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Declare results
        election.declareResults();
    }
}