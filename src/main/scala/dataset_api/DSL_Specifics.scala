package enough.scala.spark
package dataset_api

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.lit

object DSL_Specifics extends SparkSessionWrapper {
  def main(args: Array[String]): Unit = {
    import spark.implicits._

    val data = Seq((1, "a"), (2, "b"), (3, "c"))
    val df: DataFrame = data.toDF("num", "char")

    // Literal
    df.select(lit(1).as("Literal1")).show()

    // Grouping
    df.groupBy("char").count().show()

    // Aggregating
    df.agg(Map("num" -> "max")).show()

    // Joining
    val df2: DataFrame = Seq((1, "a"), (2, "b"), (3, "c")).toDF("num", "char2")
    df.join(df2, "num").show()

    // Sorting
    df.sort($"num".desc).show()

    // Limiting
    df.limit(2).show()

    // Union
    df.union(df).show()

    // Drop duplicates
    df.union(df).dropDuplicates().show()

    // Drop columns
    df.drop("num").show()

    // With column
    df.withColumn("num2", $"num" + 1).show()

    // With column rename
    df.withColumnRenamed("num", "num2").show()

    // Show schema
    df.printSchema()
  }
}
