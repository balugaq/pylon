run {
    val corePath = file(".").resolve("core")
    if (!corePath.exists()) {
        Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-core", corePath.toString())).waitFor()
    }
}

run {
    val basePath = file(".").resolve("base")
    if (!basePath.exists()) {
        Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-base", basePath.toString())).waitFor()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "pylon"
includeBuild("core")
includeBuild("base")
