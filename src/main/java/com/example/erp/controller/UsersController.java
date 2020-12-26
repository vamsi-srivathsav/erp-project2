package com.example.erp.controller;
import com.example.erp.bean.Students;
import com.example.erp.bean.Users;
import com.example.erp.service.UserService;


import com.example.erp.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

import com.example.erp.*;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
@Path("users")

public class UsersController {
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(Users user) throws URISyntaxException {

        UserService usObj = new UserService();
        Users result = usObj.verifyUserName(user);
        System.out.println("in usersController------------------==");
        System.out.println(result.getUser_name());
        System.out.println(result);
        if(result == null){
            System.out.println("IN NULLLLL");
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();

    }
}

