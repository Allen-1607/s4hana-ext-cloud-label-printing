package com.sap.s4hana.sample.print.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // for Jackson
public class PrintQueue {

	@JsonProperty("qname")
	private String name;

	@JsonProperty("qdescription")
	private String description;

	@JsonProperty("qstatus")
	private String status;

	@JsonProperty("qformat")
	private String format;

	@JsonProperty("cleanupPrd")
	private BigDecimal cleanupPeriod;

	@JsonProperty("techUserName")
	private String technicalUserName;

}
