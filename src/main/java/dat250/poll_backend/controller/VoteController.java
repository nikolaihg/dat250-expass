package dat250.poll_backend.controller;

import dat250.poll_backend.domain.Vote;
import dat250.poll_backend.dto.VoteDto;
import dat250.poll_backend.manager.PollManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/polls/{pollId}/votes")
public class VoteController {
    private final PollManager pm;
    public VoteController(PollManager pm) { this.pm = pm; }

    public static class VoteRequest {
        public long userId;
        public long voteOptionId;
    }

    @PostMapping
    public ResponseEntity<VoteDto> castOrChangeVote(@PathVariable long pollId, @RequestBody VoteRequest req) {
        Vote v = pm.createOrUpdateVote(pollId, req.userId, req.voteOptionId, Instant.now());
        return ResponseEntity.ok(new VoteDto(v.getId(), v.getPollId(), v.getUserId(), v.getVoteOptionId(), v.getPublishedAt()));
    }

    @GetMapping
    public List<VoteDto> listVotes(@PathVariable long pollId) {
        return pm.listVotesForPoll(pollId).stream()
                .map(v -> new VoteDto(v.getId(), v.getPollId(), v.getUserId(), v.getVoteOptionId(), v.getPublishedAt()))
                .collect(Collectors.toList());
    }
}
