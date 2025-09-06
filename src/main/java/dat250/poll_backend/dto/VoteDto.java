package dat250.poll_backend.dto;

import java.time.Instant;
public record VoteDto(long id, long pollId, long userId, long voteOptionId, Instant publishedAt) {}
