#!/bin/bash

SPARK_HOME_DIR=$HOME/working/spark/spark-2.4.3-bin-hadoop2.7
WORKING_DIR=$HOME/working/java/sourcecode/spark-cassandra-example
CONF_FILE=$WORKING_DIR/cassandra-example.conf
MAIN_JOB_CLASS=org.examples.datasets.FlightDataProcessor
JAR_FILE=$WORKING_DIR/target/spark-cassandra-samples-1.0-SNAPSHOT.jar
APP_NAME="Spark test job"
MASTER_URL="spark://anhs-MBP:7077"
DEPLOY_MODE=cluster

# copy driver program to spark jars

cp $JAR_FILE $SPARK_HOME_DIR/jars/

$SPARK_HOME_DIR/bin/spark-submit \
--properties-file $CONF_FILE \
--class $MAIN_JOB_CLASS \
--name $APP_NAME \
--master $MASTER_URL \
--deploy-mode $DEPLOY_MODE \
--jars $JAR_FILE --verbose \
--files $JAR_FILE


ret_code=$?

echo "job completed with return code : $ret_code"


