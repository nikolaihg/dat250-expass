package dat250.poll_backend.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Poll {
    private long id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private long createdByUserId;
    private List<Long> voteOptionIds = new ArrayList<>();
    private List<Long> voteIds = new ArrayList<>();

    public Poll() {}
    public Poll(long id, String question, Instant publishedAt, Instant validUntil, long createdByUserId) {
        this.id = id;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
        this.createdByUserId = createdByUserId;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public Instant getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Instant publishedAt) { this.publishedAt = publishedAt; }

    public Instant getValidUntil() { return validUntil; }
    public void setValidUntil(Instant validUntil) { this.validUntil = validUntil; }

    public long getCreatedByUserId() { return createdByUserId; }
    public void setCreatedByUserId(long createdByUserId) { this.createdByUserId = createdByUserId; }

    public List<Long> getVoteOptionIds() { return voteOptionIds; }
    public void setVoteOptionIds(List<Long> voteOptionIds) { this.voteOptionIds = voteOptionIds; }

    public List<Long> getVoteIds() { return voteIds; }
    public void setVoteIds(List<Long> voteIds) { this.voteIds = voteIds; }
}