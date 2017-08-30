name := "scalate-poc"

version := "1.0"

val scalaVersion = "2.12.3"
val circeVersion = "0.8.0"
val http4sVersion = "0.15.16a"
val scalazVersion = "7.2.15"
val doobieVersion = "0.4.4"
val scalaTagsVersion = "0.6.5"

cancelable in Global := true


libraryDependencies ++= {
  Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "org.http4s" %% "http4s-dsl" % http4sVersion,
    "org.http4s" %% "http4s-blaze-server" % http4sVersion,
    "org.http4s" %% "http4s-blaze-client" % http4sVersion,
    "org.scalaz" %% "scalaz-core" % scalazVersion,
    "org.scalaz" %% "scalaz-concurrent" % scalazVersion,
    "org.tpolecat" %% "doobie-core" % doobieVersion,
    "org.tpolecat" %% "doobie-hikari" % doobieVersion,
    "org.tpolecat" %% "doobie-postgres" % doobieVersion,
    "com.lihaoyi" %% "scalatags" % scalaTagsVersion
  )
}
