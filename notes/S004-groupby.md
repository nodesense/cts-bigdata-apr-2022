```
M1,U1,2.5
M3,U2,4
M1,U2,3
M3,U3,2
M1,U4,5


Group By movieId

M1 
    U1,2.5
    U2,3
    U4,5

M3
    U2,4
    U3,2

agg(count(userId))

M1    3
M3    2

agg(sum(rating))

M1 10.5
M3 6


agg(avg(rating))

M1 3.5
M3 3

```
