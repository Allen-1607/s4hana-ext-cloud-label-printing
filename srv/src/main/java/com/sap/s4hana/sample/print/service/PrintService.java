package com.sap.s4hana.sample.print.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sap.s4hana.sample.print.model.PrintQueue;
import com.sap.s4hana.sample.print.model.PrintTask;

/**
 * Feign client
 *
 */
@Path("/api/v1/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PrintService  {

    /**
     * Get print queue list.
     *
     */
    @GET
    @Path("/printQueues")
    public List<PrintQueue> getQueues();

	/**
	 * Create print task.
	 * 
	 * @param itemId a valid GUID.
	 * 
	 */
    @PUT
    @Path("/printTask/{itemId}")
    public void print(@PathParam("itemId") String itemId, /* body */ PrintTask printTask);
}

