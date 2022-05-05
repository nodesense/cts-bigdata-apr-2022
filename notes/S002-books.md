```
wget https://raw.githubusercontent.com/mmcky/nyu-econ-370/master/notebooks/data/book-war-and-peace.txt
hdfs dfs -mkdir /books
hdfs dfs -put book-war-and-peace.txt /books
hdfs dfs -ls /books 
```
