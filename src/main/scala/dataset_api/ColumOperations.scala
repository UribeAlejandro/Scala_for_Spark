package enough.scala.spark
package dataset_api

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object ColumOperations extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    // Read the data
    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("data/raw/AAPL.csv")

    // Rename the columns
    // Using .withColumnRenamed
    df.withColumnRenamed("Open", "OpeningPrice")
      .withColumnRenamed("Close", "ClosingPrice")
      .withColumnRenamed("High", "HighPrice")
      .withColumnRenamed("Low", "LowPrice")
      .withColumnRenamed("Volume", "VolumeTraded")
    // There is a cleaner way to rename columns
    val renamedColumns = List(
      col("Date").as("date"),
      col("Open").as("open"),
      col("High").as("high"),
      col("Low").as("low"),
      col("Close").as("close"),
      col("Adj Close").as("adjClose"),
      col("Volume").as("volume"))

    df.select(renamedColumns: _*).show(5)

    // Using Map is a cleaner way to rename columns
    df.select(df.columns.map(c => col(c).as(c.replace(" ", "").toLowerCase())): _*).show(5)

    // Add new columns
    val stockData: DataFrame = df
      .select(renamedColumns: _*)
      .withColumn("diff", col("close") - col("open"))

    stockData.show(5)

    // Filter
    val stockDataFiltered: DataFrame = df
      .select(renamedColumns: _*)
      .withColumn("diff", col("close") - col("open"))
      .filter(col("close") > col("open") * 1.1)

    stockDataFiltered.show(5)
  }

}
