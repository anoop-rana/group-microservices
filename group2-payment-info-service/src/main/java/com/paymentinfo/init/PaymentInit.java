package com.paymentinfo.init;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.paymentinfo.bean.Payment;
import com.paymentinfo.dao.PaymentDAOService;

@Component
public class PaymentInit implements CommandLineRunner {

	@Autowired
	PaymentDAOService repo;
	
	@Override
	public void run(String... args) throws Exception {
		byte[] array = new byte[16];
	    new Random().nextBytes(array);
	    
		List<Payment> list = List.of(
				new Payment("TXN-D2"+new Date().getDay()+"-H"+new Date().getTime(), "Rahul", "DL-01-45G8", 243.00, new Date()),
				new Payment("TXN-D1"+new Date().getDay()+"-H"+new Date().getTime(), "Rohit", "MP-05-4TG0", 430.00, new Date()),
				new Payment("TXN-D3"+new Date().getDay()+"-H"+new Date().getTime(), "Mohit", "UK-07-25F&", 156.00, new Date()),
				new Payment("TXN-D8"+new Date().getDay()+"-H"+new Date().getTime(), "Roshan", "DL-01-05K8", 822.00, new Date()));
		repo.saveAll(list);
	}

}
