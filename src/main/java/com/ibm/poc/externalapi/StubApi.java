package com.ibm.poc.externalapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.poc.model.Account2accountRs;
import com.ibm.poc.model.FtRq;
import com.ibm.poc.uil.AppConstants;

@RestController
@RequestMapping("api/v1")
public class StubApi {
	@PostMapping(value = "/fundtransfer")
	public Account2accountRs fundtransferRequest(FtRq fundtransferRq) {
		Account2accountRs rs = new Account2accountRs();
		rs.setAccountId("42093417900");
		rs.setMessage(AppConstants.message_success);
		rs.setResponseStatuscode(AppConstants.response_status_code);
		rs.setTransferDetails("transfer successful");
		return rs;

	}
}
