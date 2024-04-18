package enough.scala.spark
package dataset_api

import CreateSparkSession.get_data

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, SparkSession}

object Datasets {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = CreateSparkSession.createSparkSession()
    val df: DataFrame = spark
      .read
      .option("header", true)
      .option("inferSchema", true)
      .csv("data/raw/AAPL.csv")

    df.select("Date", "Open", "Close").show()

    import spark.implicits._

    val column = df("Close")
    df.select(column, $"Date", col("Open")).show()

//     The following code will throw an error because the column name is not present in the DataFrame.
//    df.select("Close", column, df("Date")).show()
  }
}
