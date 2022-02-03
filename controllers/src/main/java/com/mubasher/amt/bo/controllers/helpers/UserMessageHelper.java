package com.mubasher.amt.bo.controllers.helpers;

import com.mubasher.amt.bo.controllers.UserController;
import com.mubasher.amt.bo.user.beans.User;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by KalingaY on 1/29/2022.
 */
public class UserMessageHelper {
    UserController userController;
    public UserMessageHelper () {
        try {
            System.out.println("*********************** UserMessageHelper Constructor *****************************");
          //  userController = getUserController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public UserController getUserController() throws Exception {
        InitialContext context = new InitialContext();
        try {
            System.out.println("User Controller initiate start");
            return (UserController) context.lookup("java:app/controllers-AMTBO.X.2.36.0.SNAPSHOT/UserController");
        } catch (NamingException e) {
            throw new Exception("Error while getting UserController", e);
        }
    }

    public void addUser(User user) throws Exception {
        this.userController = getUserController();
        System.out.println("UserMessageHelper Add user");
        this.userController.addUser(user);
    }
}
