package com.lhh.mq.producer.queue;




import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description  闃熷垪娑堟伅鐢熶骇鑰咃紝鍙戦�娑堟伅鍒伴槦鍒�
 * 
 */
//@Component("queueSender")
public class QueueSender {
	
	//@Autowired
	//@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;//閫氳繃@Qualifier淇グ绗︽潵娉ㄥ叆瀵瑰簲鐨刡ean
	
	/**
	 * 鍙戦�涓�潯娑堟伅鍒版寚瀹氱殑闃熷垪锛堢洰鏍囷級
	 * @param queueName 闃熷垪鍚嶇О
	 * @param message 娑堟伅鍐呭
	 */
	public void send(String queueName,final String message){
			jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
}
