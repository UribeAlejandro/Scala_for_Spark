package enough.scala.spark
package get_started

object ReadFiles {
  def main(args: Array[String]): Unit = {
    val spark = CreateSparkSession.createSparkSession()

    val df = spark.read
      .option("header", true)
      .csv("data/raw/AAPL.csv")
    df.show()

  }
}
