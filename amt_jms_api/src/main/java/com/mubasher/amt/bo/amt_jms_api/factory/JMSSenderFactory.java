package com.mubasher.amt.bo.amt_jms_api.factory;

import com.mubasher.amt.bo.amt_jms_api.implGeneral.JMSSender;

/**
 * Created by KalingaY on 1/27/2022.
 */
public class JMSSenderFactory {
    private static JMSSenderFactory jmsFactory;

    /**
     * Get the instance of the Middleware Sender Factory
     *
     * @return MiddlewareSenderFactory
     * @throws Exception
     */
    public static JMSSenderFactory getInstance() throws Exception {
        if (jmsFactory == null) {
            return createInstance();
        }
        return jmsFactory;
    }

    /**
     * Create Middleware Sender Factory Instance
     *
     * @return MiddlewareSenderFactory
     * @throws Exception
     */
    private static synchronized JMSSenderFactory createInstance() throws Exception {
        if (jmsFactory != null) {
            return jmsFactory;
        }
        jmsFactory = new JMSSenderFactory();

        return jmsFactory;
    }

    /**
     * This gives the message sender implementation for the operation
     * Currently there is one implementation to support JMS
     * There can be more implementations like MQ, HORNETQ, ...
     */
    public JMSSender getMessageSender() {
        return new JMSSender();
    }
}
