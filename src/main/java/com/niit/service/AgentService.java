package com.niit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.AgentDetailsDao;
import com.niit.entity.AgentDetails;

@Service
public class AgentService {
	
	private final AgentDetailsDao agentDetailsDao;
	
	public AgentService(AgentDetailsDao agentDetailsDao) {
		super();
		this.agentDetailsDao = agentDetailsDao;
	}

	@Transactional
	public boolean addAgentShiftDetails(AgentDetails agentDetails) {
		return agentDetailsDao.addAgentShiftDetails(agentDetails);
	}

}
