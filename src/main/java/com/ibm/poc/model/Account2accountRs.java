package com.ibm.poc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Account2accountRs {
	private String responseStatuscode;
	private String message;
	private String accountId;
	private String transferDetails;
}
