package com.epam.jmp.jmsexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/JmsMessageListenerTest-context.xml");
		JmsMessageProducer producer = context.getBean(JmsMessageProducer.class);
		producer.generateMessages();
	}

}
