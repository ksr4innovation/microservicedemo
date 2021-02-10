package com.snkit.greetserviceproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import feign.RetryableException;
import feign.Retryer;

public class CustomRetryer implements Retryer {

	Logger logger = LoggerFactory.getLogger(CustomRetryer.class);

	private int retryMaxAttempt;

	private long retryInterval;

	private int attempt = 1;

	public CustomRetryer() {
		this(3, 2000L);
	}
	public CustomRetryer(int retryMaxAttempt, Long retryInterval) {
		this.retryMaxAttempt = retryMaxAttempt;
		this.retryInterval = retryInterval;
	}

	@Override
	public void continueOrPropagate(RetryableException e) {
		logger.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

		if (attempt++ == retryMaxAttempt) {
			throw e;
		}
		try {
			Thread.sleep(retryInterval);
		} catch (InterruptedException ignored) {
			Thread.currentThread().interrupt();
		}

	}

	@Override
	public Retryer clone() {
		logger.info("Feign retry clone ");
		return new CustomRetryer(3, 5000L);
	}

}
