package com.paymentinfo.service;

import java.util.List;
import java.util.Optional;

import com.paymentinfo.bean.Payment;

public interface IPaymentService {

	public List<Payment> findAll();

	public Optional<Payment> findByTxn(String txn);

	public Payment payAmount(String user, String cabNo, double amt);

}
