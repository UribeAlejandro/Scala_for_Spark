# Spark Session

## Create a SparkSession

To start programming with Scala and Spark, instantiate a `SparkSession` object and use it to read data from a file, a database, or any other data source.

```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder()
  .appName("Spark SQL basic example")
  .config("spark.some.config.option", "some-value")
  .getOrCreate()
```
