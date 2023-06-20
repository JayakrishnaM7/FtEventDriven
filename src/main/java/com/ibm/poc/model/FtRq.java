package com.ibm.poc.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FtRq {
	private String accountId;
	private String paymentTransactionType;
	private String transactionDate;
	private BigDecimal amount;
	private boolean limitCheck;
	public PayeeReference payeeReference;
	public PayerBankReference payerBankReference;
	private String message;
	private boolean panRequired;
	public PayerReference payerReference;
	public PayeeBankReference payeeBankReference;
	public Transaction transaction;
	private Date DateType;
	private BigDecimal PaymentFeesCharges;
	private String PaymentMechanism;
	private String PaymentPurpose;
	public Object RecurringPaymentRecord;
	public Object RecurringPaymentCustomerReference;
	public Object RecurringPaymentReference;

}
