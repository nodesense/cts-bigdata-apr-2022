```
Partitions 
    Subset of data
    shall be available in executors
    Created while creating rdd, parallelize, textFile, etc 
    how to increase partitions - repartition
    how to reduce partition - coalsece

Action 
    Execution of RDD
    RDD is lazy evaluation 
    Every action create a JOB
    Every job, 
            Convert RDD into DAG
            DAG shall be converted into STAGE(s)
            DAG Scheduler that execute each Stage(s)
                Each stage, 
                    Shall have tasks, task queue 
                    Task Schduler that exeucte task at executors
                at end of the stage, the data may be suffled/exchange between systems
                Next stage shall start..
Stage
    What is stage? 

Task
    What is task?
        small set code, lambda in filter, map, flatmap, groupby, sort, etc
        writeToTextFile
        union, distinct, intersect
    how task is created?
        task is created per partitions
    Task shall have queue
    task is executed at executor
    where task is created/who create task?  Driver creates task/Spark Context
    Where is task queue created/located? Driver/Spark Context

Parallelism local, local[4] local[*]
    local - embedded mode
    local[n] - where n represent number of parallel tasks can be exeucuted at anytime

Exeuctor
    Shall have threads, micro context that can run independent or concurrent [lock]
    local[4] - exeuctors shall have 4 threads which can run independent [parallelism]
             - 4 tasks can running at any point of time

    local - 1 thread 
             - 1 task at a time 
    local[*] - based on number of vcores in system
                if system has 4 cores, then 4 threads, 4 tasks at same time
                 if system has 16 cores, then 16 threads, 16 tasks at same time

Task shall have queue - 100 tasks in queue

    local[4] - which can execute 4 tasks at a time, each task shall take 100 ms

    how much time it will take complete all 100 tasks
     1 task at a time =>   100 * 100 ms = 10000 ms  = 10 sec
     4 tasks at a time => 2.5 sec


```
