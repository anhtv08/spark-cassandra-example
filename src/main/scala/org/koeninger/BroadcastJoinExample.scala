package org.koeninger
import com.datastax.spark.connector._
import org.apache.spark._

/** If you know one side of the join is much smaller, it's efficient to broadcast it */
object BroadcastJoinExample {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("cassandra-example-broadcast-join")

    val sc = new SparkContext(conf)

//    val storeToCity = sc.cassandraTable("test", "stores").
//      select("store", "city").
//      collect
////      .tom
////      .toPairRDDFunctions[String,String]
//      .toMap

//    val cityOf = sc.broadcast(storeToCity)

    val visits = sc.cassandraTable("test", "user_visits")
    val firstRow = visits.first()
    print(firstRow.columnValues)



//    rdd.toArray.foreach(println)

//      select("store", "user")
//      .
//      .toEmptyCassandraRDD


//    val visitsPerCity = visits.map {
//      case (store, user) => (cityOf.value.apply(store), 1)
//    }.reduceByKey(_ + _)

//    val result = visitsPerCity.collect

    sc.stop

//    result.foreach(println)
  }
}
