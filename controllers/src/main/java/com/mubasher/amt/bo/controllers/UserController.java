package com.mubasher.amt.bo.controllers;

import com.mubasher.amt.bo.user.beans.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by KalingaY on 1/28/2022.
 */
@Stateless
public class UserController {

    @PersistenceContext(unitName = "bo_db")
    protected EntityManager em;


    public void addUser(User user) {
        System.out.println("user Added &&&&&&&&&&&&&&&&&&&&&&&&&");
        em.persist(user);
    }

}
