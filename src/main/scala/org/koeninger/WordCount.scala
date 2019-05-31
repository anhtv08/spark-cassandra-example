package org.koeninger

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def countWords(sc: SparkContext) = {
    // Load our input data
    val input = sc.textFile("data/test.txt")
    // Split it up into words
    val words = input.flatMap(line => line.split(" "))
    // Transform into pairs and count
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile("data/result.txt")
  }

  def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setAppName("wordCount")
      .setMaster("local[1]")

    val sc = new SparkContext(conf)
    countWords(sc)
  }
}
