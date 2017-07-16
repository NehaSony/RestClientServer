package com.smsc.data.in.smscData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smsc.data.in.smscData.Dao.MessageDao;
import com.smsc.data.in.smscData.model.Messages;

public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao msg;
	
	@Override
	public List<Messages> getMessages() {
		return msg.getMessages();
	}

}
