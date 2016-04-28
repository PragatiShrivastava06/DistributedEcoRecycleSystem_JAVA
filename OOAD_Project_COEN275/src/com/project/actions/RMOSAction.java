/**
 * @author Pragati Shrivastava
 * @version 1.0
 */
package com.project.actions;

import java.util.List;

public class RMOSAction {

	RMOSManager rmosManager = new RMOSManager();

	public List<String> getAllRmosId(String userName) {
		List<String> rcmIds = rmosManager.getAllRmosId(userName);
		return rcmIds;
	}

}
