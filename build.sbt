name := "finatra"

organization := "com.twitter"

version := "1.5.4G"

scalaVersion := "2.11.6"

//Main

libraryDependencies ++= Seq(
  "com.twitter" %% "twitter-server" % "1.12.0",
  "commons-io" % "commons-io" % "2.4",
  "org.scalatest" %% "scalatest" % "2.2.6",
  "com.google.code.findbugs" % "jsr305" % "2.0.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.4",
  "com.github.spullara.mustache.java" % "compiler" % "0.9.0",
  "com.github.spullara.mustache.java" % "scala-extensions-2.11" % "0.9.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.4"
)

// for code coverage
//instrumentSettings

//coverallsSettings

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

//Release

resolvers +=
  "Twitter" at "http://maven.twttr.com"

resolvers +=
  "Local Maven Repository" at "file:///"+Path.userHome+"/.m2/repository"

resolvers += Classpaths.sbtPluginReleases

publishMavenStyle := true

publishTo := {
  val nexus = "http://maven.glopart.ru/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "repository/maven-snapshots")
  else
    Some("releases" at nexus + "repository/maven-releases")
}

credentials += {
  val mavenPass = Option(System.getenv("MAVEN_PASS"))
  if (mavenPass.isDefined) {
    val mavenUser = Option(System.getenv("MAVEN_USER")).getOrElse("ci")
    println(s"Use maven user $mavenUser")
    Credentials("Sonatype Nexus", "maven.glopart.ru", mavenUser, mavenPass.get)
  } else {
    Credentials(Path.userHome / ".sbt" / "credentials")
  }
}

licenses := Seq("Apache License, Version 2.0" ->
  url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("http://finatra.info"))