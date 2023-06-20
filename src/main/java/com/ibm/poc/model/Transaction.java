package com.ibm.poc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Transaction {
	private String amountValue;
	private String currencyCode;
	
}
