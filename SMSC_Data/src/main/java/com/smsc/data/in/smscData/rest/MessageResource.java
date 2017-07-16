package com.smsc.data.in.smscData.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smsc.data.in.smscData.Dao.MessageDao;
import com.smsc.data.in.smscData.Spark.WordCountJava8;
import com.smsc.data.in.smscData.Spark.EmpSal;
import com.smsc.data.in.smscData.Spark.SmscDataFrame;
import com.smsc.data.in.smscData.Spark.WordCountAccumolators;
import com.smsc.data.in.smscData.Spark.WordCountJava7;
import com.smsc.data.in.smscData.model.EmployeeData;
import com.smsc.data.in.smscData.model.Messages;

@RestController
@RequestMapping("/smsc")

public class MessageResource {
	@Autowired
	private MessageDao msg ;
	@Autowired
	private WordCountJava8 wc;
	@Autowired
	private WordCountJava7 wc7;
	@Autowired
	private WordCountAccumolators wcA;
	@Autowired
	private SmscDataFrame sdf;
	@Autowired
	private EmpSal emp;



	
	@RequestMapping(value = "/messages",method = RequestMethod.GET)
	public List<Messages> getMessages(){
		return msg.getMessages();
		
	}
	
	@RequestMapping(value = "/test")
	public String test(){
	return "Hello";
	}
	
	@RequestMapping(value = "/wordcount8")
	public Map<String, Integer> count(){
		System.out.println("wc.countWords()");
		Map<String, Integer> test = wc.countWords();
		System.out.println(test.size());
	return test;
	}
	
	@RequestMapping(value = "/wordcount7")
	public Map<String, Integer> countWord(){
		System.out.println("wc7.countWords()");
		Map<String, Integer> test = wc7.countWords();
		System.out.println(test.size());
	return test;
	}
	
	@RequestMapping(value = "/wordcountAcc")
	public Map<String, Integer> countWordACC(){
		System.out.println("wcA.countWords()");
		Map<String, Integer> test = wcA.countWords();
		System.out.println(test.size());
	return test;
	}
	
	@RequestMapping(value = "/smscJson")
	public List<Messages> smscJson(){
		System.out.println("sdf.countWords()");
		return sdf.doStuff();
		
	}
	
	@RequestMapping(value = "/emp")
	public List<EmployeeData> emp(){
		System.out.println("empdata");
		return emp.doStuff();
		
	}
	
	@RequestMapping(value = "/emp/{n}")
	public List<EmployeeData> empTest(@PathVariable(value = "n") int n ){
		System.out.println("empdata");
		return emp.nthHigiestSal(n);
		
	}
}
