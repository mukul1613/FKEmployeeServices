/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fkemployeeservices;

import data.EmployeeDetailsOperations;
import data.FlipNews;
import data.NotificationsToDos;
import dbentity.EmployeeDetails;
import dbentity.EvaNews;
import dbentity.EvaNotifications;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mukul.kumar
 */
@Path("FKServicesCentral")
public class FKServicesCentralResource {

    @Context
    private UriInfo context;
   // private EmployeeDetailsOperations mEmployeeDetailsOperations;

    /**
     * Creates a new instance of FKServicesCentralResource
     */
    public FKServicesCentralResource() {
    }

    @Path("empdetails")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public EmployeeReturnClass getEmployeeDetails(String email) {
        int flag = 1;
        EmployeeDetailsOperations   mEmployeeDetailsOperations = new EmployeeDetailsOperations(flag);
        mEmployeeDetailsOperations.createEmployeeDetailsDBEntity(email);
        EmployeeDetails tempObj = mEmployeeDetailsOperations.getmEmployeeDetailsDBEntity();
        return new EmployeeReturnClass(tempObj);
    }

    @Path("flipnews")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public FlipNews getFlipNewsData(String email) {
        int flag = 2;
        EmployeeDetailsOperations mEmployeeDetailsOperations = new EmployeeDetailsOperations(flag);
        mEmployeeDetailsOperations.createEvaNewsDBEntity(email);
        EvaNews tempObj = mEmployeeDetailsOperations.getmEvaNewsDBEntity();
        return new FlipNews(tempObj);
    }

    @Path("flipnotification")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public NotificationsToDos getFlipNotifications(String email) {
        int flag = 3;
        EmployeeDetailsOperations mEmployeeDetailsOperations = new EmployeeDetailsOperations(flag);
        mEmployeeDetailsOperations.createEvaNotificationsDBEntity(email);
        EvaNotifications tempObj = mEmployeeDetailsOperations.getmEvaNotificationsDBEntity();
        return new NotificationsToDos(tempObj);
    }

    @Path("/version")
    @GET
    public String getVersion() {
        return "v1.0";
    }
}
