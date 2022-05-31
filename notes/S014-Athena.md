Data scanned with 100 k movie lengs data -- 2.84 MB

```sql


SELECT ratings.movieid, title, avg(rating) as avg_rating, 
                count(rating) as total_ratings 
FROM "gks_db"."raw_ratings" ratings
INNER JOIN  "gks_db"."raw_movies" movies ON ratings.movieid = movies.movieid
GROUP BY ratings.movieid, title
HAVING  avg(rating) >= 3.5 AND count(rating) >= 100

```

CTAS

```sql

CREATE TABLE "gks_db"."raw_popular_movies" AS 
SELECT ratings.movieid, title, avg(rating) as avg_rating, 
                count(rating) as total_ratings 
FROM "gks_db"."raw_ratings" ratings
INNER JOIN  "gks_db"."raw_movies" movies ON ratings.movieid = movies.movieid
GROUP BY ratings.movieid, title
HAVING  avg(rating) >= 3.5 AND count(rating) >= 100
 
 
```

```sql

DESC FORMATTED  `raw_popular_movies`;

SELECT * FROM "gks_db"."raw_popular_movies";
```

