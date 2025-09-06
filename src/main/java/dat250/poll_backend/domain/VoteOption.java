package dat250.poll_backend.domain;

public class VoteOption {
    private long id;
    private long pollId;
    private String caption;
    private int presentationOrder;

    public VoteOption() {}
    public VoteOption(long id, long pollId, String caption, int presentationOrder) {
        this.id = id;
        this.pollId = pollId;
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getPollId() { return pollId; }
    public void setPollId(long pollId) { this.pollId = pollId; }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    public int getPresentationOrder() { return presentationOrder; }
    public void setPresentationOrder(int presentationOrder) { this.presentationOrder = presentationOrder; }
}

