from pyspark.conf import SparkConf
import sys
config = SparkConf()

# **** ['/home/ubuntu/workshop/pyspark/movie-lens.py', 'ratings.csv', 'movies.csv', 'result.csv'] 4

# spark-submit --master local movie-lens.py  ratings.csv movies.csv result.csv
#  spark-submit --master local movie-lens.py  hdfs://localhost:9000/ml-latest-small/ratings.csv hdfs://localhost:9000/ml-latest-small/movies.csv hdfs://localhost:9000/most-popular-movies

print ("****", sys.argv, len(sys.argv))

if len(sys.argv) < 4:
    print("exiting spark app, not sufficient args")
    sys.exit(-1)
    

# "hdfs://localhost:9000/ml-latest-small/movies.csv"
# "hdfs://localhost:9000/ml-latest-small/ratings.csv"
# "hdfs://localhost:9000/most-popular-movies"
RATING_PATH = sys.argv[1] # rating csv data

MOVIE_PATH = sys.argv[2] # movie csv data
POPULAR_MOVIE_PATH = sys.argv[3] # output result csv



# config.set("property", "value")
# master must be set in command line arguent, not hardcoded in program
# spark-submit --master local[4]
# config.setMaster("local[4]").setAppName("MovieLens")
config.setAppName("MovieLens")

from pyspark.sql import SparkSession
# spark Session, entry point for Spark SQL, DataFrame
spark = SparkSession.builder\
                    .config(conf=config)\
                    .getOrCreate()

sc = spark.sparkContext

# how to create schema programatically instead of using inferSchema
from pyspark.sql.types import StructType, LongType, StringType, IntegerType, DoubleType
# True is nullable, False is non nullable
movieSchema = StructType()\
                .add("movieId", IntegerType(), True)\
                .add("title", StringType(), True)\
                .add("genres", StringType(), True)

ratingSchema = StructType()\
                .add("userId", IntegerType(), True)\
                .add("movieId", IntegerType(), True)\
                .add("rating", DoubleType(), True)\
                .add("timestamp", LongType(), True)

# read movie data
# read using dataframe with defind schema
# we can use folder path - all csv in the folder read
# use file path, only that file read

# spark is session, entry point for data frame/sql

movieDf = spark.read.format("csv")\
                .option("header", True)\
                .schema(movieSchema)\
                .load(MOVIE_PATH)

movieDf.cache()
movieDf.printSchema()
movieDf.show(2) # action


ratingDf = spark.read.format("csv")\
                .option("header", True)\
                .schema(ratingSchema)\
                .load(RATING_PATH)
ratingDf = ratingDf.repartition(10)
ratingDf.cache()
ratingDf.printSchema()
ratingDf.show(2)

# aggregation with groupBy
from pyspark.sql.functions import col, desc, avg, count

# find  the most popular movies, where as rated by many users, at least movies should be rated by 100 users
# and the average rating should be at least 3.5 and above
# and sort the movies by total_ratings
mostPopularMoviesDf = ratingDf\
     .groupBy("movieId")\
     .agg(avg("rating").alias("avg_rating"), count("userId").alias("total_ratings") )\
     .sort(desc("total_ratings"))\
     .filter( (col("total_ratings") >= 100) & (col("avg_rating") >=3.5) )\

mostPopularMoviesDf.cache() # MEMORY

mostPopularMoviesDf.printSchema()
mostPopularMoviesDf.show(20)

# join, inner join 
# get the movie title for the mostPopularMoviesDf
# join mostPopularMoviesDf with movieDf based on condition that mostPopularMoviesDf.movieId == movieDf.movieId

popularMoviesDf = mostPopularMoviesDf.join(movieDf, mostPopularMoviesDf.movieId == movieDf.movieId)\
                                     .select(movieDf.movieId, "title", "avg_rating", "total_ratings")\
                                     .sort(desc("total_ratings"))

popularMoviesDf.cache()

popularMoviesDf.show(100)


# write popularMoviesDf into single file
# coalesce(1) to reduce partitions
popularMoviesDf.coalesce(1).write.mode("overwrite")\
                .option("header", True)\
                .csv(POPULAR_MOVIE_PATH)