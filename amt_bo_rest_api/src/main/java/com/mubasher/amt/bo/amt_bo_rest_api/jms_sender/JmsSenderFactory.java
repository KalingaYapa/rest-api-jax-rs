package com.mubasher.amt.bo.amt_bo_rest_api.jms_sender;

/**
 * Created by KalingaY on 2/3/2022.
 */
public class JmsSenderFactory {
    private static JmsSenderFactory jmsFactory;

    /**
     * Get the instance of the Middleware Sender Factory
     *
     * @return MiddlewareSenderFactory
     * @throws Exception
     */
    public static JmsSenderFactory getInstance() throws Exception {
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
    private static synchronized JmsSenderFactory createInstance() throws Exception {
        if (jmsFactory != null) {
            return jmsFactory;
        }
        jmsFactory = new JmsSenderFactory();

        return jmsFactory;
    }

    /**
     * This gives the message sender implementation for the operation
     * Currently there is one implementation to support JMS
     * There can be more implementations like MQ, HORNETQ, ...
     */
    public JmsSender getMessageSender() {
        return new JmsSender();
    }
}
