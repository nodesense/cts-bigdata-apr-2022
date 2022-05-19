```
create a topic called logs with 4 partitions, 
and publish the messages with with value pair use hyphen ("-") as delimiter

publish like example shown below

IN-34
USA-56


try to run kafka consumer that susbcribe from all partitions, print key value

try to run kafka consumer that susbcribe from partition 0, print key and value, timestamp [google it]

try to run kafka consumer that susbcribe from  partition 1, print key value, offset 2 onwards


```

```
create topic messages if not created already

run a console producer, that produce to messages topic with key:value pair

and write a consumer python program that consume messages from messages topic,

  print the value from msg
  print the key from msg
  print the timestamp from msg
  print the offset from msg
  print the partition from msg
  
google for confluent-kafka for the api, how to read value, key, timestamp, offset, partition from consumer

```
