package com.ibm.poc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PayerReference {
	private String accountName;
	private String mobileNumber;
	private String bankName;
	private String accountType;
	
	
}
