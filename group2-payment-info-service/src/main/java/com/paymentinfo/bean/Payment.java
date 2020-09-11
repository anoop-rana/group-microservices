package com.paymentinfo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment")
@Data
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String txnid;
	private String userName;
	@Size(min = 6)
	private String cabNo;
	private Double amount;
	@Past
	private Date paidOn;
	
	public Payment(String txnid, String userName, String cabNo, Double amount, Date paidOn) {
		super();
		this.txnid = txnid;
		this.userName = userName;
		this.cabNo = cabNo;
		this.amount = amount;
		this.paidOn = paidOn;
	}
	
}
