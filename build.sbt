import AssemblyKeys._

assemblySettings

name := "bokun-api"

version := "0.1"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
    "com.fasterxml.jackson.core" % "jackson-core" % "2.2.2",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2",
    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.2",
    "com.ning" % "async-http-client" % "1.7.10",
    "commons-codec" % "commons-codec" % "1.7",
    "ch.qos.logback" % "logback-classic" % "1.0.9",
    "ch.qos.logback" % "logback-core" % "1.0.9",
    "com.google.inject" % "guice" % "3.0"
)