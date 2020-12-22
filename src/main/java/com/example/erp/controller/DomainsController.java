package com.example.erp.controller;
import com.example.erp.*;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Domains;
import com.example.erp.service.DomainService;

import com.example.erp.bean.Students;
import com.example.erp.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
@Path("domains")
public class DomainsController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDomain(Domains domain) throws URISyntaxException {
        System.out.println(domain.getBatch());
        System.out.println(domain.getCapacity());
        System.out.println(domain.getDomain_id());
        System.out.println(domain.getProgram());
        System.out.println(domain.getQualification());

        System.out.println("------------------------------inDomainsController------");

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(domain);
        transaction.commit();
        session.close();

        return Response.ok().build();

    }

    @POST
    @Path("/modify")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyDomain(Domains domain) throws URISyntaxException {
        System.out.println("In modify controller api..................");
        System.out.println(domain.getBatch());
        System.out.println(domain.getCapacity());
        System.out.println(domain.getDomain_id());
        System.out.println(domain.getProgram());
        System.out.println(domain.getQualification());

//        jsonList.containsKey("0");
//        lst
//        for(Domains domain:lst)
        DomainService dsObj = new DomainService();
        if(dsObj.modifyDomain(domain)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }


    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomains() {
        DomainService dsObj = new DomainService();
        List<Domains> domains = dsObj.getDomains();
        return Response.ok().entity(domains).build();
    }

    @POST
    @Path("/studentsDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsDetails(Domains domain) throws URISyntaxException {
        DomainService dsObj = new DomainService();
        List<Students> students = dsObj.getStudentsDetails(domain);
        if(students == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(students).build();
    }

}

