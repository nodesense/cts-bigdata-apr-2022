```

DIY: 1. Create a python avro product called avro-invoice-producer.py
        which sends itemized inovice data to kafka with below fields on topic "invoices"

        invoice_no: random number between 0 to 1000000
        unit_price: random number between 1 t o10
        qty: random number between 1 to 5
        country: random selection from ['usa', 'in', 'uk', 'ca']

     2. use kafka-avro-console-consumer to consume the message and print on console

     3. write a python avro-invoice-consumer.py wich    susbcribe from "invoices" topic and print 
         on console

      4.   Write/deploy a kafka connect sink, that store "invoices" messages into invoices.txt
      
```
