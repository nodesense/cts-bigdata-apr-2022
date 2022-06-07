
1. Download spark 3.1.2 with hadoop 2.7 from spark website from https://www.apache.org/dyn/closer.lua/spark/spark-3.1.2/spark-3.1.2-bin-hadoop2.7.tgz
2. Download hadoop win utils binaries from https://github.com/steveloughran/winutils
3. Extract both the files usings 7zip/WinRar , for spark, extract the tar file again..
4. Copy spark-3.1.2-bin-hadoop2.7 folder [which is leaf directory, after 2 levels] into c:\
5. You must see bin, sbin,jars under C:\spark-3.1.2-bin-hadoop2.7
6. Copy hadoop-2.7.1 from winutils-master/wintuils-masters to c:\
7. Must have miniconda 3.8 already installed
8. On Windows click on  start menu, type Environment , then open Environment Variable your your account window
9. Now Add New Environment variable for SPARK_HOME  with value C:\spark-3.1.2-bin-hadoop2.7
10. Now Add New Environment variable for HADOOP_HOME with value C:\hadoop-2.7.1 
11. Open miniconda prompt  `pip install findspark`
12. Open miniconda prompt `pip install jupyterlab`
13. Run jupyter on miniconda prompt `jupyter lab`
14. 
