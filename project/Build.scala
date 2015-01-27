import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtSite._

object Build extends Build {
  lazy val basicSettings = Seq(
    organization := "com.rfs",
    version := "0.1.0",
    scalaVersion := "2.11.5"
    // scalacOptions := basicScalacOptions,
    // incOptions := incOptions.value.withNameHashing(true),
    // parallelExecution in Test := false
  )

  lazy val root = Project("sa-pattern", file("."))
    .settings(basicSettings: _*)
    .settings(site.settings: _*)
    .settings(site.sphinxSupport(): _*)

  val basicScalacOptions = Seq(
    "-encoding", "utf8",
    "-target:jvm-1.7",
    "-feature",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-unchecked",
    "-deprecation",
    "-Xlog-reflective-calls",
    "-Ywarn-unused",
    "-Ywarn-unused-import"
  )
}