package com.mubasher.amt.bo.amt_bo_rest_api.controllers;

import com.mubasher.amt.bo.amt_bo_rest_api.beans.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by KalingaY on 2/3/2022.
 */
@Stateless
public class UserControllerTest {

    @PersistenceContext(unitName = "bo_db")
    protected EntityManager em;


    public void addUser(User user) {
        System.out.println("UserControllerTest ----> User Added ");
        em.persist(user);
    }
}
