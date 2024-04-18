package enough.scala.spark

import org.apache.spark.sql.types.{DateType, DoubleType, IntegerType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

object CreateSparkSession {
  def createSparkSession(): SparkSession = {
    SparkSession
      .builder()
      .appName("Scala-for-Spark")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()
  }
  def get_data(): DataFrame = {
    val spark = createSparkSession()
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

    val df = spark.read
      .option("header", true)
      .schema(schema)
      .csv("data/raw/AAPL.csv")
    df
  }
}
