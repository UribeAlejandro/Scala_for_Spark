package enough.scala.spark
package get.started

import org.apache.spark.sql.SparkSession

object CreateSparkSession {
  def createSparkSession(): SparkSession = {
    SparkSession
      .builder()
      .appName("Scala-for-Spark")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()
  }
}
