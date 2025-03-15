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
        pluginsDir.deleteRecursively()
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