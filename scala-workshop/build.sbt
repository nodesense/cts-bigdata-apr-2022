ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "scala-workshop"
  )



val sparkVersion = "3.1.3"

val hadoopVersion = "2.7.7"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql

libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion

// https://mvnrepository.com/artifact/org.apache.spark/spark-hive

// libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.7" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % hadoopVersion
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % hadoopVersion


dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.8.7"

//libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % hadoopVersion
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.8.7"