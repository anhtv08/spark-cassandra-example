#!/bin/bash

SPARK_HOME_DIR=$HOME/working/spark/spark-2.4.3-bin-hadoop2.7
WORKING_DIR=$HOME/working/java/sourcecode/spark-cassandra-example
CONF_FILE=$WORKING_DIR/cassandra-example.conf
MAIN_JOB_CLASS=org.koeninger.HelloWorldExample
JAR_FILE=$WORKING_DIR/target/scala-2.10/cassandra-example-assembly-0.1-SNAPSHOT.jar
APP_NAME="Spark test job"


$SPARK_HOME_DIR/bin/spark-shell \
--conf spark.cassandra.connection.host=localhost \
--packages datastax:spark-cassandra-connector:2.4.1-s_2.11


