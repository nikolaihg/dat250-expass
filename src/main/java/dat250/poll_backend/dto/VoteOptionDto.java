package dat250.poll_backend.dto;

public record VoteOptionDto(long id, long pollId, String caption, int presentationOrder) {}
