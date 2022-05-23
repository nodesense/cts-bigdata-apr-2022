```
DIY

create table brands with 
   id 
   name 
   create_ts
   update_ts same like products minus price column 

   under ecommerce db

create a kafka connector that reads brands table and export teh brands table data as kafka records 

in kafka topic db_brands , based on update_ts 

use kafka-avro-console-consumer to display teh brands data..

insert 2 brands and see in consumer, update 1 brands and validate in consumer

```
