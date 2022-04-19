package com.niit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.niit.entity.UserPNR;

@Repository
public class UserPNRDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean addPNR(UserPNR userPnr) {
		String query = "INSERT INTO pnrdetail(pnr,surname,phone,email,execClub,destination,alternativeRequired,alternativeDestination,dropDeadDate,linkedPNR,splitPNR,bagTagNumber,bagBack,vulnerable) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(query,
				new Object[] { userPnr.getPnr(), userPnr.getSurname(), userPnr.getPhone(), userPnr.getEmail(),
						userPnr.getExecClub(), userPnr.getDestination(), userPnr.getAlternativeRequired(),
						userPnr.getAlternativeDestination(), userPnr.getDropDeadDate(), userPnr.getLinkedPNR(),
						userPnr.getSplitPNR(), userPnr.getBagTagNumber(), userPnr.getBagBack(),
						userPnr.getVulnerable() });
		if (result == 1) {
			return true;
		}
		return false;
	}
}
