package com.ibm.poc.uil;

public class AppConstants {
	
	//TOPIC Names
	public static final String topicFTOUT = "FTout";
	public static final String topicFTIN = "FTin";

	// FTOUT headers
	public static final String topicFTOUTAMLHeader = "aml-publish-out";
	public static final String topicFTOUTPanHeader = "pan-publish-out";
	public static final String topicFTOUTAadhaarHeader = "aadhaar-publish-out";
	public static final String topicFTOUTbalanceHeader = "balance-publish-out";
	public static final String topicFTOUTDailyLimitHeader = "dailylimit-publish-out";

	// FTOUT Listener groups
	public static final String topicFTOUTAMLGroup = "amlmygroup";
	public static final String topicFTOUTPANGroup = "panmygroup";
	public static final String topicFTOUTAADHAARGroup = "aadhaarmygroup";
	public static final String topicFTOUTBALANCEGroup = "balancemygroup";
	public static final String topicFTOUTDAILYLIMITGroup = "dailylimitmygroup";
	
	public static final String topicFTINgroup = "FTingroup";
	public static final String topicFTINheader = "FTinheader";

	
	//FTIN headers
	public static final String topicFTINAMLkHeader = "aml-publish-in";
	public static final String topicFTINPANHeader = "pan-publish-in";
	public static final String topicFTINAadhaarHeader = "aadhaar-publish-in";
	public static final String topicFTINbalanceHeader = "balance-publish-in";
	public static final String topicFTINdailyLimitHeader = "dailylimit-publish-in";
	
	public static String message_success = "success";
	public static String response_status_code = "200";
}
