#!/bin/bash

export HADOOP_HOME=/opt/mapr/hadoop/hadoop-0.20.2
export LD_LIBRARY_PATH=$HADOOP_HOME/lib/native/Linux-amd64-64
export CLASSPATH=$HADOOP_HOME/lib/*:$HADOOP_HOME/*
export HADOOP_CLASSPATH=$CLASSPATH

rm -rf /user/$USER/IRIS_LAB/OUT
hadoop jar Iris.jar Iris.IrisDriver /user/$USER/IRIS_LAB/DATA/iris-data.txt /user/$USER/IRIS_LAB/OUT 
