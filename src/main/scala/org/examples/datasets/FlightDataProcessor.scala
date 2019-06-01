package org.examples.datasets
import org.apache.spark.sql.SparkSession

object FlightDataProcessor {

  def main(args: Array[String]): Unit = {
    val sparkSession =  SparkSession.builder()
      .appName("Testing Datasets")
      .master("local[1]")
      .getOrCreate()


    val inflight_data_file = "data/flight-data/csv/2010-summary.csv"
    val flightDS = sparkSession.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(inflight_data_file)

    flightDS.printSchema()
    import sparkSession.implicits._
    val flights = flightDS.as[Flight]

    flights.show(2)
  }
}
