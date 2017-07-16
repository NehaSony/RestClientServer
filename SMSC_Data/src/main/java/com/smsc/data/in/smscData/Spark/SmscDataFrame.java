package com.smsc.data.in.smscData.Spark;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

import com.smsc.data.in.smscData.SmscDataApplication;
import com.smsc.data.in.smscData.model.Messages;

@Component
public class SmscDataFrame implements Serializable{
	
	public List<Messages> doStuff() {
	Logger.getLogger("org").setLevel(Level.ERROR);
	Logger.getLogger("aka").setLevel(Level.ERROR);
	System.out.println("start time: "+System.currentTimeMillis());
	SparkSession ss = SmscDataApplication.getSs();
	
	Encoder<Messages> smscEncoder = Encoders.bean(Messages.class);
	System.out.println("here");
	Dataset<Messages> messageDF = ss.read().json("C:\\Users\\sonyn\\message.json").as(smscEncoder);
	System.out.println("now");
	List<Messages> tmp = (List<Messages>) messageDF.toJavaRDD().collect();
	
	messageDF.show();
	
	return tmp;
	}
}
