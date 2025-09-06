package dat250.poll_backend.domain;

import java.time.Instant;

public class Vote {
    private long id;
    private long pollId;
    private long userId;
    private long voteOptionId;
    private Instant publishedAt;

    public Vote() {}
    public Vote(long id, long pollId, long userId, long voteOptionId, Instant publishedAt) {
        this.id = id; this.pollId = pollId; this.userId = userId; this.voteOptionId = voteOptionId; this.publishedAt = publishedAt;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getPollId() { return pollId; }
    public void setPollId(long pollId) { this.pollId = pollId; }

    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }

    public long getVoteOptionId() { return voteOptionId; }
    public void setVoteOptionId(long voteOptionId) { this.voteOptionId = voteOptionId; }

    public Instant getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Instant publishedAt) { this.publishedAt = publishedAt; }
}
