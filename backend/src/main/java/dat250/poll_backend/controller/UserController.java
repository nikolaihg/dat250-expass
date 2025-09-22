package dat250.poll_backend.controller;
/*
import dat250.poll_backend.domain.User;
import dat250.poll_backend.dto.UserDto;
import dat250.poll_backend.manager.PollManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final PollManager pm;
    public UserController(PollManager pm) { this.pm = pm; }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto req) {
        User u = pm.createUser(req.username(), req.email());
        return ResponseEntity.ok(new UserDto(u.getId(), u.getUsername(), u.getEmail()));
    }

    @GetMapping
    public List<UserDto> listUsers() {
        return pm.listUsers().stream()
                .map(u -> new UserDto(u.getId(), u.getUsername(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        boolean ok = pm.deleteUser(id);
        return ok ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
 */
