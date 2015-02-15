import sbt._
import sbt.Keys._

object Dependencies {
  lazy val dependencySettings = Seq(
    resolvers := Seq(
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )

  val specs2    = "org.specs2"        %% "specs2-core" % "2.4.15"
  val akkaActor = "com.typesafe.akka" %% "akka-actor"  % "2.3.9"
}