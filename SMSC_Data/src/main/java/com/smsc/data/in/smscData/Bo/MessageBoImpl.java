package com.smsc.data.in.smscData.Bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smsc.data.in.smscData.model.Messages;
import com.smsc.data.in.smscData.service.MessageService;

public class MessageBoImpl implements MessageBo {
	
	@Autowired
	private MessageService msg;
	
	@Override
	public List<Messages> getMessages() {
		return msg.getMessages();
	}

}
