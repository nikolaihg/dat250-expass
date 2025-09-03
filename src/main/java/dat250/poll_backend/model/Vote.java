package dat250.poll_backend.model;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;
    private User voter;
    private VoteOption voteOption;

    public Vote() {
        this.publishedAt = Instant.now();
    }

    public Vote(VoteOption voteOption, User voter) {
        this.publishedAt = Instant.now();
        this.voteOption = voteOption;
        this.voter = voter;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }
}
