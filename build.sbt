name := "ItemFilter"
version := "1.0"

scalaVersion := "2.12.6"
scalacOptions ++= Seq(
  "-deprecation", //Emit warning and location for usages of deprecated APIs.
  "-encoding", "UTF-8",
  "-feature", //Emit warning and location for usages of features that should be imported explicitly.
  "-language:implicitConversions", //Explicitly enables the implicit conversions feature
  "-unchecked", //Enable detailed unchecked (erasure) warnings
  "-explaintypes",                     // Explain type errors in more detail.
  "-Xmigration:2.13.0",                // Warn about constructs whose behavior may have changed since version.
  "-Ybackend-parallelism", "12",        // Maximum worker threads for backend
  "-Xfatal-warnings", //Fail the compilation if there are any warnings.
  "-Xlint", //Enable recommended additional warnings.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
  "-Ywarn-unused:imports", // Warn if an import selector is not referenced.
  "-Ywarn-unused:privates", // Warn if a private member is unused.
  "-Ywarn-unused:locals", // Warn if a local definition is unused.
  "-Ywarn-unused:implicits", // Warn if an implicit parameter is unused.
  "-Ywarn-unused:params", // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
  "-Ywarn-value-discard" // Warn when non-Unit expression results are unused.
)

scalafmtOnCompile := true