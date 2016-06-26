# rolling-window
Simple rolling window implementation in form of command line program.
It requires one argument - path to existing text file with data in expected format. Each line in the file should contain timestamp and value, separated by space or tab. Timestamp is long number of seconds from January, 1st, 1970 00:00:00. Value is represented by floating point number(which is guaranteed to fit into Scala Double data type).

Example:
```
  1355270609 1.80215
  1355270621 1.80185
  .......... .......
```

The program prints its results as a table, where each row contains following information about rolling window:

|  Symbol   |                 description                 |
|:---------:|---------------------------------------------|
|     T     | timestamp at which rolling window ends      |
|     V     | measurement of price ratio at time T.       |
|     N     | number of measurements in the window        |
|     RS    | a rolling sum of measurements in the window |
|    MinV   | minimal values in the window                |
|    MaxV   | maximal values in the window                |

The result looks like:
```
  T          V       N  RS       MaxV    MinV   
  ----------------------------------------------
  1355270609 1.80215 1  1.80215  1.80215 1.80215
  1355270621 1.80185 2  3.604    1.80185 1.80215
  .......... ....... .  .......  ....... .......
```
