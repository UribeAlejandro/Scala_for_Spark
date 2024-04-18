package enough.scala.spark
package get_started

object ReadFiles extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    val df = spark.read
      .option("header", true)
      .csv("data/raw/AAPL.csv")
    df.show()
  }
}
