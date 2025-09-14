### Expass 1
see [screenshot](screenshots/expass1/Screenshot%202025-08-29%20172414.png) for the actual delivery.

Here are just some notes for me.
- `.github/workflows/ci.yml`  
  on push to main, the action runs tests and builds the application.
- Docker (https://docs.docker.com/guides/java/configure-ci-cd/)
    - `docker init`
    - `docker compose up --build`
    - `docker compose up --build -d` Running detached
    - `docker compose up` /-d after building
    - `docker compose down` shutdown
- Dockerhub
    - See branch dockerhub & `dockerhub.yml`
    - You can dockerize, but dockerhub github action fails in hub buildx.