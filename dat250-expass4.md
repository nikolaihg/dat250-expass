# HVL DAT250 Experiment Assignment 4
- Nikolai Hansen Gangstø
- nigan4342
- september 2025
## Code
The code for this assignment is under the branch `expass4` in this [repo](https://github.com/nikolaihg/dat250-expass/).  
Link: https://github.com/nikolaihg/dat250-expass/tree/expass4 
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


