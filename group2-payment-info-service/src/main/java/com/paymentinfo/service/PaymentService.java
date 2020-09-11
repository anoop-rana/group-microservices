package com.paymentinfo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentinfo.bean.Payment;
import com.paymentinfo.dao.PaymentDAOService;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	PaymentDAOService repo;
	
	@Override
	public List<Payment> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Payment> findByTxn(String txn) {
		return repo.findByTxnid(txn);
	}

	@Override
	public Payment payAmount(String user, String cabNo, double amt) {
		Payment pay = new Payment("TXN-D"+new Date().getDay()+"-H"+new Date().getTime(), user, cabNo, amt, new Date());
		return repo.save(pay);
	}

}
