package enough.scala.spark
package get.CreateSparkSession

import get.started.CreateSparkSession

import org.apache.spark.sql.types.{DateType, DoubleType, IntegerType, StructField, StructType}

object Schema {
  def main(args: Array[String]): Unit = {
    val spark = CreateSparkSession.createSparkSession()
    var df = spark.read
      .option("header", true)
      .csv("data/raw/AAPL.csv")
    df.printSchema()

    df = spark.read
      .option("header", true)
      .option("inferSchema", true)
      .csv("data/raw/AAPL.csv")

    df.printSchema()

    val schema = StructType(
      Array(
        StructField("Date", DateType, true),
        StructField("Open", DoubleType, true),
        StructField("High", DoubleType, true),
        StructField("Low", DoubleType, true),
        StructField("Close", DoubleType, true),
        StructField("Volume", IntegerType, true)
      )
    )

    df = spark.read
      .option("header", true)
      .schema(schema)
      .csv("data/raw/AAPL.csv")
    df.printSchema()
  }
}
