package com.shreyas.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shreyas.project.model.CardDetails;
import com.shreyas.project.service.BankService;

@RestController
public class BankController {

	@Autowired
	BankService service;
	
	/**@Author Shreyas Purkar */

	@PostMapping("/bank/validate/card")
	public String validateCardDetails(@RequestBody CardDetails cardDetails) {
		
		CardDetails checkCard = service.getCardDetails(cardDetails.getCvv());
		if (checkCard.getCardType().equals(cardDetails.getCardType())
				&& checkCard.getCardNumber().equals(cardDetails.getCardNumber())
				&& checkCard.getCardHolderName().equals(cardDetails.getCardHolderName())
				&& checkCard.getExpiryDate().equals(cardDetails.getExpiryDate())
				&& checkCard.getCvv() == cardDetails.getCvv()
				&& checkCard.getAmountLimit() >= cardDetails.getAmountLimit()) {
			String url = "http://localhost:8080/bank/generate/otp";
			RestTemplate template = new RestTemplate();
			boolean response = template.getForObject(url, Boolean.class);
			return "Success";
		} else {
			return "Failed";
		}
	}

	@GetMapping("/bank/generate/otp")
	public boolean generateOtp() {
		System.out.println("123456");
		return true;
	}

	@GetMapping("/bank/validate/otp")
	public boolean validateOtp(@RequestParam("otp") int otp) {
		if (otp == 123456) {
			return true;
		} else {
			return false;
		}
	}
}
