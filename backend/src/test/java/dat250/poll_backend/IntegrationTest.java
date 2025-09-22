package dat250.poll_backend;
/*
import dat250.poll_backend.controller.PollController;
import dat250.poll_backend.controller.VoteController;
import dat250.poll_backend.controller.VoteOptionController;
import dat250.poll_backend.dto.PollDto;
import dat250.poll_backend.dto.UserDto;
import dat250.poll_backend.dto.VoteDto;
import dat250.poll_backend.dto.VoteOptionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate rest;

    @Test
    public void fullScenario() {
        String base = "http://localhost:" + port;

        // 1) Create user1
        UserDto user1 = rest.postForEntity(base + "/api/users",
                new UserDto(0,"alice","alice@example.com"), UserDto.class).getBody();
        Assertions.assertNotNull(user1);
        Assertions.assertEquals("alice", user1.username());

        // 2) Create user2
        UserDto user2 = rest.postForEntity(base + "/api/users",
                new UserDto(0,"bob","bob@example.com"), UserDto.class).getBody();
        Assertions.assertNotNull(user2);
        Assertions.assertEquals("bob", user2.username());

        // 3) List all users
        ResponseEntity<UserDto[]> usersResp = rest.getForEntity(base + "/api/users", UserDto[].class);
        UserDto[] users = usersResp.getBody();
        Assertions.assertEquals(2, users.length);

        // 4) User1 creates a poll
        PollController.CreatePollRequest pollReq = new PollController.CreatePollRequest();
        pollReq.question = "Which color?";
        pollReq.publishedAt = Instant.now();
        pollReq.validUntil = Instant.now().plusSeconds(3600);
        pollReq.createdByUserId = user1.id();

        ResponseEntity<PollDto> pollResp = rest.postForEntity(base + "/api/polls", pollReq, PollDto.class);
        PollDto poll = pollResp.getBody();
        Assertions.assertNotNull(poll);
        long pollId = poll.id();

        // 5) Add options to poll
        VoteOptionController.CreateOptionRequest opt1 = new VoteOptionController.CreateOptionRequest();
        opt1.caption = "Red"; opt1.presentationOrder = 1;
        VoteOptionDto option1 = rest.postForEntity(base + "/api/polls/" + pollId + "/options", opt1, VoteOptionDto.class).getBody();

        VoteOptionController.CreateOptionRequest opt2 = new VoteOptionController.CreateOptionRequest();
        opt2.caption = "Blue"; opt2.presentationOrder = 2;
        VoteOptionDto option2 = rest.postForEntity(base + "/api/polls/" + pollId + "/options", opt2, VoteOptionDto.class).getBody();

        Assertions.assertNotNull(option1);
        Assertions.assertNotNull(option2);

        // 6) List polls
        ResponseEntity<PollDto[]> pollsResp = rest.getForEntity(base + "/api/polls", PollDto[].class);
        PollDto[] polls = pollsResp.getBody();
        Assertions.assertEquals(1, polls.length);

        // 7) User2 votes on poll (option2)
        VoteController.VoteRequest voteReq1 = new VoteController.VoteRequest();
        voteReq1.userId = user2.id();
        voteReq1.voteOptionId = option2.id();
        VoteDto vote1 = rest.postForEntity(base + "/api/polls/" + pollId + "/votes", voteReq1, VoteDto.class).getBody();
        Assertions.assertEquals(option2.id(), vote1.voteOptionId());

        // 8) User2 changes vote to option1
        VoteController.VoteRequest voteReq2 = new VoteController.VoteRequest();
        voteReq2.userId = user2.id();
        voteReq2.voteOptionId = option1.id();
        VoteDto vote2 = rest.postForEntity(base + "/api/polls/" + pollId + "/votes", voteReq2, VoteDto.class).getBody();
        Assertions.assertEquals(option1.id(), vote2.voteOptionId());

        // 9) List votes for poll
        ResponseEntity<VoteDto[]> votesResp = rest.getForEntity(base + "/api/polls/" + pollId + "/votes", VoteDto[].class);
        VoteDto[] votes = votesResp.getBody();
        Assertions.assertEquals(1, votes.length); // only latest vote per user
        Assertions.assertEquals(option1.id(), votes[0].voteOptionId());

        // 10) Delete the poll
        rest.delete(base + "/api/polls/" + pollId);

        // 11) List votes (should be empty)
        ResponseEntity<VoteDto[]> votesAfterDeleteResp = rest.getForEntity(base + "/api/polls/" + pollId + "/votes", VoteDto[].class);
        VoteDto[] votesAfterDelete = votesAfterDeleteResp.getBody();
        Assertions.assertEquals(0, votesAfterDelete.length);
    }
}
 */