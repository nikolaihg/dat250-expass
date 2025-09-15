plugins {
    id("com.github.node-gradle.node") version "7.0.2" apply false
}

allprojects {
    group = "dat250"
    version = "0.0.1-SNAPSHOT"
    description = "Poll app rest api"
}

tasks.register("buildAll") {
    dependsOn(":backend:build", ":frontend:copyWebApp")
    description = "Builds both backend and frontend"
}

tasks.register("runApp") {
    dependsOn(":backend:bootRun")
    description = "Runs the Spring Boot application with integrated frontend"
}

tasks.register("cleanAll") {
    dependsOn(":backend:clean", ":frontend:cleanWebApp")
    description = "Cleans both backend and frontend"
}
