plugins {
    id("xyz.jpenilla.run-paper") version "2.3.0"
}

val baseBuild = gradle.includedBuild("base")
val coreBuild = gradle.includedBuild("core")

tasks.runServer {
    dependsOn(baseBuild.task(":shadowJar"), coreBuild.task(":pylon-core:shadowJar"))

    doFirst {
        val runFolder = project.projectDir.resolve("run")
        runFolder.mkdirs()
        runFolder.resolve("eula.txt").writeText("eula=true")

        val pluginsDir = runFolder.resolve("plugins")
        pluginsDir.mkdirs()
        copy {
            from(baseBuild.projectDir.resolve("build/libs")) {
                include("pylon-base-MODIFIED.jar")
            }
            into(pluginsDir)
        }
        copy {
            from(coreBuild.projectDir.resolve("pylon-core/build/libs")) {
                include("pylon-core-SNAPSHOT.jar")
            }
            into(pluginsDir)
        }
    }

    maxHeapSize = "4G"
    minecraftVersion("1.21.4")
}

tasks.register("runSnapshotServer") {
    dependsOn(tasks.runServer)
    group = "run paper"
}

tasks.register("runStableServer") {
    dependsOn(baseBuild.task(":runServer"))
    group = "run paper"
}

tasks.register("runLiveTests") {
    dependsOn(coreBuild.task(":pylon-test:runServer"))
    group = "run paper"
}