#!/bin/bash

export HADOOP_HOME=/opt/mapr/hadoop/hadoop-0.20.2
export LD_LIBRARY_PATH=$HADOOP_HOME/lib/native/Linux-amd64-64
export CLASSPATH=$HADOOP_HOME/*:$HADOOP_HOME/lib/* 
export HADOOP_CLASSPATH=$CLASSPATH

javac -d classes IrisMapper.java
javac -d classes IrisReducer.java
jar -cvf Iris.jar -C classes/ .
javac -classpath $CLASSPATH:Iris.jar -d classes IrisDriver.java
jar -uvf Iris.jar -C classes/ .
