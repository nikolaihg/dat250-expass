# HVL DAT250 Experiment Assignment 3
- Nikolai Hansen Gangstø
- nigan4342
- september 2025

## Link to code: 
[github.com/nikolaihg/dat250-expass-frontend](https://github.com/nikolaihg/dat250-expass-frontend)
## Report
I chose svelte as my framework. I have worked a lot with react, next.js and typescript, so I chose to use typescript with svelte.
### Step 1
I choose to use pnpm while developing, because its faster (not that this project has very many dependencies), but its what I am used to when I have using react.
### Step 2
I created three components: `CreateUser.svelte`, `CreatePoll.svelte`, `Vote.svelte`. And then integrated them together in `App.svelte` by creating a navigation bar and a view (this view changes the showing component, when you press the navbar).
### Step 3
- Annotated each of the four controllers with `@CrossOrigin`
### Step 4
- Implemented fetching.
- Showcase:  
#### Create User:   
![screenshots\expass3\user.png](screenshots\expass3\user.png)
![screenshots\expass3\listusers.png](screenshots\expass3\listusers.png)
#### Create Poll:
![screenshots\expass3\poll.png](screenshots\expass3\poll.png)
![screenshots\expass3\listpolls.png](screenshots\expass3\listpolls.png)
#### Vote on poll:  
![screenshots\expass3\vote.png](screenshots\expass3\vote.png)
![screenshots\expass3\listpolls.png](screenshots\expass3\listpolls.png)
### Step 5
- Built the page and copied. Did not have time to integrate it into the same repo (`\frontend` and `\backend`) so no automate build using gradle.
### Step 6
- Did not do any of these optional tasks
### Technical problems
- I struggled a bit with the svelte 5 "runes", but i got it in the end.
- I had to change some things from the restapi made in expass2 while creating the SPA.
- Got whitelabel error afte building frontend and copying it into `\static`. Did not manage to fix this. But the app worked perfectly when you ran spring on port 8080 and svelte on port 5173.


