package com.example.erp.controller;
import com.example.erp.*;
import com.example.erp.bean.Grades;
import com.example.erp.bean.Domains;
import com.example.erp.service.DomainService;
import com.example.erp.service.GradeService;

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

@Path("grades")

public class GradesController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(Grades grade) throws URISyntaxException {
//        System.out.println(domain.getBatch());
//        System.out.println(domain.getCapacity());
//        System.out.println(domain.getDomain_id());
//        System.out.println(domain.getProgram());
//        System.out.println(domain.getQualification());

//        System.out.println("------------------------------inGradesController------");

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(grade);
        transaction.commit();
        session.close();

        return Response.ok().build();

    }


    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteGrade(Grades grade) throws URISyntaxException {

        System.out.println("------------------------------inDeleteGradesController------");

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
//        session.delete(grade);

        Object persistentInstance = session.load(Grades.class, grade.getGrade_id());
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }

        transaction.commit();
        session.close();

        return Response.ok().build();

    }





    @GET
    @Path("/getAllGrades")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGrades() {
        GradeService gsObj = new GradeService();
        List<Grades> grades = gsObj.getAllGrades();
        return Response.ok().entity(grades).build();
    }
    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGrade(Grades grade) throws URISyntaxException {
//        System.out.println("In modify controller api..................");
//        System.out.println(domain.getBatch());
//        System.out.println(domain.getCapacity());
//        System.out.println(domain.getDomain_id());
//        System.out.println(domain.getProgram());
//        System.out.println(domain.getQualification());

//        jsonList.containsKey("0");
//        lst
//        for(Domains domain:lst)
        GradeService gsObj = new GradeService();
        if(gsObj.updateGrade(grade)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }



//    @POST
//    @Path("/getDetails")
//    @Produces(MediaType.TEXT_PLAIN)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addDomain(Grades grade) throws URISyntaxException {
//
//        System.out.println("------------------------------inGradesController------");
//
//        Session session = SessionUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(grade);
//        transaction.commit();
//        session.close();
//
//        return Response.ok().build();
//
//    }
}
