# HVL DAT250 Experiment Assignment 2
- Nikolai Hansen Gangstø
- nigan4342
- september 2025
## Report
### Step 1: Installation
Started the project with spring initilizr and opened it in intellij and verified with the simple hello world from expass1.
### Step 2: Domain and manager
- Created the beans under `\domain`.  
  - Tried to use as simple as possible data structures, such as lists, strings, ints and long for its and options. 
  - Used intellij generate for getters and setters.
- `PollManager.java` in `\manager`.
  - Everything is stored in memory and will be deleted after program restart.
- DTOs under `\dto` to avoid cycles for json.
  - Using records fitting each domain
### Step 3: TDD & requests.http
I implemented a comprehensive test scenario following the Test-Driven Development approach. Initially, I overcomplicated the solution by attempting to create formal unit tests in the `src/test` directory, but I realized this step was focused on designing request sequences to validate the API functionality before implementation.

I created a [requests.http](requests.http) file containing all the required test scenarios in HTTP client format.

### Step 4: Controllers
- Implemented controllers for each model under `/controller`:
  - One for each of the four domains.
- Simple URLs:
  - Users: `/api/users` 
  - Polls: `/api/polls` 
  - Vote options: `/api/polls/{pollId}/options` and `/api/options/{optionId}` 
  - Votes: `/api/polls/{pollId}/votes`
- Ran the http test from step 3 and it worked like a charm.
![requests.png](/screenshots/expass2/requests.png)

### Step 5: Automate testing
- Created the test: `src/test/IntegrationTest` that runs the scenario from step 3.

### Step 6: API documentation
- I have not done this step

### Step 7: Build automation
- In expass1 I created a github action called `.github/workflows/ci.yml` that builds the app and runs the tests in the repo on push to main branch.
## Notes
### Added ids and DTOS
Added ids and dtos to help jackson serialization without infinite recursion.

### Technical problems
#### Build problems:
After working on the project for a while (i suspect after adding dockerization), i got trouble with building the project using `\gradlew.bat`:
```bash
Unable to delete directory 'C:\Users\nikol\Documents\_Master\DAT250\expass2\dat250-expass\build\classes\java\main' Failed to delete some children. This might happen because a process has files open or has its working directory set in the target directory. 
- C:\Users\nikol\Documents\_Master\DAT250\expass2\dat250-expass\build\classes\java\main\dat250\poll_backend\manager 
- C:\Users\nikol\Documents\_Master\DAT250\expass2\dat250-expass\build\classes\java\main\dat250\poll_backend\model 
- C:\Users\nikol\Documents\_Master\DAT250\expass2\dat250-expass\build\classes\java\main\dat250\poll_backend 
- C:\Users\nikol\Documents\_Master\DAT250\expass2\dat250-expass\build\classes\java\main\dat250
```
But after manually deleting everything in build and restarting the gradle daemon it worked again. But this took some time to troubleshoot. And often i had to delete tha build folder manually and force the daemon to stop.
#### Dockerhub problems
Managed to dockerize the application and could run it locally. But the dockerhub.yml action does not work for publishing on dockerhub (fails on github action with buildx error).

