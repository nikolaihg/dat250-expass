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
- Ran `Pollstest`.java and the three test passed.
- I changes the h2 properties to:  
```.property(PersistenceConfiguration.JDBC_URL,
          "jdbc:h2:file:C:/Users/nikol/Documents/_Master/DAT250/expass4/dat250-expass4/pollsdb")
```
so that i could view the database after running the tests.

### Technical problems
- After updating the entities with methods and JPA annotations, I still had the error "Cannot resolve symbol 'PersistenceConfiguration'" in `PollsTest.java`:
    - ![error](.\screenshots\expass4\img.png)
    - After tinkering for a while with the existing project, I tried to make a brand new one using gradle init.
        - After doing this, and copying my files from the previous project, all three test passes. 


