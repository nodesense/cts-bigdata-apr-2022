from confluent_kafka.avro import AvroConsumer
from confluent_kafka.avro.serializer import SerializerError



# open t erminal
# cd workshop
# cd kafka
# python avro-consumer.py

c = AvroConsumer({
    'bootstrap.servers': 'localhost:9092',
    'group.id': 'groupid',
     'auto.offset.reset': 'earliest',
    'schema.registry.url': 'http://127.0.0.1:8081'})

c.subscribe(['avro-topic'])

while True:
    try:
        msg = c.poll(10)

    except SerializerError as e:
        print("Message deserialization failed for {}: {}".format(msg, e))
        break

    if msg is None:
        continue

    if msg.error():
        print("AvroConsumer error: {}".format(msg.error()))
        continue

    print(msg.value())
    print (msg.key())

c.close()