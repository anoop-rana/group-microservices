package com.paymentinfo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentinfo.bean.Payment;

@Repository
public interface PaymentDAOService extends JpaRepository<Payment, Long> {

	Optional<Payment> findByTxnid(String txn);

}
