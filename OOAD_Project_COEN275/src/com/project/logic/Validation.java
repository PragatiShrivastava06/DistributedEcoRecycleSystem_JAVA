/**
 * @author Pragati Shrivastava
 * @version 1.0
 */
package com.project.logic;

public class Validation
{
	static BackendLogic logic = new BackendLogic();

	public static boolean isNotNullorEmplty(String str) {
		if (str == null || "".equals(str)) {
			return false;
		} else { 
			return true;
		}
	}

	public static boolean isValidRcmId(String rcmId) 
	{
		/* Checking RCMId is valid*/
		return logic.isvalidRcmId(rcmId);
	}
	
	public static boolean isNumber(String s) {
		s = s.trim();
		if (!isNotNullorEmplty(s)) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidMapping(String rcmId, String rmosId){
		/* Checking for mapping between RCM and RMOS*/
		return logic.isMappingRcmIdRmosId(rcmId,rmosId);
		
	}
}
