package enough.scala.spark
package dataset_api

import org.apache.spark.sql.DataFrame

object DatasetsOperations extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = spark.read
      .option("header", true)
      .option("inferSchema", true)
      .csv("data/raw/AAPL.csv")

    val column = df("Open")
    val columnPlusTwo = column + 2.0
    val columnString = column.cast("String").as("OpenString")

    df.select(column, columnPlusTwo, columnString)
      .filter(column < columnPlusTwo)
      .filter(columnPlusTwo > 2.0)
      .filter(columnPlusTwo === column)
      .show()
  }
}
