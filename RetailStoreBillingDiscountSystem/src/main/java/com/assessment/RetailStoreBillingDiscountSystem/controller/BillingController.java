/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.assessment.RetailStoreBillingDiscountSystem.controller;

import com.assessment.RetailStoreBillingDiscountSystem.model.Bill;
import com.assessment.RetailStoreBillingDiscountSystem.model.Product;
import com.assessment.RetailStoreBillingDiscountSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.RetailStoreBillingDiscountSystem.exception.BillingException;
import com.assessment.RetailStoreBillingDiscountSystem.service.BillingService;

@RestController
public class BillingController {

	@Autowired
	@Qualifier("BillingServiceImpl")
	BillingService service;

	public static final String ERROR_MESSAGE = "Years Of Relation will not be applicable to Employee or Affiliated of the store";
	public static final String ERROR_CODE = "223";
	private static final String RESPONSE_STATUS = "Failed";

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public Bill getBillingDetails(@RequestParam User user, @RequestParam Product product,
			@RequestParam double billAmount, @RequestParam(required = false) String yearsOfRelation)
			throws BillingException {
		if (!User.CUSTOMER.equals(user) && yearsOfRelation != null) {
			Bill response = new Bill();
			response.setErrorCode(ERROR_CODE);
			response.setDiscountDetails("");
			response.setErrorMessage(ERROR_MESSAGE);
			response.setStatus(RESPONSE_STATUS);
			return response;
		}

		return service.getBillDetails(user, product, billAmount, yearsOfRelation);
	}
}
