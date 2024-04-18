package enough.scala.spark
package get_started

import org.apache.spark.sql.types._

object Schema extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
//  Without Inferring Schema
    var df = spark.read
      .option("header", true)
      .csv("data/raw/AAPL.csv")
    df.printSchema()

//  Inferring Schema
    df = spark.read
      .option("header", true)
      .option("inferSchema", true)
      .csv("data/raw/AAPL.csv")

    df.printSchema()

//  Define Schema
    val schema = StructType(
      Array(
        StructField("Date", DateType, true),
        StructField("Open", DoubleType, true),
        StructField("High", DoubleType, true),
        StructField("Low", DoubleType, true),
        StructField("Close", DoubleType, true),
        StructField("Volume", DoubleType, true)))

    df = spark.read
      .option("header", true)
      .schema(schema)
      .csv("data/raw/AAPL.csv")
    df.printSchema()
  }
}
