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
  val akkaTestkit = "com.typesafe.akka" %% "akka-testkit"  % "2.3.9"
  val scalatest                = "org.scalatest"           %% "scalatest"                     % "2.2.4"
  
}