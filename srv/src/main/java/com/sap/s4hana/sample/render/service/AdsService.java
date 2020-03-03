package com.sap.s4hana.sample.render.service;

import javax.ws.rs.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.s4hana.sample.render.model.AdsRenderRequest;
import com.sap.s4hana.sample.render.model.AdsRenderResponse;
import com.sap.s4hana.sample.render.model.GetFormResponse;

/**
 * Feign client for <a href=
 * "https://help.sap.com/viewer/6d3eac5a9e3144a7b43932a1078c7628/Cloud/en-US/3f4f7318d8c941308696512c2125424e.html">SAP
 * Forms by Adobe REST API</a>
 *
 */
@Path("/ads.restapi/v1")
@Consumes("application/json")
public interface AdsService {
	
	public static final String DESTINATION_NAME = "ads-rest-api";
	
	static final Logger log = LoggerFactory.getLogger(AdsService.class);
	
	@GET
	@Path("/forms?select=formData,templateData")
	List<GetFormResponse> getForms();
		
	@POST
	@Path("/adsRender/pdf?templateSource=storageName")
    AdsRenderResponse renderFormFromStorage(AdsRenderRequest adsRenderRequest);
	
}