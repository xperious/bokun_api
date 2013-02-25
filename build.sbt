name := "bokun-api"

version := "1.0"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
    "org.codehaus.jackson" % "jackson-core-asl" % "1.9.12",
    "com.ning" % "async-http-client" % "1.7.10",
    "commons-codec" % "commons-codec" % "1.7",
    "com.codiform" % "moo" % "1.3"
)