name := """scaline-board"""
organization := "58"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.3.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "2.2.224",
  "org.playframework" %% "play-slick" % "6.1.0",
  "org.playframework" %% "play-slick-evolutions" % "6.1.0",
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "58.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "58.binders._"
