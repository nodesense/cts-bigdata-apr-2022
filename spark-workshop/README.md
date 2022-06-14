# SBT Commands

launch sbt from intellji 

compile  - compile scala code and generate java byte code
package - make a jar file based build.sbt name and version
clean - clear the class files compiled
rebuild - first clear and compile
run - run java main classes, if more than one version found, it will list classname with number


package command - it bundles only scala project class files into jar, package doesnt' buldle
                    dependent files , like spark core, stream, etc, other libraries
                    if we use 3rd party jar, that file won't be bundle in jar
                   someone has to setup those jars in lib/shared jar locations in hadooop/s3 etc

uber jar = Fat Jar, making dependenies part of jar file

https://www.baeldung.com/scala/sbt-fat-jar
create a build plugins.sbt in project folder
add 'addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")'

in sbt, after clean, compile commands, don't do package command which generate light jar
run   assembly command to generate fat jar


Main class not mentioend , but we have 3 main classes
%SPARK_HOME%/bin/spark-submit .\spark-workshop_2.12-0.1.0-SNAPSHOT.jar

Exception in thread "main" org.apache.spark.SparkException: No main class set in JAR; please specify one with --class. 

----


run hello world , where spark is runnning in embedded mode
spark driver and executor all in single JVM
no spark cluster used

click terminal in intellj
type cmd and enter

cd target
cd scala-2.12

%SPARK_HOME%/bin/spark-submit --class workshop.S001_HelloWorld  .\spark-workshop_2.12-0.1.0-SNAPSHOT.j
ar

----

Submit jar  to cluster spark master  spark://192.168.11.67:7077


%SPARK_HOME%/bin/spark-submit --master spark://192.168.11.67:7077 --class workshop.S001_HelloWorld  .\spark-workshopx_2.12-0.2.0-SNAPSHOT.jar
