package com.niit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.niit.entity.AgentDetails;
import com.niit.entity.UserPNR;

@Repository
public class AgentDetailsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addAgentShiftDetails(AgentDetails agentDetails) {
		String query = "INSERT INTO agentsdetail(shiftDate, shiftNumber, agentCount) VALUES(?,?,?)";
		agentDetails.getAgentCount();
		int result = jdbcTemplate.update(query,
				new Object[] { 
						agentDetails.getShiftDate(),
						agentDetails.getShiftNumber(),
						agentDetails.getAgentCount() });
		if (result == 1) {
			return true;
		}
		return false;
	}
}
