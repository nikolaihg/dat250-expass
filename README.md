# dat250-expass
- shared repo for all the backend expass deliveries by me. That builds on springboot+java poll app.
- See [nikolaihg/dat250-expass-frontend](https://github.com/nikolaihg/dat250-expass-frontend) for the orginal frontend repo (now also moved to this repo).
- See [nikolaihg/dat250-expass4](https://github.com/nikolaihg/dat250-expass4) for the code for assignment 4.

## Project Structure
- `backend/` - Spring Boot REST API
- `frontend/` - Single Page Svelte Application

## Running the app
```bash
# Clean everything 
.\gradlew.bat cleanAll
# Build everything
./gradlew buildAll

# Run the application
./gradlew runApp

# Test individual components
./gradlew :backend:test
./gradlew :frontend:npmRunBuild
```
### Only Backend
```bash
cd backend

./gradlew bootRun
# or
./gradlew bootRun --continuous
```
### Only frontend
```bash
cd frontend

npm install

npm run dev
```

## Assigments
- [expass1.md](dat250-expass1.md)
  - [screenshot](screenshots/expass1/Screenshot%202025-08-29%20172414.png)
- [expass2.md](dat250-expass2.md)
- [expass3.md](dat250-expass3.md)
- [expass4.md](dat250-expass4.md)
