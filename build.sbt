organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.4.0"
  val sprayV = "1.3.3"
  val sprayJsonV = "1.3.2"
  val swaggerV = "0.5.1"
  val specs2V = "2.3.11"
  val scalDiV = "0.4"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "io.spray"            %%  "spray-json"    % sprayJsonV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % specs2V % "test",
    "com.gettyimages"     %% "spray-swagger"  % swaggerV,
    "org.scaldi"          %% "scaldi"         % scalDiV
  )
}

Revolver.settings
