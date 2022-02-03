package com.mubasher.amt.bo.amt_bo_rest_api.jms_listner;

import com.mubasher.amt.bo.amt_bo_rest_api.beans.User;
import com.mubasher.amt.bo.amt_bo_rest_api.beans.UserBean;
import com.mubasher.amt.bo.amt_bo_rest_api.helpers.UserHelper;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by KalingaY on 1/28/2022.
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/FromKalinga"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "-1"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")}, name = "JmsListner")
public class JmsListner implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println( "JmsListner received : "+ textMessage.getText());
            UserHelper userMessageHelper = new UserHelper();

            User user = new UserBean();

            user.setFirstName("kalinga");
            user.setLastName("yapaa");
            user.setAge(40);
            System.out.println("Add User Start in Listner");
            System.out.println( "JmsListner received : "+ textMessage.getText());
            userMessageHelper.addUser(user);

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
