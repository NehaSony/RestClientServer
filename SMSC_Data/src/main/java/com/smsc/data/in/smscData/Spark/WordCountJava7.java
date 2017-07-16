package com.smsc.data.in.smscData.Spark;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import com.smsc.data.in.smscData.SmscDataApplication;

import scala.Tuple2;
@Component
public class WordCountJava7 implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static Map<String,Integer> countMap = new HashMap<String,Integer>();
	
	public Map<String,Integer> countWords() {
		Logger.getLogger("org").setLevel(Level.ERROR);
		Logger.getLogger("aka").setLevel(Level.ERROR);
		System.out.println("start time: "+System.currentTimeMillis());
		SparkSession ss = SmscDataApplication.getSs();
		JavaRDD<String> lines = ss.read().textFile("C:\\Files\\Backup\\FileToTestMapReduce.txt").toJavaRDD();
		JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public Iterator<String> call(String s) throws Exception {
				String[] cell = s.split(" ");
				return Arrays.asList(cell).iterator();
			}
		});
		JavaPairRDD<String, Integer> pair = words.mapToPair(new PairFunction<String, String, Integer>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Integer> call(String s) throws Exception {
				return new Tuple2<String, Integer>(s, 1);
			}
		});
		
		JavaPairRDD<String, Integer> wordsCounts = pair.reduceByKey(new Function2<Integer, Integer, Integer>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Integer call(Integer a, Integer b) throws Exception {
				return a+b;
			}
		});
		
		wordsCounts.foreach(t->countMap.put(t._1,t._2));
		 
		return countMap;

	}

}
