package com.mubasher.amt.bo.amt_jms_api.implGeneral;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by KalingaY on 1/27/2022.
 */
public class JMSSender {
    private static final Logger logger = LogManager.getLogger(JMSSender.class);
    private String queueName;

    public void sendMessageToDestination(String messageData) {
        QueueConnection queueConnection;
        QueueSession queueSession;
        MessageProducer producer;
        try {
            this.queueName = "java:jboss/exported/jms/queue/FromKalinga";
            javax.naming.Context context = new InitialContext();
            ConnectionFactory factory = (ConnectionFactory) context.lookup("java:/JmsXA");
            Queue queue = (Queue) context.lookup(queueName);
            queueConnection = (QueueConnection) factory.createConnection();
            queueSession = (QueueSession) queueConnection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            producer = queueSession.createProducer(queue);
            if (producer != null) {
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT); // this is to speed up the message delivery
            }
            queueConnection.start();

            TextMessage txtMessage = queueSession.createTextMessage();
            txtMessage.setText(messageData);
            producer.send(txtMessage);

            Thread.sleep(1000);
            queueSession.close();
            logger.info(" message sent to the destination ");
        } catch (Exception e) {
            logger.error("Exception Occured ", e);
        }
    }
}
