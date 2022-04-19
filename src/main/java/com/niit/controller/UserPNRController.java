package com.niit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.entity.AgentDetails;
import com.niit.entity.FilteredPNRList;
import com.niit.entity.UserPNR;
import com.niit.service.AgentService;
import com.niit.service.PNRService;
import com.niit.utility.PNRHelper;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/")
@Api(tags = "Operations On user PNR API")
public class UserPNRController {
	private final PNRService pnrService;
	
	private final AgentService agentService;
	
	public UserPNRController(PNRService pnrService, AgentService agentService) {
		super();
		this.pnrService = pnrService;
		this.agentService = agentService;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/pnr")
	public ResponseEntity<?> addPNR(@RequestBody UserPNR userPNR) {
		boolean isInserted = pnrService.addPNR(userPNR);
		if (isInserted) {
			String estimatedProcessingTime = new PNRHelper(pnrService).estimatedProcessingTime();
			String response = "Your booking has been queued and will be processed in approx. " + estimatedProcessingTime;
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.ok("PNR not added");
		}
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/agentShift")
	public ResponseEntity<?> addAgentShifts(@RequestBody AgentDetails agentDetails) {
		boolean isInserted = agentService.addAgentShiftDetails(agentDetails);
		if (isInserted) {
			//String estimatedProcessingTime = new PNRHelper(pnrService).estimatedProcessingTime();
			String response = "Added ";
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.ok("agent not added");
		}
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/pnr/{pnr}")
	ResponseEntity<String> getPNR(@PathVariable String pnr) {
		String estimatedTime = new PNRHelper(pnrService).estimatedProcessingTime();
		String response = "Your booking reference " + pnr + " will be processed in approx. " + estimatedTime;
		return new ResponseEntity<String>(response, HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/pnrs")
	ResponseEntity<List<FilteredPNRList>> getpnrlist() {
		List<FilteredPNRList> filteredPNRList = new PNRHelper(pnrService).filteredPNRListMapper();
		return new ResponseEntity<List<FilteredPNRList>>(filteredPNRList, HttpStatus.OK);
	}

}
