/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.assessment.RetailStoreBillingDiscountSystem.exception;

public class BillingException extends Exception {
	private String message;

	public BillingException() {
		super();
	}

	public BillingException(String message) {
		super();
		this.message = message;
	}

}
