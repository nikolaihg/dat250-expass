package dat250.poll_backend.manager;

import dat250.poll_backend.model.Poll;
import dat250.poll_backend.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PollManager {
    private final HashMap<Integer, Poll> pollMap;
    private final HashMap<String, User> userMap;

    public PollManager() {
        userMap = new HashMap<>();
        pollMap = new HashMap<>();
    }


    public HashMap<Integer, Poll> getPollMap() {
        return pollMap;
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public void setUser(String username, User newUser){
        userMap.put(username, newUser);
    }

    public void setPoll(int pollId, Poll newPoll){
        pollMap.put(pollId, newPoll);
    }
}
