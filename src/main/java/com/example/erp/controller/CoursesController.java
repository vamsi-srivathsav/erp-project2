package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.utils.SessionUtil;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("courses")
public class CoursesController {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<String> courses = new ArrayList<>();
        courses.add("Software Systems");
        courses.add("Enterprise Software Development");
        courses.add("Algorithms");
        courses.add("Machine Learning");
        courses.add("Maths for Machine Learning");
        courses.add("Network Communications");
        courses.add("Discrete Mathematics");
        return Response.ok().entity(courses).build();
    }


    @POST
    @Path("/register")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerCourse(@FormDataParam("name") String name,
                                   @FormDataParam("description") String description,
                                   @FormDataParam("credits") Integer credits) throws URISyntaxException {
        System.out.println(name);
        System.out.println(description);
        System.out.println(credits);

        Courses course = new Courses(name, description, credits);

        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(course);

        transaction.commit();
        session.close();

        return Response.ok().build();

    }
}
