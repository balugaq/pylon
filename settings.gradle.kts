run {
    val core = file("core")
    if (!core.exists()) {
        Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-core", core.toString())).waitFor()
    }
}

run {
    val base = file("base")
    if (!base.exists()) {
        Runtime.getRuntime().exec(arrayOf("git", "clone", "https://github.com/pylonmc/pylon-base", base.toString())).waitFor()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "pylon"
includeBuild("core")
includeBuild("base")
