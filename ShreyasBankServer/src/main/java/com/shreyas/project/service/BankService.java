package com.shreyas.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyas.project.model.CardDetails;
import com.shreyas.project.repository.CardDetailsRepository;

/**@Author Shreyas Purkar */

@Service
public class BankService {

	@Autowired
	CardDetailsRepository repository;

	public CardDetails getCardDetails(int cvv) {
		return this.repository.findCardDetails(cvv);
	}
}