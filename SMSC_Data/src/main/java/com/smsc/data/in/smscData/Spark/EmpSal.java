package com.smsc.data.in.smscData.Spark;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.springframework.stereotype.Component;

import com.smsc.data.in.smscData.SmscDataApplication;
import com.smsc.data.in.smscData.model.EmployeeData;
import static org.apache.spark.sql.functions.*;

@Component
public class EmpSal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<EmployeeData> doStuff() {
	Logger.getLogger("org").setLevel(Level.ERROR);
	Logger.getLogger("aka").setLevel(Level.ERROR);
	System.out.println("start time: "+System.currentTimeMillis());
	SparkSession ss = SmscDataApplication.getSs();	
	Encoder<EmployeeData> empEncoder = Encoders.bean(EmployeeData.class);
	Dataset<EmployeeData> empDF = ss.read().json("C:\\Users\\sonyn\\EmpData.json").as(empEncoder);
	List<EmployeeData> tmp = (List<EmployeeData>) empDF.toJavaRDD().collect();
	empDF.show();	
	return tmp;
	}
	
	public List<EmployeeData> nthHigiestSal(int n) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		Logger.getLogger("aka").setLevel(Level.ERROR);
		String test = "a.rn="+n;
		SparkSession ss = SmscDataApplication.getSs();	
		Encoder<EmployeeData> empEncoder = Encoders.bean(EmployeeData.class);
		Broadcast<Integer> brod = SmscDataApplication.getSc().broadcast(new Integer(n));
		Dataset<EmployeeData> empDF = ss.read().json("C:\\Users\\sonyn\\EmpData.json").as(empEncoder);
//		empDF.select(col("userId"),col("team"),col("userName"),col("empSalary")).withColumn("sol", col("empSalary").over(Window.rowsBetween(paramLong1, paramLong2))));
		//select * from (select salary,name,team, dense_rank() over (partition by team order by salary desc)rn from empl)a where a.rn=3;
		empDF.select(col("userId"),col("team"),col("userName"),col("empSalary"),dense_rank().over(Window.partitionBy(col("team")).orderBy(col("empSalary").desc().as("rn"))).as("a")).filter("a.rn=1").show();
//		RelationalGroupedDataset empDFGrouped = empDF.groupBy(col("team"));
//		Dataset<EmployeeData> sortedEmpDF = empDF.sort(desc("empSalary"));
//		Dataset<EmployeeData> result = sortedEmpDF.filter(s -> $"row_num" = brod);
		List<EmployeeData> tmp = (List<EmployeeData>) empDF.toJavaRDD().collect();
		empDF.show();	
		return tmp;
		
	}
}
