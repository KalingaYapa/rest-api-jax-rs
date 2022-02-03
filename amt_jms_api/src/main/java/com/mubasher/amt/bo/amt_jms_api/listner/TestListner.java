package com.mubasher.amt.bo.amt_jms_api.listner;

import com.mubasher.amt.bo.controllers.UserController;
import com.mubasher.amt.bo.controllers.helpers.UserMessageHelper;
import com.mubasher.amt.bo.user.beans.User;
import com.mubasher.amt.bo.user.implGeneral.UserBean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.Init;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by KalingaY on 1/28/2022.
 */
//@MessageDriven(activationConfig = {
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
//        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/FromKalinga"),
//        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
//        @ActivationConfigProperty(propertyName = "reconnectAttempts", propertyValue = "-1"),
//        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "1"),
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")}, name = "TestListner")
public class TestListner implements MessageListener {


    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println( "TestListner received : "+ textMessage.getText());
            UserMessageHelper userMessageHelper = new UserMessageHelper();

            User user = new UserBean();

            user.setFirstName("kalinga");
            user.setLastName("yapaa");
            user.setAge(40);
            System.out.println("Add User Start in Listner");

            userMessageHelper.addUser(user);

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
