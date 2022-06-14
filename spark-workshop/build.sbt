ThisBuild / version := "0.3.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.12"

lazy val root = (project in file("."))
  .settings(
    name := "spark-workshopx"
  )

val sparkVersion = "3.1.2"
val hadoopVersion = "2.7.7"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion  % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion  % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-hive
// libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.7" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion  % "provided"

// https://mvnrepository.com/artifact/org.postgresql/postgresql
libraryDependencies += "org.postgresql" % "postgresql" % "42.3.6"
