# HVL DAT250 Experiment Assignment 4
- Nikolai Hansen Gangstø
- nigan4342
- september 2025
## Code
Link to code: https://github.com/nikolaihg/dat250-expass4
## Report
### Step 1
- Added methods `createPoll` and `voteFor` in `User.java`.
- Added method `addVoteOption` in `Vote.java`.
- `User.java`: Added @Entity, @Table, @Id, @GeneratedValue, @Column, @OneToMany annotations
- `Poll.java`: Added JPA annotations and proper relationships
- `VoteOption.java`: Added JPA annotations with bidirectional relationships
- `Vote.java`: Added JPA annotations for the voting relationship

### Step 2
- 
### Technical problems
- After updating the entities with methods and JPA annotations, I still had the error "Cannot resolve symbol 'PersistenceConfiguration'" in `PollsTest.java`:
    - ![error](.\screenshots\expass4\img.png)
- I tried makin a brand new gralde project to fix this proplem 


