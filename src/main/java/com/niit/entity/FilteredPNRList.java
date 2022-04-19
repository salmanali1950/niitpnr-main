package com.niit.entity;

import java.util.Date;

public class FilteredPNRList {

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getExecClub() {
		return execClub;
	}

	public void setExecClub(String execClub) {
		this.execClub = execClub;
	}

	public Boolean getAlternativeRequired() {
		return alternativeRequired;
	}

	public void setAlternativeRequired(Boolean alternativeRequired) {
		this.alternativeRequired = alternativeRequired;
	}

	public String getAlternativeDestination() {
		return alternativeDestination;
	}

	public void setAlternativeDestination(String alternativeDestination) {
		this.alternativeDestination = alternativeDestination;
	}

	public String getDropDeadDate() {
		return dropDeadDate;
	}

	public void setDropDeadDate(String dropDeadDate) {
		this.dropDeadDate = dropDeadDate;
	}

	public String getLinkedPNR() {
		return linkedPNR;
	}

	public void setLinkedPNR(String linkedPNR) {
		this.linkedPNR = linkedPNR;
	}

	public String getSplitPNR() {
		return splitPNR;
	}

	public void setSplitPNR(String splitPNR) {
		this.splitPNR = splitPNR;
	}

	public Boolean getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(Boolean vulnerable) {
		this.vulnerable = vulnerable;
	}

	private String pnr;
	
	private String surname;

	private String execClub;
		
	private Boolean alternativeRequired;
	
	private String alternativeDestination;
	
	private String dropDeadDate;
	
	private String linkedPNR;
	
	private String splitPNR;
	
	private Boolean vulnerable;	
}
