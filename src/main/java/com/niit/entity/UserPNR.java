package com.niit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pnrdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPNR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pnr_id")
	private Long pnrID;
	
	private String pnr;
	
	private String surname;

	private String phone;
	
	private String email;
	
	private String execClub;
	
	private String destination;
	
	private Boolean alternativeRequired;
	
	private String alternativeDestination;
	
	private Date dropDeadDate;
	
	private String linkedPNR;
	
	private String splitPNR;
	
	private String bagTagNumber;
	
	private Boolean bagBack;
	
	private Boolean vulnerable;
	
}
