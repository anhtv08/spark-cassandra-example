package org.koeninger

import org.apache.spark._
import com.datastax.spark.connector._

/** Read from cassandra to make sure things are working.
  * Assumes test.hello table already exists and has data, see cassandra-example.cql
  */
object HelloWorldExample {
  def main(args: Array[String]): Unit = {
    // only setting app name, all other properties will be specified at runtime for flexibility
    val conf = new SparkConf()
      .setAppName("cassandra-example-hello")
      .set("spark.master", "local")



    val sc = new SparkContext(conf)


    val hello = sc.cassandraTable("test","kv")

    val first = hello.first

    sc.stop

    println(first)
  }
}
