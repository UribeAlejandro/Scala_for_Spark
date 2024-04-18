package enough.scala.spark
package dataset_api

import CreateSparkSession.get_data

import org.apache.spark.sql.DataFrame

object DatasetsOperations {
def main(args: Array[String]): Unit = {
    val df: DataFrame = get_data()
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
