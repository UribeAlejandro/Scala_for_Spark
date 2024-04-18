# Dataset API

## RDD vs Dataframe vs Dataset

- RDD is a distributed collection of data elements that can be operated on in parallel.
- Dataframe is a distributed collection of data organized into named columns. Also, DataFrame is a special case of Dataset.
- Dataset is a distributed collection of data organized into named columns. It is conceptually equivalent to a table in a relational database or a data frame in `R`/`Python`, but with richer optimizations under the hood.

So, [when to use them?](https://algoscale.com/blog/apache-spark-rdd-vs-dataframe/#:~:text=In%20Spark%20development%2C%20RDD%20refers,like%20a%20relational%20database%20table.)

## Dataset API

Dataset is the main abstraction introduced by `Spark SQL`. `Spark SQL` is an abstraction over `Spark` core's RDD.

Dataset is a distributed collection of data organized into named columns. It is conceptually equivalent to a table in a relational database or a data frame in `R`/`Python`, but with richer optimizations under the hood.

The Dataset API defines a Domain-Specific-Language `DSL`, it is declarative and translate into Scala internals. There are different ways to interact with columns in a Dataset, such as:

```scala
col("Date")
$"Date"
df("Date")
val column = df.col("Date")
```

The `select` method is used to select columns from a Dataset.

```scala
df.select("Date", "Open")
```

The references to columns can be mixed when using select method, for example:

```scala
df.select($"Date", $"Open")
df.select(col("Date"), $"Open")
df.select(col("Date"), col("Open"))
```
The following case will throw an error:

```scala
df.select("Date", col("Open"))
```

To compare columns, use the `===` operator:

```scala
df.select($"Date", $"Open").filter(column === otherColumn)
```

## Spark SQL

To enable `Spark SQL`, the dataframe might be registered as a temporary table:

```scala
df.createOrReplaceTempView("df")
```

Then, the `sql` method can be used to run SQL queries:

```scala
spark.sql("SELECT Date, Open FROM df")
```

> Note: This is not recommended, as it is not type-safe. If there is any typo in the expression or column name, it will not be caught by the IDE/compile time and will be evaluated at runtime.

## Key Points:

- Dataset is a distributed collection of data organized into named columns
- Columns do not have to be bound to a specific Dataset

## Links:

- [SQL Functions](https://spark.apache.org/docs/latest/sql-ref-functions.html)
