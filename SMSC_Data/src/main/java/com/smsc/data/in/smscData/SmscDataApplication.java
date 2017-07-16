package com.smsc.data.in.smscData;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmscDataApplication {
	
	static SparkSession ss = SparkSession.builder().appName("SmscData").master("local[4]").getOrCreate();
	/**
	 * @return the ss
	 */
	public static SparkSession getSs() {
		return ss;
	}

	/**
	 * @param ss the ss to set
	 */
	public static void setSs(SparkSession ss) {
		SmscDataApplication.ss = ss;
	}

	/**
	 * @return the sc
	 */
	public static JavaSparkContext getSc() {
		return sc;
	}

	/**
	 * @param sc the sc to set
	 */
	public static void setSc(JavaSparkContext sc) {
		SmscDataApplication.sc = sc;
	}

	static JavaSparkContext sc = new JavaSparkContext(ss.sparkContext());

	public static void main(String[] args) {
		SpringApplication.run(SmscDataApplication.class, args);
		
	}
}
