package com.niit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.niit.entity.FilteredPNRList;
import com.niit.entity.UserPNR;

public interface PNRRepository extends JpaRepository<UserPNR, Long> {
	@Query("FROM UserPNR WHERE pnr = ?1")
	UserPNR getByPNR(String pnr);

	@Query("select count(*) FROM UserPNR")
	int getTotalPendingCases();

	/*@Query("FROM UserPNR")
	List<UserPNR> getPNRS();	*/
	
	public static final String FIND_PROJECTS = "SELECT pnr, surname, execClub, alternativeRequired, alternativeDestination,"
			+ "dropDeadDate, linkedPNR, splitPNR, vulnerable FROM pnrdetail";

	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<Object[]> getPNRS();

}