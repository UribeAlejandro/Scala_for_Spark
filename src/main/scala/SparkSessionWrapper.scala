package enough.scala.spark
import org.apache.spark.sql.SparkSession

trait SparkSessionWrapper extends Serializable {
  lazy val spark: SparkSession = {
    SparkSession
      .builder()
      .appName("Scala-for-Spark")
      .master("local[*]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()
  }
}
