package com.smsc.data.in.smscData.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document(collection = "messages")
public class Messages implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2616950106425390780L;
	@Id
	private String id;
	private Address source;
	private Address recipient;
	private MessageData messageData;
	private ApplicationData applicationData;
	private Date createAt;
	private Date expireAt;
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messages(String id, Address source, Address recipient, MessageData messageData,
			ApplicationData applicationData, Date createAt, Date expireAt) {
		super();
		this.id = id;
		this.source = source;
		this.recipient = recipient;
		this.messageData = messageData;
		this.applicationData = applicationData;
		this.createAt = createAt;
		this.expireAt = expireAt;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the source
	 */
	public Address getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Address source) {
		this.source = source;
	}
	/**
	 * @return the recipient
	 */
	public Address getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(Address recipient) {
		this.recipient = recipient;
	}
	/**
	 * @return the messageData
	 */
	public MessageData getMessageData() {
		return messageData;
	}
	/**
	 * @param messageData the messageData to set
	 */
	public void setMessageData(MessageData messageData) {
		this.messageData = messageData;
	}
	/**
	 * @return the applicationData
	 */
	public ApplicationData getApplicationData() {
		return applicationData;
	}
	/**
	 * @param applicationData the applicationData to set
	 */
	public void setApplicationData(ApplicationData applicationData) {
		this.applicationData = applicationData;
	}
	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}
	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	/**
	 * @return the expireAt
	 */
	public Date getExpireAt() {
		return expireAt;
	}
	/**
	 * @param expireAt the expireAt to set
	 */
	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
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
		return "Messages [id=" + id + ", source=" + source + ", recipient=" + recipient + ", messageData=" + messageData
				+ ", applicationData=" + applicationData + ", createAt=" + createAt + ", expireAt=" + expireAt + "]";
	}

}
