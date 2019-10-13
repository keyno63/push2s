import sbt._
import sbt.Keys._

lazy val push2s = (project in file("."))
  .settings(
    name := "push2s",
  )
