from confluent_kafka import avro
from confluent_kafka.avro import AvroProducer

# pip install avro

# open terminal
# cd workshop
# cd kafka
# python avro-producer.py

# check in browser http://ubuntu-virtual-machine:8081/subjects

value_schema_str = """
{
   "namespace": "my.test",
   "name": "value",
   "type": "record",
   "fields" : [
     {
       "name" : "name",
       "type" : "string"
     }
   ]
}
"""

key_schema_str = """
{
   "namespace": "my.test",
   "name": "key",
   "type": "record",
   "fields" : [
     {
       "name" : "name",
       "type" : "string"
     }
   ]
}
"""

# load schema into memory
value_schema = avro.loads(value_schema_str)
key_schema = avro.loads(key_schema_str)
# key and value data
value = {"name": "Tesla"}
key = {"name": "TSLA"}


def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

# at very first producer shalll upload schema to schema registry

avroProducer = AvroProducer({
    'bootstrap.servers': 'localhost:9092',
    'on_delivery': delivery_report,
    'schema.registry.url': 'http://localhost:8081'
    }, default_key_schema=key_schema, 
        default_value_schema=value_schema)
# both key and value shall be serialized inot avro format and 
# send to kafka
avroProducer.produce(topic='avro-topic', value=value, key=key)
avroProducer.flush()