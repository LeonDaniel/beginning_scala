lazy val root = project
  .in(file("."))
  .settings(
    name := "Learning Scala",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := "3.1.3",

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )
