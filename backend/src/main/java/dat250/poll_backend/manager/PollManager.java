package dat250.poll_backend.manager;
/*
import dat250.poll_backend.domain.Poll;
import dat250.poll_backend.domain.User;
import dat250.poll_backend.domain.Vote;
import dat250.poll_backend.domain.VoteOption;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class PollManager {
    private final HashMap<Long, User> users = new HashMap<>();
    private final HashMap<Long, Poll> polls = new HashMap<>();
    private final HashMap<Long, VoteOption> options = new HashMap<>();
    private final HashMap<Long, Vote> votes = new HashMap<>();

    private long userCounter = 0;
    private long pollCounter = 0;
    private long optionCounter = 0;
    private long voteCounter = 0;

    private long nextUserId() { return ++userCounter; }
    private long nextPollId() { return ++pollCounter; }
    private long nextOptionId() { return ++optionCounter; }
    private long nextVoteId() { return ++voteCounter; }

    public User createUser(String username, String email) {
        long id = nextUserId();
        User u = new User(id, username, email);
        users.put(id, u);
        return u;
    }
    public Collection<User> listUsers() { return users.values(); }
    public Optional<User> getUser(long id) { return Optional.ofNullable(users.get(id)); }
    public boolean deleteUser(long id) {
        return users.remove(id) != null;
    }

    public Poll createPoll(String question, Instant publishedAt, Instant validUntil, long createdByUserId) {
        long id = nextPollId();
        Poll p = new Poll(id, question, publishedAt, validUntil, createdByUserId);
        polls.put(id, p);
        return p;
    }
    public Collection<Poll> listPolls() { return polls.values(); }
    public Optional<Poll> getPoll(long id) { return Optional.ofNullable(polls.get(id)); }
    public boolean deletePoll(long pollId) {
        Poll p = polls.remove(pollId);
        if (p == null) return false;

        for (Long optId : p.getVoteOptionIds()) options.remove(optId);
        for (Long vId : p.getVoteIds()) votes.remove(vId);
        return true;
    }

    public VoteOption createOption(long pollId, String caption, int order) {
        long id = nextOptionId();
        VoteOption o = new VoteOption(id, pollId, caption, order);
        options.put(id, o);
        Poll poll = polls.get(pollId);
        if (poll != null) {
            poll.getVoteOptionIds().add(id);
        }
        return o;
    }
    public Optional<VoteOption> getOption(long id) { return Optional.ofNullable(options.get(id)); }
    public Collection<VoteOption> listOptionsForPoll(long pollId) {
        Poll p = polls.get(pollId);
        if (p == null) return List.of();
        List<VoteOption> res = new ArrayList<>();
        for (Long id : p.getVoteOptionIds()) {
            VoteOption o = options.get(id);
            if (o != null) res.add(o);
        }
        res.sort(Comparator.comparingInt(VoteOption::getPresentationOrder));
        return res;
    }
    public boolean deleteOption(long optionId) {
        VoteOption removed = options.remove(optionId);
        if (removed == null) return false;
        Poll p = polls.get(removed.getPollId());
        if (p != null) p.getVoteOptionIds().remove(optionId);
        return true;
    }

    public Vote createOrUpdateVote(long pollId, long userId, long voteOptionId, Instant at) {
        Poll p = polls.get(pollId);
        if (p == null) throw new IllegalArgumentException("Poll not found");
        Vote existing = null;
        for (Long vid : p.getVoteIds()) {
            Vote v = votes.get(vid);
            if (v != null && v.getUserId() == userId) { existing = v; break; }
        }
        if (existing != null) {
            existing.setVoteOptionId(voteOptionId);
            existing.setPublishedAt(at);
            return existing;
        } else {
            long id = nextVoteId();
            Vote v = new Vote(id, pollId, userId, voteOptionId, at);
            votes.put(id, v);
            p.getVoteIds().add(id);
            return v;
        }
    }

    public Collection<Vote> listVotesForPoll(long pollId) {
        Poll p = polls.get(pollId);
        if (p == null) return List.of();
        List<Vote> res = new ArrayList<>();
        for (Long vid : p.getVoteIds()) {
            Vote v = votes.get(vid);
            if (v != null) res.add(v);
        }
        return res;
    }

    public void clearAll() {
        users.clear(); polls.clear(); options.clear(); votes.clear();
        userCounter = pollCounter = optionCounter = voteCounter = 0;
    }
}
 */
