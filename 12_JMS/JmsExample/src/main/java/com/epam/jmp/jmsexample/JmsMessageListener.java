package com.epam.jmp.jmsexample;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener implements MessageListener {

	private static final Logger logger = Logger.getLogger(JmsMessageListener.class);

	@Autowired
	private AtomicInteger counter = null;

	/**
	 * Implementation of <code>MessageListener</code>.
	 */
	public void onMessage(Message message) {
		try {
			int messageCount = message
					.getIntProperty(JmsMessageProducer.MESSAGE_COUNT);

			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();

				logger.info(String.format("Processed message '%s'.  value=%d", msg, messageCount));

				counter.incrementAndGet();
			}
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
