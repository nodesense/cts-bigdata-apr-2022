```
1. Extract the zip file 


2. upload data.csv into hadoop /ecommerce/raw directory


3. Refer https://github.com/nodesense/cts-bigdata-apr-2022/blob/main/pyspark-notebooks/S090-Ecommerce.ipynb  for schema, skipping bad quality data, date format

4. Convert the data into parquet format  and store into  hadoop directory  "/ecommerce/clean"


5. DIY: Store the data into partitioned way in hadoop (hint is partitionBy)
            /ecommerce/tree/
                                2010
                                    10
                                        14
                                                data files

6. Find Top 10 customers in decensing order who bought more valuables 
        group by customer id, where sum (Quantity * price) and then apply ranking (rank) in decending order on the sum (Quantity * price) column/result and take top 10 customers (rownumber)

```
