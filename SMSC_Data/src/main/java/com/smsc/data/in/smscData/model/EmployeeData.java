package com.smsc.data.in.smscData.model;

import java.io.Serializable;

public class EmployeeData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String team;
	private String userName;
	private long empSalary;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the empSalary
	 */
	public long getEmpSalary() {
		return empSalary;
	}
	/**
	 * @param empSalary the empSalary to set
	 */
	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}