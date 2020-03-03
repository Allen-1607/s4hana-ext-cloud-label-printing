package com.sap.s4hana.sample.print.model;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.bval.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sap.s4hana.sample.validation.ForPrinting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor // for Jackson
@AllArgsConstructor
public class PrintTask {

	public static final String PRINT_CONTENTS_JSON_PROPERTY = "printContents";

	@JsonProperty("numberOfCopies")
	private Integer numberOfCopies;

	@JsonProperty("username")
	private String username;

	@JsonProperty("qname")
	@NotNull @NotEmpty
	private String queueName;
	
	@JsonAlias(PRINT_CONTENTS_JSON_PROPERTY) // this name is used during deserialization
	@Valid @NotNull(groups = ForPrinting.class)
	private PrintContent printContents;
	
	@JsonProperty(PRINT_CONTENTS_JSON_PROPERTY) // this name is used during serialization
	protected List<PrintContent> getPrintContensForJsonSerialization() {
		return Collections.singletonList(printContents);
	}
	
}

