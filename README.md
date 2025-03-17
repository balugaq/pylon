# Pylon

This is the master Gradle project for Pylon. To set up the subprojects, simply run `./gradlew`.
pylon-base and pylon-core are each their own Git repository. Therefore, any changes made to them must be committed and pushed separately.

## Tasks
For the purposes of explanation, "snapshot" refers to the latest, local development 
version of Base and Core, while "stable" refers to the latest release.

- `./gradlew runSnapshotServer` starts a server with snapshot versions of Base and Core.
- `./gradlew runStableServer` starts a server with snapshot Base and stable Core.
- `./gradlew runLiveTests` runs the live tests against a server with snapshot Core.