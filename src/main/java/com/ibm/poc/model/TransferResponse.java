
package com.ibm.poc.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@ToString
public class TransferResponse {

	private String accountId;
	private BigDecimal amount;
	private String message;
}
