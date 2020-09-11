package com.paymentinfo.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentinfo.bean.Payment;
import com.paymentinfo.exception.TxnNotValidException;
import com.paymentinfo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentResource {
	
	@Autowired
	PaymentService service;

	@GetMapping(path = { "", "/all" })
	public ResponseEntity<List<Payment>> getAllPayments() {
		List<Payment> allTxnDetails = service.findAll();
		return new ResponseEntity<List<Payment>>(allTxnDetails, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{txnId}")
	public ResponseEntity<EntityModel<Payment>> findByTxn(@PathVariable String txnId) {
		Optional<Payment> vehicle = service.findByTxn(txnId);
		return validateTransaction(vehicle);
	}
	
	@GetMapping("/pay")
	public ResponseEntity<Payment> payAmount(@RequestParam Map<String, String> map) {
		if(map.isEmpty()) {
			throw new TxnNotValidException("Transaction Failed !");
		} else {
			String userName = map.get("user");
			String cabNo = map.get("cabNo");
			String amount = map.get("amount");
			Payment paid = service.payAmount(userName, cabNo, Double.parseDouble(amount));
			return new ResponseEntity<Payment>(paid,HttpStatus.CREATED);
		}

	}
	
	private ResponseEntity<EntityModel<Payment>> validateTransaction(Optional<Payment> payment) {
		if (payment.isPresent()) {
			EntityModel<Payment> entity = EntityModel.of(payment.get());
			WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllPayments());
			entity.add(linkBuilder.withRel("all-Transactions"));
			return new ResponseEntity<EntityModel<Payment>>(entity, new HttpHeaders(), HttpStatus.OK);
		} else
			throw new TxnNotValidException("Transaction Not-Valid !");
	}
}
