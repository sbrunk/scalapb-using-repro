val scala3Version = "3.3.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalapb-using-repro",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
       // "io.qdrant" % "client" % "1.8.0",
      "io.qdrant" % "client" % "1.8.0" % "protobuf-src" intransitive (),
      "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.11" % "2.9.6-0" % "protobuf",
      "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.11" % "2.9.6-0",
    ),
    Compile / PB.targets := Seq(
      PB.gens.java                        -> (Compile / sourceManaged).value,
      scalapb.gen(javaConversions = true) -> (Compile / sourceManaged).value
    )
  )
