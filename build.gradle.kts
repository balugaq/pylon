import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.gradleup.shadow") version "8.3.2"
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
    }

    pluginJars(
        baseBuild.projectDir.resolve("build/libs").listFiles().first(),
        coreBuild.projectDir.resolve("pylon-core/build/libs").listFiles().first()
    )

    maxHeapSize = "4G"
    minecraftVersion("1.21.4")
}