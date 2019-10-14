import sbt._
import sbt.Keys._

lazy val push2s = (project in file("."))
  .settings(
    name := "push2s",
    libraryDependencies ++= netty
  )

val versions = Map(
  "netty" -> "4.1.42.Final"
)
val netty = Seq(
  "io.netty" % "netty-codec-http2",
  "io.netty" % "netty-handler-proxy",
  "io.netty" % "netty-handler",
  "io.netty" % "netty-resolver-dns"
).map(_ % versions("netty"))
