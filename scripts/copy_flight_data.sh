#!/usr/bin/env bash

source_data_dir=$HOME/working/java/sourcecode/Spark-The-Definitive-Guide/data/flight-data/csv
des_data_dir=$HOME/working/java/sourcecode/spark-cassandra-example/data/flight-data/csv
cp -R $source_data_dir/* $des_data_dir/

