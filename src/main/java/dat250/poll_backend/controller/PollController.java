package dat250.poll_backend.controller;

import dat250.poll_backend.domain.Poll;
import dat250.poll_backend.dto.PollDto;
import dat250.poll_backend.manager.PollManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollManager pm;
    public PollController(PollManager pm) { this.pm = pm; }

    // create: client sends question, validUntil (optional), createdByUserId
    public static class CreatePollRequest {
        public String question;
        public Instant publishedAt;
        public Instant validUntil;
        public long createdByUserId;
    }

    @PostMapping
    public ResponseEntity<PollDto> createPoll(@RequestBody CreatePollRequest req) {
        Instant published = req.publishedAt == null ? Instant.now() : req.publishedAt;
        Poll p = pm.createPoll(req.question, published, req.validUntil, req.createdByUserId);
        return ResponseEntity.ok(new PollDto(p.getId(), p.getQuestion(), p.getPublishedAt(), p.getValidUntil(), p.getCreatedByUserId(), p.getVoteOptionIds()));
    }

    @GetMapping
    public List<PollDto> listPolls() {
        return pm.listPolls().stream()
                .map(p -> new PollDto(p.getId(), p.getQuestion(), p.getPublishedAt(), p.getValidUntil(), p.getCreatedByUserId(), p.getVoteOptionIds()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable long id) {
        boolean ok = pm.deletePoll(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
