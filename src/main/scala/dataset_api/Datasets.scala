package enough.scala.spark
package dataset_api

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.DataFrame

object Datasets extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = spark.read
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
