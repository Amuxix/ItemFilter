name := "ItemFilter"
version := "2.0"

scalaVersion := "2.13.0"
// format: off
scalacOptions ++= Seq(
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:postfixOps",              // Explicitly enables the postfix ops feature
  "-language:implicitConversions",     // Explicitly enables the implicit conversions feature
  "-Ybackend-parallelism", "4",        // Maximum worker threads for backend.
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
  //"-Wself-implicit",                   // Warn when an implicit resolves to an enclosing self-definition.
  "-Wunused:_",                        // Enables every warning of unused members/definitions/etc
  "-Wunused:patvars",                  // Warn if a variable bound in a pattern is unused.
  "-Wunused:params",                   // Enable -Wunused:explicits,implicits. Warn if an explicit/implicit parameter is unused.
  "-Wunused:linted",                   // -Xlint:unused <=> Enable -Wunused:imports,privates,locals,implicits.
  //"-Wvalue-discard",                   // Warn when non-Unit expression results are unused.
)
// format: on

addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")

val http4sVersion = "0.21.0-M4"
val circeVersion = "0.12.0-RC1"
libraryDependencies ++= Seq(
  "org.slf4j"             % "slf4j-nop"            % "1.8.0-beta2",
  "com.github.tminglei"   %% "slick-pg"            % "0.18.0",
  "com.github.tminglei"   %% "slick-pg_jts"        % "0.18.0",
  "com.typesafe.slick"    %% "slick-hikaricp"      % "3.3.2",
  "org.postgresql"        % "postgresql"           % "42.2.5",
  "org.flywaydb"          % "flyway-core"          % "5.2.0",
  "org.typelevel"         %% "cats-effect"         % "2.0.0-RC1",
  "com.github.pureconfig" %% "pureconfig"          % "0.11.1",
  "com.github.pathikrit"  %% "better-files"        % "3.8.0",
  "org.http4s"            %% "http4s-dsl"          % http4sVersion,
  "org.http4s"            %% "http4s-blaze-client" % http4sVersion,
  "org.http4s"            %% "http4s-circe"        % http4sVersion,
  "io.circe"              %% "circe-core"          % circeVersion,
  "io.circe"              %% "circe-generic"       % circeVersion,
  "io.circe"              %% "circe-parser"        % circeVersion,
)
