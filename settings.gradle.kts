run {
    Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/balugaq/pylon-core")).waitFor()
}

run {
    Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/balugaq/pylon-base")).waitFor()
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "pylon"
includeBuild("pylon-core")
includeBuild("pylon-base")
