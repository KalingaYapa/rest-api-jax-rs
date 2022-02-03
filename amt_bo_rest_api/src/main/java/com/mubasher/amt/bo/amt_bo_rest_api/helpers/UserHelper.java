package com.mubasher.amt.bo.amt_bo_rest_api.helpers;

import com.mubasher.amt.bo.amt_bo_rest_api.beans.User;
import com.mubasher.amt.bo.amt_bo_rest_api.controllers.UserControllerTest;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by KalingaY on 2/3/2022.
 */
public class UserHelper {

    private UserControllerTest userController;
    public UserHelper() {
        try {
            System.out.println("UserHelper Constructor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private UserControllerTest getUserController() throws Exception {
        InitialContext context = new InitialContext();
        try {
            System.out.println("UserHelper initiate start");
            return (UserControllerTest) context.lookup("java:module/UserControllerTest");
        } catch (NamingException e) {
            throw new Exception("Error while getting UserHelper", e);
        }
    }

    public void addUser(User user) throws Exception {
        this.userController = getUserController();
        System.out.println("UserHelper Add user");
        this.userController.addUser(user);
    }
}
