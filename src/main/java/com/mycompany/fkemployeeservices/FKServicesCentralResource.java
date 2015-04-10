/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fkemployeeservices;

import data.EmployeeDetailsOperations;
import data.FlipNews;
import dbentity.EvaEmpDetails;
import javafx.scene.media.Media;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    private EmployeeDetailsOperations mEmployeeDetailsOperations;
    /**
     * Creates a new instance of FKServicesCentralResource
     */
    public FKServicesCentralResource() {
    }
   
    @Path("empdetails")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public EvaEmpDetails getEmployeeDetails(){
      mEmployeeDetailsOperations =  new EmployeeDetailsOperations();//.createmEvaEmpDetailsDBEntity();
      mEmployeeDetailsOperations.createmEvaEmpDetailsDBEntity();
      return mEmployeeDetailsOperations.getmEvaEmpDetailsDBEntity();
    }    
    
}