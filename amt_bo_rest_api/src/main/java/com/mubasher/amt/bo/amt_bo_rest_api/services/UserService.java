package com.mubasher.amt.bo.amt_bo_rest_api.services;

import com.mubasher.amt.bo.amt_bo_rest_api.jms_sender.JmsSender;
import com.mubasher.amt.bo.amt_bo_rest_api.jms_sender.JmsSenderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by KalingaY on 10/12/2021.
 */
@Path("userService")
public class UserService {

    JmsSender jmsSender;
    private String queueName;

    public UserService() {
        try {
            jmsSender = JmsSenderFactory.getInstance().getMessageSender();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Context
    private HttpServletRequest httpServletRequest;

    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(String  text) {
        logger.info("Text Received to the Server : " + httpServletRequest.getRemoteAddr());

        if (text == null) {
            logger.error("REQUEST BODY IS NULL.");
            return Response.status(Response.Status.BAD_REQUEST).entity("").build();
        }

        jmsSender.sendMessageToDestination(text);

        String response = "Successfully send message to the destination";

        logger.info(response);

        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }

}
