run {
    Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-core")).waitFor()
}

run {
    Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-base")).waitFor()
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "pylon"
includeBuild("pylon-core")
includeBuild("pylon-base")
