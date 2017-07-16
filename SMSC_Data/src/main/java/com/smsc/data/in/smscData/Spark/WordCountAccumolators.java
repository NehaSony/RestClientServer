package com.smsc.data.in.smscData.Spark;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import com.smsc.data.in.smscData.SmscDataApplication;

import scala.Tuple2;
@Component
public class WordCountAccumolators implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Map<String,Integer> countMap = new HashMap<String,Integer>();
	
	public Map<String,Integer> countWords() {
		Logger.getLogger("org").setLevel(Level.ERROR);
		Logger.getLogger("aka").setLevel(Level.ERROR);
		System.out.println("start time: "+System.currentTimeMillis());
		SparkSession ss = SmscDataApplication.getSs();
		// Broadcast variable set to 5 so that 5 is add to all the counts
		Broadcast<Integer> broadcastVar = SmscDataApplication.getSc().broadcast(new Integer(5));
		JavaRDD<String> testInput = ss.read().textFile("C:\\Files\\Backup\\FileToTestMapReduce.txt").toJavaRDD();
		JavaRDD<String> mapStage = testInput.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
		JavaPairRDD<String, Integer> mapRedOut = mapStage.mapToPair(p -> new Tuple2<>(p, 1)).reduceByKey((a, b) -> a + b );
//		mapRedOut.collect().forEach(t -> {System.out.println(t._1+ " " + t._2());});
		mapRedOut.foreach(t->countMap.put(t._1,t._2+ broadcastVar.value()));
		System.out.println("end time: "+System.currentTimeMillis());		
		return countMap;
	}
}
