package com.englishtown.vertx.jersey.examples.resources;

import com.englishtown.vertx.jersey.examples.ITest;
import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: adriangonzalez
 * Date: 4/9/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("test")
public class TestResource {

    @POST
    public String doPost(ITest test) {
        return test.get();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getString(@Context ContainerRequest context) {
        return "Hello World!!! " + context.getProperty("custom.property");
    }

}