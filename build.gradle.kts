import kotlin.io.path.exists
import kotlin.io.path.Path

run {
    val corePath = Path("${projectDir}/pylon-core")
    if (!corePath.exists()) {
        exec {
            commandLine("git", "clone", "https://github.com/pylonmc/pylon-core", corePath.toString())
        }
    }
}

run {
    val basePath = Path("${projectDir}/pylon-base")
    if (!basePath.exists()) {
        exec {
            commandLine("git", "clone", "https://github.com/pylonmc/pylon-base", basePath.toString())
        }
    }
}