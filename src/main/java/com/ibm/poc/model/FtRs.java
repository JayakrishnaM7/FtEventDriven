package com.ibm.poc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FtRs {
	private String successMessage;
	private String errorMessage;
	private String responseStatuscode;
	private String responseMessage;
	private Object TransferResponse;
		
	}
