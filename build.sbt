
organization in ThisBuild := "com.optrak"
version in ThisBuild := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.8"

val myScalacOptions = Seq(
  "-feature",
  "-deprecation",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-unchecked",
  "-deprecation",
  "-Xfuture",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused"
)


val clapper = "org.clapper" % "grizzled-slf4j_2.11" % "1.3.0"

lazy val commonSettings = Seq(
  parallelExecution in Test := false,
  scalacOptions ++= myScalacOptions,
  scalaVersion := "2.11.8",
  organization := "optrak",
  exportJars := true,
  updateOptions := updateOptions.value.withCachedResolution(true),
  resolvers ++= Seq(
    "optrak repo" at "https://office.optrak.com/code/releases/",
    "optrak thirdparty" at "https://office.optrak.com/code/thirdparty/"
  )
)

val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test

val stdImplDependencies = Seq(
  libraryDependencies ++= Seq(
    lagomScaladslPersistenceCassandra,
    lagomScaladslKafkaBroker,
    clapper,
    macwire,
    scalaTest,
    lagomScaladslTestKit
  ))

// --------- Counters base ---------
lazy val `common` = (project in file("common/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .settings(libraryDependencies ++= Seq(
    clapper,
    lagomScaladslApi,
    lagomScaladslPersistenceCassandra
  ))


lazy val `api1` = (project in file("counter1/api"))
  .settings(commonSettings: _*)
  .dependsOn(`common`)

lazy val `impl1` = (project in file("counter1/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`api1`)
  .settings(stdImplDependencies)

lazy val `api2` = (project in file("counter2/api"))
  .settings(commonSettings: _*)
  .dependsOn(`common`)

lazy val `impl2` = (project in file("counter2/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`api2`)
  .settings(stdImplDependencies)

