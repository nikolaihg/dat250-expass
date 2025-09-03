# dat250-expass

## notes
### Expass 1
- `.github/workflows/ci.yml`  
on push to main, the action runs tests and builds the application.
- Docker (https://docs.docker.com/guides/java/configure-ci-cd/)
  - `docker init`
  - `docker compose up --build`
  - `docker compose up --build -d` Running detached
  - `docker compose up` /-d after building
  - `docker compose down` shutdown
### Expass 2