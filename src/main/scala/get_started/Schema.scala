package enough.scala.spark
package get_started

import org.apache.spark.sql.types._

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
