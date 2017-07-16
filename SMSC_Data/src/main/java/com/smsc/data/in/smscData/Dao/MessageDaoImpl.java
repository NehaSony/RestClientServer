package com.smsc.data.in.smscData.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.smsc.data.in.smscData.model.Messages;

@SpringBootApplication
@Component
public class MessageDaoImpl implements MessageDao {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
    public MessageDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	@Override
	public List<Messages> getMessages() {
		List<Messages> messages = mongoTemplate.findAll(Messages.class);
		return messages;
	}

}
