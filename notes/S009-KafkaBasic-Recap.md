```
data pipeline - data move
broker - store data, cluster, producer, consumer
producer - write data/message/bye array for key/value to broker
          decides partitions
              hash(key) % num partitions
              if key is null, round robin
message
          key - bytes
          value - bytes
          offset 
          parittions
          timestamp
          magic byte
          meta data, key/value
consumer
          read messages
          pull architecture
          consumer offset - to know what offset it read earlier, per partitions
zookeeper
          meta data like topic, broker list, broker heart beat
topics
          logical representation/way of grouping messages,
            created by developers, 
            automatically created by broker if topic not created earlier
partition shunk/subset of data, created per topic, each topic has its own partitions
          messages in partitions cannot be deleted, updated by user
          when messages deleted, when rentention period expires
          messages always appended
          messages stored in log file
          semantic partitions 
                   partition data based on country code, product cateogoty ,range , customer type 

consumer group
         group of consumers
         load balancer/scale out consumers
         consumer group maintain consumer offset

kafka clusters
        more than 1 brokers form clusters
        scale up the broker throughput,
        split partitiosn amoung brokers
        lead broker - per partition, responsible for read/write, 
        any broker can be lead for any partitions
        for any partitions, there will be one lead broker, and many followers who are replicas

        load balancing

```
