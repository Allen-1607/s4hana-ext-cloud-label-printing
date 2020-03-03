package com.sap.s4hana.sample.print.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.bval.constraints.NotEmpty;
import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import com.sap.s4hana.sample.print.model.PrintContent;
import com.sap.s4hana.sample.print.model.PrintQueue;
import com.sap.s4hana.sample.print.model.PrintTask;
import com.sap.s4hana.sample.print.model.RenderAndPrintRequest;
import com.sap.s4hana.sample.print.service.PrintService;
import com.sap.s4hana.sample.render.model.AdsRenderResponse;
import com.sap.s4hana.sample.render.service.AdsService;
import com.sap.s4hana.sample.validation.ForPrinting;

import lombok.extern.slf4j.Slf4j;

@Path(PrintController.PATH)
@Slf4j
public class PrintController {

	public static final String PATH = "/PrintQueues";

	@Inject
	private PrintService printService;
	
	@Inject
	private AdsService adsService;

	@GET
    public List<PrintQueue> getPrintQueues() {
		log.info("GET {}", PATH);
		
		return printService.getQueues();
	}
	
	@POST
    public void renderAndPrint(@Valid @NotNull RenderAndPrintRequest body) {
		log.info("POST {} with request {}", PATH, body);
		
		final AdsRenderResponse adsRenderResponse = adsService.renderFormFromStorage(body.getRenderRequest());

		final PrintContent printContent = PrintContent.builder().
				documentContent(adsRenderResponse.getFileContent()).
				documentName(adsRenderResponse.getFileName()).
				documentId(UUID.randomUUID().toString()).
				build();
		
		final PrintTask printTask = body.getPrintTask();
		printTask.setPrintContents(printContent);
		
		printService.print(printContent.getDocumentId(), printTask);
	}
	
	@POST
	@Path("/Multipart")
	public void printFile(
			@Multipart(value = "printTask", type = MediaType.APPLICATION_JSON) 
			@ConvertGroup(from = Default.class, to = ForPrinting.class) @Valid @NotNull 
			PrintTask printTask,
			
			@Multipart(value = "file", type = MediaType.APPLICATION_OCTET_STREAM) 
			@NotNull @NotEmpty 
			byte[] body) throws IOException {
		
		log.info("Print PDF file with settings: {}", printTask);
		
		final PrintContent printContent = printTask.getPrintContents();
		
		final String encodedFile = Base64.encodeBase64String(body);
		printContent.setDocumentContent(encodedFile);
		
		printContent.setDocumentId(UUID.randomUUID().toString());
		printService.print(printContent.getDocumentId(), printTask);
	}
	
}