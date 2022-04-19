package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.AgentDetailsDao;
import com.niit.dao.UserPNRDao;
import com.niit.entity.AgentDetails;
import com.niit.entity.FilteredPNRList;
import com.niit.entity.UserPNR;
import com.niit.repository.PNRRepository;
import com.niit.utility.PNRHelper;

@Service
public class PNRService {
	@Autowired
	private PNRRepository pnrRepository;

	private final UserPNRDao userPNRDao;
	
	public PNRService(UserPNRDao userPNRDao) {
		super();
		this.userPNRDao = userPNRDao;
	}
	
	@Transactional
	public boolean addPNR(UserPNR userPNR) {
		return userPNRDao.addPNR(userPNR);
	}

	public UserPNR getPNRDetail(String pnr) {
		return pnrRepository.getByPNR(pnr);
	}

	public List<Object[]> getPNRS() {
		return pnrRepository.getPNRS();
	}

	public int totalPendingCases() {
		return pnrRepository.getTotalPendingCases();
	}
}
