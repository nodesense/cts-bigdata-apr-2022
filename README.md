## Start Hadoop

Do whenever you restart ubuntu/window system restart/system start

Start hadoop cluster

```
ssh localhost

$HADOOP_HOME/sbin/start-all.sh

jps 
```

ensure jps listing DataNode, NameNode, SecondaryNameNode, ResourceManager running..




## Start Jupyter

```
jupyter lab --no-browser --ip="0.0.0.0"

```

Look for url   starts with ubuntu-virtual-machine, copy and paste into google chrome on windows


# Start Meta Data Server for hive

open terminal 

```
cd $HIVE_HOME 

$HIVE_HOME/bin/hive --service metastore
```


# Run Hive Cli that connects to Meta Data Server on need basic

Open new terminal

```
cd $HIVE_HOME
$HIVE_HOME/bin/hive
```

## Git pull from original branch

```
git add  .
git commit -m "pysprl"
git pull origin main
```

Ctrl + O then Enter to save comments
Ctrl +X to exit nano editor


```
git add  .
git commit -m "get merge"
git push origin main
```
