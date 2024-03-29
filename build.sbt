ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-scala"
  )

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum" % "1.7.3"
)