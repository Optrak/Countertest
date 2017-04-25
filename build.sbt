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

// --------- Counters 1 ---------
lazy val `erp-counters-api1` = (project in file("counter1/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl1` = (project in file("counter1/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api1`)

  .settings(stdImplDependencies)

// --------- Counters 2 ---------
lazy val `erp-counters-api2` = (project in file("counter2/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl2` = (project in file("counter2/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api2`)
  .settings(stdImplDependencies)

// --------- Counters 3 ---------


lazy val `erp-counters-api3` = (project in file("counter3/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl3` = (project in file("counter3/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api3`)
  .settings(stdImplDependencies)

// --------- Counters 4 ---------


lazy val `erp-counters-api4` = (project in file("counter4/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl4` = (project in file("counter4/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api4`)
  .settings(stdImplDependencies)


// --------- Counters 5 ---------

lazy val `erp-counters-api5` = (project in file("counter5/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl5` = (project in file("counter5/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api5`)
  .settings(stdImplDependencies)


// --------- Counters 6 ---------

lazy val `erp-counters-api6` = (project in file("counter6/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl6` = (project in file("counter6/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api6`)
  .settings(stdImplDependencies)

// --------- Counters 7 ---------

lazy val `erp-counters-api7` = (project in file("counter7/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl7` = (project in file("counter7/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api7`)
  .settings(stdImplDependencies)

// --------- Counters 8 ---------

lazy val `erp-counters-api8` = (project in file("counter8/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl8` = (project in file("counter8/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api8`)
  .settings(stdImplDependencies)

// --------- Counters 9 ---------

lazy val `erp-counters-api9` = (project in file("counter9/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl9` = (project in file("counter9/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api9`)
  .settings(stdImplDependencies)


/// --------- Counters 10 ---------

lazy val `erp-counters-api10` = (project in file("counter10/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl10` = (project in file("counter10/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api10`)
  .settings(stdImplDependencies)




// --------- Counters 11 ---------

lazy val `erp-counters-api11` = (project in file("counter11/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl11` = (project in file("counter11/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api11`)
  .settings(stdImplDependencies)

// --------- Counters 12 ---------

lazy val `erp-counters-api12` = (project in file("counter12/api"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .settings(libraryDependencies ++= Seq(
    lagomScaladslApi
  ))

lazy val `erp-counters-impl12` = (project in file("counter12/impl"))
  .enablePlugins(LagomScala)
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`erp-model`)
  .dependsOn(`erp-counters-api12`)
  .settings(stdImplDependencies)

lazy val `erp-model` = (project in file("model"))
  .settings(commonSettings: _*)
  .settings(lagomForkedTestSettings: _*)






