package dat250.poll_backend.controller;

import dat250.poll_backend.domain.VoteOption;
import dat250.poll_backend.dto.VoteOptionDto;
import dat250.poll_backend.manager.PollManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class VoteOptionController {
    private final PollManager pm;
    public VoteOptionController(PollManager pm) { this.pm = pm; }

    public static class CreateOptionRequest {
        public String caption;
        public int presentationOrder;
    }

    @PostMapping("/api/polls/{pollId}/options")
    public ResponseEntity<VoteOptionDto> createOption(@PathVariable long pollId, @RequestBody CreateOptionRequest req) {
        VoteOption o = pm.createOption(pollId, req.caption, req.presentationOrder);
        return ResponseEntity.ok(new VoteOptionDto(o.getId(), o.getPollId(), o.getCaption(), o.getPresentationOrder()));
    }

    @GetMapping("/api/polls/{pollId}/options")
    public List<VoteOptionDto> listOptions(@PathVariable long pollId) {
        return pm.listOptionsForPoll(pollId).stream()
                .map(o -> new VoteOptionDto(o.getId(), o.getPollId(), o.getCaption(), o.getPresentationOrder()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/api/options/{optionId}")
    public ResponseEntity<Void> deleteOption(@PathVariable long optionId) {
        boolean ok = pm.deleteOption(optionId);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
