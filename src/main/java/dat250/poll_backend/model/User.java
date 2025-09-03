package dat250.poll_backend.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Poll> userPolls;
    private List<Vote> userVotes;

    public User() {
        this.userPolls = new ArrayList<>();
        this.userVotes = new ArrayList<>();
    }

    public User(String username, String email, List<Poll> userPolls, List<Vote> userVotes) {
        this.username = username;
        this.email = email;
        this.userPolls = userPolls;
        this.userVotes = userVotes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Poll> getUserPolls() {
        return userPolls;
    }

    public void setUserPolls(List<Poll> userPolls) {
        this.userPolls = userPolls;
    }

    public List<Vote> getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(List<Vote> userVotes) {
        this.userVotes = userVotes;
    }
}