```

recap Spark Stream

1. What is stream? 
        continous flow of data

        Spark Stream 
            continuous flow of data into small discretized batch 

            uses similar execution method of batch once small batches created
            older implementation using rdd 
            newer spark 2.x onwards, using dataframe api, rdd inside
            we can use data frame api 

readStream
    sources 
        kafka
        fileStream
        socket*
        rabbitmq, etc 
        mqtt etc

writeStream
        sinks 
            console 
            kafka

explode - dataframe function

output mode 
    complete
    update

default trigger time is 100 ms 
we can change trigger using trigger api 

Windows
    Thumbling Window
        non overlapping window 
        What is 1 minute/2/3/5 minute /10/15/30/60
        hourly example
        6:00 AM to 7:00 AM [this data not avaiable in 7 to 8 am time] 
        7:00 AM to 8:00 AM [this data not avaiable in 8 to 9 am time] 
        8:00 AM to 9:00 AM

        3000 stocks 
            1 hour window  for each stock - 3000 windows - internal state [min/max/avg etc] 

    Sliding Window
        hopping window , overlapping window 
        overlapping of data, ie the same data may be part of two windows or more windows based on sliding time

        what is hourly average, sliding every 30 minutes 
        6:00 AM to 7:00 AM [the data from 6:30 to 7 AM shall be part current window and  of next window]
        6:30 AM to 7:30 AM [7 to 7:30 data shall be part of this window, then next window]
        7:00 AM to 8:00 AM 


    Session Window
        users activity 
        3oo million users 
            active usrs - 1/10 of total users  
            when user active, create a window until a expiry 30 minutes 
            window will be closed when user is not active 
            personalization
            
    ```
