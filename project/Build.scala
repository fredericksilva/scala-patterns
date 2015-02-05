import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtSite._

object Build extends Build {
  import Dependencies._
  import Formatting._

  lazy val basicSettings = Seq(
    organization := "com.xebia",
    version := "0.1.0",
    scalaVersion := "2.11.5"
  )

  lazy val compileSettings = Seq(
    scalaSource in Compile := baseDirectory.value / "src/sphinx/code"
  )

  lazy val root = Project("sa-pattern", file("."))
    .settings(basicSettings: _*)
    .settings(compileSettings: _*)
    .settings(formattingSettings: _*)
    .settings(site.settings: _*)
    .settings(site.sphinxSupport(): _*)
    .settings(libraryDependencies ++= specs2)
              
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
