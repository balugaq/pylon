import kotlin.io.path.exists
import kotlin.io.path.Path

run {
    val corePath = Path("core").toAbsolutePath()
    print(corePath)
    if (!corePath.exists()) {
        exec {
            commandLine("git", "clone", "https://github.com/pylonmc/pylon-core", corePath.toString())
        }
    }
}

run {
    val basePath = Path("base").toAbsolutePath()
    print(basePath)
    if (!basePath.exists()) {
        exec {
            commandLine("git", "clone", "https://github.com/pylonmc/pylon-base", basePath.toString())
        }
    }
}

System.setProperty("io.github.pylonmc.pylon.composite", "true")

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "pylon"
includeBuild("core")
includeBuild("base")
