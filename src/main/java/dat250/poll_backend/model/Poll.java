package dat250.poll_backend.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Poll {
    private User creator;
    private String question;
    private List<VoteOption> options;
    private Instant publishedAt;
    private Instant validUntil;

    public Poll() {
        this.options = new ArrayList<>();
        this.publishedAt = Instant.now();
    }

    public Poll(User creator, String question, List<VoteOption> options, Instant validUntil) {
        this.creator = creator;
        this.question = question;
        this.options = options;
        this.publishedAt = Instant.now();
        this.validUntil = validUntil;

    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public User getCreator() {
        return creator;
    }

    public String getQuestion() {
        return question;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }
}
