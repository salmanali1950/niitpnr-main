package com.niit.utility;
import java.util.ArrayList;
import java.util.List;

import com.niit.entity.FilteredPNRList;
import com.niit.entity.UserPNR;
import com.niit.service.PNRService;

public class PNRHelper {
	
	private final PNRService pnrService;
	
	public PNRHelper(PNRService pnrService) {		
		this.pnrService = pnrService;
	}
	
	public List<FilteredPNRList> filteredPNRListMapper(){
		List<Object[]> pNRList = pnrService.getPNRS();
		List<FilteredPNRList> filteredPNRList = new ArrayList<FilteredPNRList>();
		for (Object[] obj : pNRList) {
			FilteredPNRList filteredPNR = new FilteredPNRList();
			filteredPNR.setPnr(obj[0].toString());
			filteredPNR.setSurname(obj[1].toString());
			filteredPNR.setExecClub(obj[2].toString());
			if("true".equalsIgnoreCase(obj[3].toString()) || "t".equalsIgnoreCase(obj[3].toString())){
				filteredPNR.setAlternativeRequired(true);
			}else {
				filteredPNR.setAlternativeRequired(false);
			}
			
			filteredPNR.setAlternativeDestination(obj[4].toString());			
			filteredPNR.setDropDeadDate(obj[5].toString());
			filteredPNR.setLinkedPNR(obj[6].toString());
			filteredPNR.setSplitPNR(obj[7].toString());
			if("true".equalsIgnoreCase(obj[8].toString()) || "t".equalsIgnoreCase(obj[8].toString())){
				filteredPNR.setVulnerable(true);
			}else {
				filteredPNR.setVulnerable(false);
			}
			filteredPNRList.add(filteredPNR);
		}		
		return filteredPNRList;
	}
	
	public String estimatedProcessingTime() {
		int totalPendingCases = pnrService.totalPendingCases();
		int agentsAvailable = 1;
		int averageProcessingTime = 15;
		int estimatedTimeInMin = (totalPendingCases * averageProcessingTime) / agentsAvailable;
		int hours = estimatedTimeInMin / 60;
		int minutes = estimatedTimeInMin % 60;
		String estimatedProcessingTime = hours + " hour(s) " + minutes + " minutes";
		return estimatedProcessingTime;
	}

}
