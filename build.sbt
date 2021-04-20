name := "ItemFilter"
version := "3.0.0"

scalaVersion := "2.13.5"
// format: off
javacOptions ++= Seq("-Xlint", "-encoding", "UTF-8")
scalacOptions ++= Seq(
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:postfixOps",              // Explicitly enables the postfix ops feature
  "-language:implicitConversions",     // Explicitly enables the implicit conversions feature
  "-Ybackend-parallelism", "6",        // Maximum worker threads for backend.
  "-Ybackend-worker-queue", "10",      // Backend threads worker queue size.
  "-Ymacro-annotations",               // Enable support for macro annotations, formerly in macro paradise.
  "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
  "-Xmigration:2.14.0",                // Warn about constructs whose behavior may have changed since version.
  //"-Xfatal-warnings", "-Werror",       // Fail the compilation if there are any warnings.
  "-Xlint:_",                          // Enables every warning. scalac -Xlint:help for a list and explanation
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-Wdead-code",                       // Warn when dead code is identified.
  "-Wextra-implicit",                  // Warn when more than one implicit parameter section is defined.
  "-Woctal-literal",                   // Warn on obsolete octal syntax.
  "-Wunused:_",                        // Enables every warning of unused members/definitions/etc
  "-Wunused:patvars",                  // Warn if a variable bound in a pattern is unused.
  "-Wunused:params",                   // Enable -Wunused:explicits,implicits. Warn if an explicit/implicit parameter is unused.
  "-Wunused:linted",                   // -Xlint:unused <=> Enable -Wunused:imports,privates,locals,implicits.
  "-Wvalue-discard",                   // Warn when non-Unit expression results are unused.
)
// format: on

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

val http4sVersion = "1.0.0-M21"
val circeVersion = "0.14.0-M5"
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.2",
  "org.typelevel"          %% "cats-core"                  % "2.5.0",
  "org.typelevel"          %% "cats-effect"                % "3.0.2",
  "org.http4s"             %% "http4s-dsl"                 % http4sVersion,
  "org.http4s"             %% "http4s-blaze-client"        % http4sVersion,
  "org.http4s"             %% "http4s-circe"               % http4sVersion,
  "io.circe"               %% "circe-core"                 % circeVersion,
  "io.circe"               %% "circe-generic"              % circeVersion,
  "io.circe"               %% "circe-parser"               % circeVersion,
  "com.github.pureconfig"  %% "pureconfig"                 % "0.14.1",
  "org.slf4j"               % "slf4j-nop"                  % "2.0.0-alpha1",
  "com.github.tminglei"    %% "slick-pg"                   % "0.19.5",
  "com.typesafe.slick"     %% "slick-hikaricp"             % "3.3.3",
  "org.postgresql"          % "postgresql"                 % "42.2.9",
  "org.flywaydb"            % "flyway-core"                % "7.7.3",
  //"com.github.blemale"     %% "scaffeine"                     % "3.1.0",
  //"org.scalatest"          %% "scalatest"                     % "3.1.0-RC3" % Test,
  //"com.codecommit"         %% "cats-effect-testing-scalatest" % "0.3.0" % Test,
  //"com.github.tomakehurst" % "wiremock-jre8"                  % "2.25.1" % Test,
)

enablePlugins(JavaServerAppPackaging)
maintainer := "amuxix@gmail.com"

Test / logBuffered := false
