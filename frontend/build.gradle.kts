import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node")
}

node {
    version = "22.0.0"
    npmVersion = "10.5.1"
    download = true
}

tasks.register<NpmTask>("npmRunBuild") {
    args = listOf("run", "build")
    inputs.dir("src")
    inputs.file("package.json")
    inputs.file("vite.config.ts")

    // Also include Svelte-specific files if they exist
    inputs.files(fileTree(".") {
        include("svelte.config.js", "jsconfig.json", "tsconfig.json")
        exclude("node_modules/**")
    })

    outputs.dir("dist")
}

tasks.register<Copy>("copyWebApp") {
    from("dist")
    into("../backend/src/main/resources/static")
    dependsOn("npmRunBuild")
    description = "Builds frontend and copies to Spring Boot static resources"
}

tasks.register<Delete>("cleanWebApp") {
    delete("../backend/src/main/resources/static")
    delete("dist")
    delete("node_modules/.cache")
}

tasks.register<Delete>("clean") {
    dependsOn("cleanWebApp")
    description = "Cleans frontend build artifacts"
}

tasks.register("build") {
    dependsOn("copyWebApp")
    description = "Builds the frontend application"
}