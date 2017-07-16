package com.smsc.data.in.smscData.model;

import java.io.Serializable;

import javax.persistence.Entity;


public class Address implements Serializable {
	
	public Address(){}

	public Address(String technology, String addr, Boolean onGoingPresenceRequest, String presence, String mode) {
		super();
		this.technology = technology;
		this.addr = addr;
		this.onGoingPresenceRequest = onGoingPresenceRequest;
		this.presence = presence;
		this.mode = mode;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8300410833003405812L;
	
	private String technology;
	private String addr;
	private Boolean onGoingPresenceRequest;
	private String presence;
	private String mode;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [technology=" + technology + ", addr=" + addr + ", onGoingPresenceRequest="
				+ onGoingPresenceRequest + ", presence=" + presence + ", mode=" + mode + "]";
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the onGoingPresenceRequest
	 */
	public Boolean getOnGoingPresenceRequest() {
		return onGoingPresenceRequest;
	}
	/**
	 * @param onGoingPresenceRequest the onGoingPresenceRequest to set
	 */
	public void setOnGoingPresenceRequest(Boolean onGoingPresenceRequest) {
		this.onGoingPresenceRequest = onGoingPresenceRequest;
	}
	/**
	 * @return the presence
	 */
	public String getPresence() {
		return presence;
	}
	/**
	 * @param presence the presence to set
	 */
	public void setPresence(String presence) {
		this.presence = presence;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
