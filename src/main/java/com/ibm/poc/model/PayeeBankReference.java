package com.ibm.poc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PayeeBankReference {
	
	
	public String bankName;
	public String branchName;
	public String branchLocation;
	public String ifscCode;
	public String currency;
	
	}
