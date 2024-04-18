# Dataset API

Dataset is the main abstraction introduced by `Spark SQL`. `Spark SQL` is an abstraction over `Spark` core's RDD.

Dataset is a distributed collection of data organized into named columns. It is conceptually equivalent to a table in a relational database or a data frame in `R`/`Python`, but with richer optimizations under the hood.

The Dataset API defines a Domain-Specific-Language `DSL`, it is declarative and translate into Scala internals.

There are different ways to interact with columns in a Dataset, such as:

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

## Key Points:

- Dataset is a distributed collection of data organized into named columns
-
