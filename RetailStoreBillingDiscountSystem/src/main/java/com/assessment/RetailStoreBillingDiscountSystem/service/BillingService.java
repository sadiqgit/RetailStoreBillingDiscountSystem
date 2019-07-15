/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.assessment.RetailStoreBillingDiscountSystem.service;

import com.assessment.RetailStoreBillingDiscountSystem.exception.BillingException;
import com.assessment.RetailStoreBillingDiscountSystem.model.Bill;
import com.assessment.RetailStoreBillingDiscountSystem.model.Product;
import com.assessment.RetailStoreBillingDiscountSystem.model.User;
import org.springframework.stereotype.Service;

@Service
public interface BillingService {
	Bill getBillDetails(User user, Product product, double billAmount, String yearsOfRelation) throws BillingException;
}
