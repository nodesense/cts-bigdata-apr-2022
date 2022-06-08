
1. Download Java JDK https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u332-b09/OpenJDK8U-jdk_x64_windows_hotspot_8u332b09.msi  while installing select JAVA_HOME
2. Download spark 3.1.2 with hadoop 2.7 from spark website from https://www.apache.org/dyn/closer.lua/spark/spark-3.1.2/spark-3.1.2-bin-hadoop2.7.tgz
3. Download hadoop win utils binaries from https://github.com/steveloughran/winutils
4. Extract both the files usings 7zip/WinRar , for spark, extract the tar file again..
5. Copy spark-3.1.2-bin-hadoop2.7 folder [which is leaf directory, after 2 levels] into c:\
6. You must see bin, sbin,jars under C:\spark-3.1.2-bin-hadoop2.7
7. Copy hadoop-2.7.1 from winutils-master/wintuils-masters to c:\
8. Must have miniconda 3.8 already installed
9. On Windows click on  start menu, type Environment , then open Environment Variable your your account window
10. Now Add New Environment variable for SPARK_HOME  with value C:\spark-3.1.2-bin-hadoop2.7
11. Now Add New Environment variable for HADOOP_HOME with value C:\hadoop-2.7.1 
12. Open miniconda prompt  `pip install findspark`
13. Open miniconda prompt `pip install jupyterlab`
14. Run jupyter on miniconda prompt `jupyter lab`
15. 


# run spark cluster

open command prompt

```
%SPARK_HOME%/bin/spark-class org.apache.spark.deploy.master.Master
```
Now check, http://localhost:8080/ from windows  browser, copy the spark://192.x.y.z ip and use with worker to join the cluster


open command prompt Run Worker 1 copy the master url and paste in below command
```
%SPARK_HOME%/bin/spark-class org.apache.spark.deploy.worker.Worker  spark://192.168.11.67:7077
```
