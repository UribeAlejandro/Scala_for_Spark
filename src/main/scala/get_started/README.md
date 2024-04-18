# Get Started

## Read Data

To [read a csv](https://spark.apache.org/docs/latest/sql-data-sources-csv.html) file, use the `read` method of the `SparkSession` object. The `read` method returns a `DataFrameReader` object, which you can use to read data from a file.

```scala
val df = spark.read.csv("path/to/file.csv")
```

To display the data in a `DataFrame`, use the `show` method.

```scala
df.show()
```

## Schema

To print the schema of a `DataFrame`, use the `printSchema` method.

```scala
df.printSchema()
```
The output will be:
```bash
root
 |-- Date: string (nullable = true)
 |-- Open: string (nullable = true)
 |-- High: string (nullable = true)
 |-- Low: string (nullable = true)
 |-- Close: string (nullable = true)
 |-- Adj Close: string (nullable = true)
 |-- Volume: string (nullable = true)
```

The schema does not look right. If no schema was specified when reading a csv file, Spark uses string types for all columns.

Spark can infer the schema of a csv file. To infer the schema, use the `inferSchema` method of the `DataFrameReader` object.

```scala
val df = spark.read.option("header", "true").option("inferSchema", "true").csv("path/to/file.csv")
```

Then print the schema.

```scala
df.printSchema()
```

The output will be:
```bash
root
 |-- Date: date (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Adj Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
```

To specify a schema, use the `schema` method of the `DataFrameReader` object. The data types can be found in the [Data Types Documentation](https://spark.apache.org/docs/latest/sql-ref-datatypes.html).


```scala
import org.apache.spark.sql.types._

val schema = StructType(
  Array(
    StructField("Date", DateType, true),
    StructField("Open", DoubleType, true),
    etc.
  )
)
```

To read a csv file with a specified schema, use the `schema` method of the `DataFrameReader` object.

```scala
val df = spark.read.schema(schema).csv("path/to/file.csv")
```
