## Setup kafka on Ubuntu 

We are installing Confluent Enterprise Kafka 5.5.5 version

open terminal 

```
wget http://packages.confluent.io/archive/5.5/confluent-5.5.5-2.12.tar.gz
tar xf confluent-5.5.5-2.12.tar.gz

sudo mv confluent-5.5.5 /opt

sudo chmod 777 /opt/confluent-5.5.5
```


## MySQL JDBC Driver for MySQL connect 

```
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.47.tar.gz

tar xf mysql-connector-java-5.1.47.tar.gz
cp mysql-connector-java-5.1.47/*.jar /opt/confluent-5.5.5/share/java/kafka-connect-jdbc
```

## setup bash profile

```
echo "export KAFKA_HOME=/opt/confluent-5.5.5" >> ~/.bashrc
echo "export PATH=\$PATH:\$KAFKA_HOME/bin" >>  ~/.bashrc
```

close the terminal

Open new Terminal

## Check confluent command

```
confluent local status

confluent local current
```
