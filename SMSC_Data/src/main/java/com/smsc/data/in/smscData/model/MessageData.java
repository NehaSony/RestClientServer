package com.smsc.data.in.smscData.model;

import java.io.Serializable;
import java.util.Date;

public class MessageData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8497326553099109972L;
	private Integer dcs;
	private String mimeType;
	private Date startDate;
	private String recieptRequest;
	private String deliveryStatus;
	private String opaqueData;
	public MessageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageData(Integer dcs, String mimeType, Date startDate, String recieptRequest, String deliveryStatus,
			String opaqueData) {
		super();
		this.dcs = dcs;
		this.mimeType = mimeType;
		this.startDate = startDate;
		this.recieptRequest = recieptRequest;
		this.deliveryStatus = deliveryStatus;
		this.opaqueData = opaqueData;
	}
	/**
	 * @return the dcs
	 */
	public Integer getDcs() {
		return dcs;
	}
	/**
	 * @param dcs the dcs to set
	 */
	public void setDcs(Integer dcs) {
		this.dcs = dcs;
	}
	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the recieptRequest
	 */
	public String getRecieptRequest() {
		return recieptRequest;
	}
	/**
	 * @param recieptRequest the recieptRequest to set
	 */
	public void setRecieptRequest(String recieptRequest) {
		this.recieptRequest = recieptRequest;
	}
	/**
	 * @return the deliveryStatus
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	/**
	 * @param deliveryStatus the deliveryStatus to set
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	/**
	 * @return the opaqueData
	 */
	public String getOpaqueData() {
		return opaqueData;
	}
	/**
	 * @param opaqueData the opaqueData to set
	 */
	public void setOpaqueData(String opaqueData) {
		this.opaqueData = opaqueData;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageData [dcs=" + dcs + ", mimeType=" + mimeType + ", startDate=" + startDate + ", recieptRequest="
				+ recieptRequest + ", deliveryStatus=" + deliveryStatus + ", opaqueData=" + opaqueData + ", getDcs()="
				+ getDcs() + ", getMimeType()=" + getMimeType() + ", getStartDate()=" + getStartDate()
				+ ", getRecieptRequest()=" + getRecieptRequest() + ", getDeliveryStatus()=" + getDeliveryStatus()
				+ ", getOpaqueData()=" + getOpaqueData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
