
package com.ibm.poc.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter

@Getter

@ToString
public class TransferRequest {
	private String accountId;
	private String transactionType;
	private String transactionDate;
	private BigDecimal amount;
	private String message;
	private boolean panRequired;

	public PayeeReference payeeReference;
	public PayerBankReference payerBankReference;

	public PayeeBankReference payeeBankReference;
	public Transaction transaction;
}
