package enough.scala.spark
package dataset_api

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{expr, current_timestamp}

object SQL_Expressions extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("data/raw/AAPL.csv")

    // SQL Expressions
    val currTsFunc = current_timestamp()
    val currTsExpr = expr("current_timestamp()")

    df.select(
      currTsFunc.as("CurrentTimestampFunction"),
      currTsExpr.as("CurrentTimestampExpression"))
      .show(5)

    // SQL Expressions are evaluated in compile time, hence the following will fail
//    val invalidExpr = expr("current_timestamp)")
//    df.select(invalidExpr).show()

    df.selectExpr(
      "" +
        "current_timestamp() as CurrentTimestamp",
      "Open + 1.0")
      .show(5)

    // Register a temporary view
    df.createOrReplaceTempView("df")
    // SQL Query -- This is not recommended, Scala API is preferred due to type safety, compile time checks
    spark.sql("SELECT * FROM df").show(5)
  }
}
