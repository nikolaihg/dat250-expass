package dat250.poll_backend.dto;

import java.time.Instant;
import java.util.List;
public record PollDto(long id, String question, Instant publishedAt, Instant validUntil, long createdByUserId, List<Long> voteOptionIds) {}
